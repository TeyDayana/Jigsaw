package com.example.jigsaw;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Server implements Runnable {
    private int playersCount;
    private String playersView;
    private static int playersAmount;
    private static int timeLimit;

    private String winnerName;
    private int maxScore;
    private int minTime;
    private int finishedCount;
    private int exitedCount;

    public static void setPlayersAmount(int playersAmount) {
        Server.playersAmount = playersAmount;
    }

    public static int getPlayersAmount() {
        return playersAmount;
    }

    public static void setTimeLimit(int timeLimit) {
        Server.timeLimit = timeLimit;
    }

    public static int getTimeLimit() {
        return timeLimit;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getFinishedCount() {
        return finishedCount;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getPlayersView() {
        return playersView;
    }

    @Override
    public void run() {
        Random random = new Random();
        Vector<Integer> figureTypes = new Vector<>();
        for (int i = 0; i < 100; ++i) {
            int type = random.nextInt(31);
            figureTypes.add(type);
        }
        System.out.println("Server: got random figure types");

        initializeFields();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server: waiting for clients");
            for (int i = 1; i <= playersAmount; ++i) {
                Socket socket = serverSocket.accept();
                System.out.println("Server: connected to client #" + i);
                new Thread(new ConnectionHandler(this, socket, figureTypes)).start();
            }
        } catch (IOException e) {
            System.out.println("Server: can't open socket");
            System.out.println("Server: finishing...");
        }
    }

    public void addPlayer(String player) {
        if (!playersView.isEmpty()) {
            playersView += ", ";
        }
        playersView += player;
        ++playersCount;
    }

    public void addFinishedPlayer() {
        ++finishedCount;
    }

    public void addExitedPlayer() {
        ++exitedCount;
    }

    public void initializeFields() {
        playersCount %= playersAmount;
        playersView = "";
        finishedCount = 0;
        exitedCount = 0;

        winnerName = "";
        maxScore = 0;
        minTime = -1;
    }
}

class ConnectionHandler extends Server {
    private final Server server;
    private final Socket socket;
    private Vector<Integer> figureTypes;

    private PrintWriter writer;
    private Scanner scanner;
    private String player;
    private int figureCount;

    ConnectionHandler(Server server, Socket socket, Vector<Integer> types) {
        figureCount = 0;
        player = "";
        this.server = server;
        this.socket = socket;
        this.figureTypes = types;
    }

    public void run() {
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(socket.getInputStream());
            player = scanner.nextLine();
            server.addPlayer(player);
            System.out.println("Connection Handler: connected to " + player);

            String string = "";
            String prevString;
            int prevFigure = -1;

            while (scanner.hasNextLine()) {
                prevString = string;
                string = scanner.nextLine();

                if (!string.equals(prevString)) {
                    System.out.println("(from client) " + string);
                }

                if (string.equals("exit")) {
                    break;
                }

                if (string.contains(" is waiting")) {
                    playersWaitingToClient();
                }

                if (string.contains(" finished with ")) {
                    String score = string.substring(string.indexOf("score") + 6, string.indexOf("and") - 1);
                    String time = string.substring(string.indexOf("time") + 5);
                    playerFinished(Integer.parseInt(score), Integer.parseInt(time));
                }

                if (string.contains(" has finished")) {
                    if (server.getPlayersCount() - server.getFinishedCount() == 0) {
                        writer.println(server.getWinnerName() + " won");
                    } else {
                        writer.println("wait");
                    }
                }

                if (string.contains(" is ready to play again")) {
                    server.initializeFields();
                    server.addPlayer(player);
                }

                if (string.equals("players names")) {
                    writer.println(server.getPlayersView());
                }

                if (string.equals("time limit")) {
                    writer.println(Server.getTimeLimit());
                }

                if (string.equals("next figure type")) {
                    int figure = figureTypes.get(figureCount);
                    writer.println(figure);
                    if (figure != prevFigure) {
                        System.out.println("Connection Handler: figure type " + figure);
                    }
                    ++figureCount;
                }

                if (string.equals("bye")) {
                    server.addExitedPlayer();
                }


            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Connection Handler: " + e);
        }
    }

    private void playersWaitingToClient() {
        int need = getPlayersAmount();
        int got = server.getPlayersCount();
        writer.println(need - got);
    }

    private void playerFinished(int score, int time) {
        if (server.getMaxScore() < score || server.getMinTime() == -1
                || (server.getMaxScore() == score && server.getMinTime() > time)) {
            System.out.println(player + " wins now");
            server.setWinnerName(player);
            server.setMaxScore(score);
            server.setMinTime(time);
        }
        DatabaseClient.addSession(player, score, time);
        server.addFinishedPlayer();
    }
}
