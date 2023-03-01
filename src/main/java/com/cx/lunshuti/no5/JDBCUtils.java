package com.cx.lunshuti.no5;

import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * prepareStatement可以防止sql注入
 */
public class JDBCUtils {
    static String url = "jdbc:mysql://localhost:3306/db_library";//定义数据连接字符串
    static String username = "root";//定义数据库连接用户名
    static String password = "123456";//定义数据库连接用密码

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载MySql8数据库驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {// 建立数据库连接
//补全代码，方法内处理异常
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    @Data
    static class Appointment{
        Integer applyId;
        String roomId;
        String userId;
        String applyStart;
        String applyEnd;
        String applyNeed;
        String applyCreate;

        public Appointment(Integer applyId, String roomId, String userId, String applyStart, String applyEnd, String applyNeed, String applyCreate) {
            this.applyId = applyId;
            this.roomId = roomId;
            this.userId = userId;
            this.applyStart = applyStart;
            this.applyEnd = applyEnd;
            this.applyNeed = applyNeed;
            this.applyCreate = applyCreate;
        }
    }

    public static Appointment getById(Integer id) throws SQLException {
        Appointment appointment = null;
        Connection conn = getConnection();
        String sql = "select * from appointment where applyId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            appointment  = new Appointment(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return appointment;
    }

    public static int update(Appointment appointment) throws SQLException{
        Connection con = getConnection();
        String sql = "UPDATE `appointment` SET `applyId` = ? , roomId = ? , applyStart = ? , applyEnd = ? " +
                ", applyNeed = ?  ,applyCreate = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,appointment.getApplyId());
        ps.setObject(2,appointment.getRoomId());
        ps.setObject(3,appointment.getApplyStart());
        ps.setObject(4,appointment.getApplyEnd());
        ps.setObject(5,appointment.getApplyNeed());
        ps.setObject(6,appointment.getApplyCreate());
        int value = ps.executeUpdate();
        con.close();
        return value;
    }

    public static List<Appointment> page(int pageNum,int pageSize) throws SQLException{
        Connection con = getConnection();
        String sql = "select * from appointment limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,pageSize*(pageNum-1));
        ps.setObject(2,pageSize);
        ResultSet resultSet = ps.executeQuery();
        List<Appointment> list = new ArrayList<>();
        while (resultSet.next()){
            Appointment appointment  = new Appointment(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
            list.add(appointment);
        }
        con.close();
        return list;
    }

    public static int delete(Integer applyId) throws SQLException{
        String sql = "DELETE FROM `appointment` WHERE applyId = ?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        int res = ps.executeUpdate();
        con.close();
        return res;
    }
}