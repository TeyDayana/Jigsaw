package com.example.jigsaw;

import java.sql.*;

public class DatabaseUtilities {
    public static boolean ifExists(Connection conTst) throws SQLException {
        boolean result = tableExists(conTst);
        System.out.println("Table \"TOP_TABLE\" exists: " + result );
        try {
            Statement s = conTst.createStatement();
            s.execute("update TOP_TABLE set NAME = 'TEST', GAME_END = CURRENT_TIMESTAMP, " +
                    "STEPS = 5, GAME_TIME = 60 where 1=3");
        } catch (SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05")) {
                return false;
            } else if (theError.equals("42X14") || theError.equals("42821")) {
                System.out.println("WwdChk4Table: Incorrect table definition. Drop table TOP_TABLE and rerun this program");
                throw sqle;
            } else {
                System.out.println("WwdChk4Table: Unhandled SQLException");
                throw sqle;
            }
        }
        return true;
    }

    public static boolean tableExists(Connection connection) throws SQLException {
        System.out.println("printAllTables ---");
        printTables(connection);
        return checkTable(connection, "TOP_TABLE");
    }

    static boolean checkTable(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }

    static void printTables(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});

        while (resultSet.next()) {
            String name = resultSet.getString("TABLE_NAME");
            String schema = resultSet.getString("TABLE_SCHEM");
            System.out.println(name + " on schema " + schema);
        }
    }
}
