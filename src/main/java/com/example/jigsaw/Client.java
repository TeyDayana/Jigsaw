package com.example.jigsaw;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    private static String playerName;
    private static String winnerName;
    private static PrintWriter writer;
    private static Scanner scanner;
    private static String prevMsg;

    public static void setPlayerName(String playerName) {
        Client.playerName = playerName;
    }

    public static String getPlayerName() {
        return Client.playerName;
    }

    public static String getWinnerName() {
        return winnerName;
    }

    public static void setWinnerName(String winnerName) {
        Client.winnerName = winnerName;
    }

    public static void start(String host, String port) throws IOException {
        socket = new Socket(host, Integer.parseInt(port));
        writer = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(socket.getInputStream());
        System.out.println("connected to server");
        prevMsg = "";
    }

    public static void printToServer(String string) {
        writer.println(string);
    }

    public static String getFromServer() {
        return scanner.nextLine();
    }

    public static boolean waitOthers() {
        writer.println(playerName + " is waiting");
        String string = "";

        while (true) {
            if (scanner.hasNextLine()) {
                string = scanner.nextLine();
                break;
            }
        }

        if (!string.equals(prevMsg)) {
            System.out.println(">>> " + string);
        }
        prevMsg = string;
        return string.equals("0");
    }

    public static boolean waitFinish() {
        writer.println(playerName + " has finished");
        String string = "";
        while (true) {
            if (scanner.hasNextLine()) {
                string = scanner.nextLine();
                break;
            }
        }

        if (string.contains(" won")) {
            setWinnerName(string.substring(0, string.indexOf(" won")));
            if (!string.equals(prevMsg)) {
                System.out.println(">>> " + string);
            }
            prevMsg = string;
            return true;
        }
        return false;
    }
}
