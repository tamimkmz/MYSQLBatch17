package org.syntax;

import java.sql.*;

/*ip means id protecol
* 3306 is room# */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*jdbc->api that we are planing to */
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";


        try {
           Connection connection= DriverManager.getConnection(dbURL,userName,password);
           Statement statement =connection.createStatement();
            String query="select * from person";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                String firstname=resultSet.getString("firstname");
                int age=resultSet.getInt("age");
                String city=resultSet.getString("city");
                System.out.println(firstname+" "+age+" "+city);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}