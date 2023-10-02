package Dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Basedao {
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getconn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?useSSL=false&serverTimezone=UTC",
					"root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//执行已经准备好的SQL语句
	public static int exectuIUD(String sql,Object[] params) {
		int count =0;
		Connection conn=Basedao.getconn();
		//准备SQL
		PreparedStatement ps=null;
		
		try {
			
			ps=conn.prepareStatement(sql);
			for (int i =0;i<params.length;i++) {
				
			ps.setObject(i+1, params[i]);
			}
			
			count=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Basedao.closeall(null, ps, conn);
		}
		
		return count;
		
	}
	
	//关闭数据库服务连接
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
