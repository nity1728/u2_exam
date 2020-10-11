package com.exam.basedao;

import java.sql.*;
import java.util.Objects;

public class BaseDao {

    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    //连接数据库
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ten?useUnicode=true&" +
                    "characterEncoding=utf-8","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return con;
        }
    }

    //查询操作
    public ResultSet exeuQuery(String sql, Object...objects){
        getCon();
        try {
            ps=con.prepareStatement(sql);
            if(objects!=null){
                for(int i=0;i<objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return rs;
        }
    }

    //增删改操作
    public int exeuUpdate(String sql,Object...objects){
        getCon();
        int index=-1;
        try {
            ps=con.prepareStatement(sql);
            if(objects!=null){
                for(int i=0;i<objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
            }
            index=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return index;
        }
    }

    //关闭连接
    public void getClose(){
        try {
            if(rs!=null) {
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if (con!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
