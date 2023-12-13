import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E3 {

    /*To connect our database we need dbURL, port, username, password, jdbc ipi address, if yuo don't know ask DBA= DATABASE ADMINISTRATOR
     * CLOSE RESOURCES AS SOON AS U DONE*/



        public static void main(String[] args) {
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD);) {

                Statement statement = connection.createStatement();
                String query = "Select * from employee";
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + " ");
                }
                List<Map<String, String>> tableData=new ArrayList<>();
                while (rs.next()){
                    Map<String, String>rowMap=new HashMap<>();
                    for (int i= 1; i<=rsmd.getColumnCount();i++){
                        String key=rsmd.getColumnName(i);
                        String value=rs.getString(i);
                        rowMap.put(key,value);
                    }
                    tableData.add(rowMap);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        }

