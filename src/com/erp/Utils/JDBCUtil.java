package com.erp.Utils;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static {
        ClassLoader classLoader = JDBCUtil.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    public static Connection getConnection()  {
        //Driver driver;
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if(connection!=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null)
        {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closeall(java.sql.Connection connection, java.sql.PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static int executeUpdate(String sql, Object... params) {
        Connection conn =  null;
        PreparedStatement pstmt = null;
        int n = 0;
        try{
            //获取数据库连接
            conn = JDBCUtil.getConnection();

            //使用手枪发送SQL命令并得到结果
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            for(int i=0;i<params.length;i++){
                pstmt.setObject(i+1, params[i]);
            }
            n = pstmt.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JDBCUtil.closeall(conn, pstmt, null);
        }

        return n;
    }





}
