import java.sql.*;

public class E2 {
    public static void main(String[] args) {

/*
        result contains the actual data
        ResultSetMetaData information about data
         */
        try(Connection connection=DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.PASSWORD)){
            Statement statement= connection.createStatement();
            String query="Select * from person ";
            ResultSet resultSet=statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
            System.out.println(resultSetMetaData.getColumnCount());
            //i always starts with 1  ! not with zero
            for (int i = 1; i <resultSetMetaData.getColumnCount() ; i++) {
                System.out.print(resultSetMetaData.getColumnName(i)+" ");
            }

            while (resultSet.next()){
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i)+" ");
                }
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
