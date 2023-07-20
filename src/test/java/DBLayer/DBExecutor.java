package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBExecutor {
    public List<Map<String, String>> ExecuteDbCommand(String dbUrl, String dbUserName, String dbPassword, String query) {
        Connection connection = null;
        Statement stmt = null;
        List<Map<String, String>> dbResultList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbUrl, dbUserName, dbPassword);
            connection.setAutoCommit(false);

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            HashMap<String, String> dbRecord = new HashMap<>();
            while (rs.next()) {
                for (int counter = 1; counter < columnCount; counter++) {
                    dbRecord.put(rsmd.getColumnName(counter).toString(), rs.getString(rsmd.getColumnName(counter).toString()));
                }
                dbResultList.add(dbRecord);
                dbRecord = null;
                dbRecord = new HashMap<>();
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dbResultList;
    }
}
