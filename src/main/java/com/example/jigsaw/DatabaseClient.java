package com.example.jigsaw;

import java.sql.*;
import java.time.LocalDateTime;

public class DatabaseClient {
    private static Statement statement;
    public static PreparedStatement preparedStatement;
    private static Connection connection = null;

    public static void create() {
        String dbName = "TOP_TABLE";
        String connectionURL = "jdbc:derby://localhost:1527/" + dbName + ";create=true";
        System.out.println("connetionURL = " + connectionURL);

        String createString = "CREATE TABLE TOP_TABLE  "
                + "(ID INT PRIMARY KEY," +
                "NAME VARCHAR(255), " +
                "GAME_END TIMESTAMP, " +
                "STEPS INT, " +
                "GAME_TIME INT)";

        try {
            connection = DriverManager.getConnection(connectionURL);
            System.out.println("Connected to database");
            statement = connection.createStatement();

            if (!DatabaseUtilities.ifExists(connection)) {
                System.out.println("creating table TOP_TABLE");
                statement.execute(createString);
            }
            preparedStatement = connection.prepareStatement("insert into TOP_TABLE values (?, ?, ?, ?, ?)");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void addSession(String name, int steps, int time) {
        try {
            int gamesCount = print();
            preparedStatement.setInt(1, gamesCount);
            preparedStatement.setString(2, name);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(4, steps);
            preparedStatement.setInt(5, time);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void finish() {
        try {
            preparedStatement.close();
            statement.close();
            connection.close();
            System.out.println("Closed connection");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static int print() throws SQLException {
        int gamesCount = 0;
        ResultSet myWishes = statement.executeQuery("select * from top_table\n" +
                "order by game_end, game_time, steps DESC");
//        ResultSet myWishes = statement.executeQuery("select top(10) name, game_end, steps, game_time from top_table\n" +
//                "order by game_end, game_time, steps");
        connection.setAutoCommit(true);

        while (myWishes.next()) {
            gamesCount++;
            System.out.println(myWishes.getString(2));
            System.out.println(myWishes.getTimestamp(3));
            System.out.println(myWishes.getInt(4));
            System.out.println(myWishes.getInt(5));
        }
        myWishes.close();
        return gamesCount;
    }
}
