

import java.sql.*;

/**
 * @author dengzhe
 * @date 2022/6/4
 */
public class MillionInsertTest {

    public static void main(String[] args) {
        getConn();
        insertMillion();
    }

    private static void insertMillion() {
        long startTime = System.currentTimeMillis();
        Connection conn = getConn();
        String sql = "INSERT INTO t_order(code, `type`, shop_id, customer_id, amount, payment_type, status, postage, weight, voucher_id, create_time) " +
                "VALUES (?, 1, 123, 123, 100.00, 1, 1, 100.00, 10, 10, CURRENT_TIMESTAMP);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            for (int j = 0; j < 1000000; j++) {
//                pstmt.setString(1, Math.random() * 1000000 + "");
                pstmt.setString(1, j + "");
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/combat?rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
