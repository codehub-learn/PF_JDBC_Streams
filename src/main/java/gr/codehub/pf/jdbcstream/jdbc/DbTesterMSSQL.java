package gr.codehub.pf.jdbcstream.jdbc;

import java.sql.*;

public class DbTesterMSSQL {

    public static void runDatabaseConnectionTest() throws MyBusinessException {
        Connection conn = null;
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2017";
            String user = "sa";
            String password = "password";
            conn = DriverManager.getConnection(dbURL, user, password);
            if (conn != null) {
                // showConnectionData(conn);
                Statement stmt = conn.createStatement();
                String SQL = getSQLStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    showResultData(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyBusinessException("MyBusinessException: Reading the data is not supported right now");
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void showResultData(ResultSet rs) throws SQLException {
        System.out.println(rs.getString("FirstName") + " "
                + rs.getString("LastName") +
                rs.getString("JobTitle"));
    }

    private static String getSQLStatement() {
        String SQL = "" +
                "select " +
                "     p.FirstName, p.LastName, e.JobTitle " +
                "from " +
                "     HumanResources.Employee as e " +
                "join " +
                "     Person.Person as p " +
                "on " +
                "     e.BusinessEntityID = p.BusinessEntityID " +
                "where " +
                "     p.FirstName='Ken'";
        return SQL;
    }

    private static void showConnectionData(Connection conn) throws SQLException {
        DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
        System.out.println("Driver name: " + dm.getDriverName());
        System.out.println("Driver version: " + dm.getDriverVersion());
        System.out.println("Product name: " + dm.getDatabaseProductName());
        System.out.println("Product version: " + dm.getDatabaseProductVersion());
    }

    public static void main(String[] args) {
        try {
            runDatabaseConnectionTest();
        } catch (MyBusinessException e) {
            System.err.println("\n*\n*\n* " + e.getMessage() + "\n*\n*\n");
            e.printStackTrace();
        }
    }
}
