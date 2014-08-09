package com.oms.db;

import java.sql.*;

public class DateBase {

    static final String DRIVER= "com.mysql.jdbc.Driver";
    static final String USER= "oms";
    static final String PASSWORD= "1qaz2wsx";
    static final String URL= "jdbc:mysql://localhost:3306/oms_db";

    private static Connection getConnection (){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static String executeSQL(String where, String role){
        Connection connection = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement = null;
        String result = null;
        String statementSQL = "select " + where + " from users where roleRef = (select id from roles where roleName  = ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(statementSQL);
            preparedStatement.setString(1, role);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result = resultSet.getString(where);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getLogin (String role){
        return executeSQL("login", role);
    }

    public static String getPassword (String role){
        return executeSQL("password", role);
    }
}
