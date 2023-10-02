package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import Dao.Basedao;
import onlineshop_enity.USER;

public class UserDao {
	
	
	
	//插入用户方法 新增用户
	public static int insert(USER u) {
		String sql="insert into user_list values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params= {
				u.getUSER_ID(),
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS()};
		return Basedao.exectuIUD(sql, params);
	}
	
	//获取用户总数以及分页面
	public static int[] totalpage(int count,String keyword) {
		int [] arr = {0,1};//0代表总记录数，1代表页数
		Connection conn= Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;

		//搜索用户sql语句
		try {
			String sql;
			if(keyword!=null) {
				sql="select count(*) from USER_LIST where USER_ID like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				
			}else
			{
				sql="select count(*) from USER_LIST";
				ps=conn.prepareStatement(sql);
			}
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				
				if(arr[0]%count==0) {
				arr[1]=arr[0]/count;
				}
				else {
					arr[1]=arr[0]/count+1;
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return arr;
	}
	
	//查询所有用户 用于后台显示所有用户信息
	public static ArrayList<USER> selectALL(int cpage ,int count,String keyword){
		ArrayList<USER> list =new ArrayList<USER>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="";
			if(keyword!=null) {
				sql="select * from USER_LIST where USER_ID like ? order by USER_BIRTHDAY desc limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}
			else{
				sql="select * from USER_LIST order by USER_BIRTHDAY desc limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
				
			}
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				USER u=new USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
		
	}

	//查找用户，用于toupdateuser
	public static USER selectByID(String id) {
		USER u =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday from USER_LIST m where USER_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);		
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}

	//更新用户信息
	public static int update(USER u) {
		String sql="update USER_LIST set USER_NAME =?, USER_PASSWORD =?,USER_SEX =?,USER_BIRTHDAY =DATE_FORMAT(?,'%Y-%m-%d'),USER_IDENITY_CODE =?,USER_EMAIL =?,USER_MOBILE =?,USER_ADDRESS =?,USER_STATUS =? where USER_ID =?";
		Object[] params= {
				
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
				u.getUSER_ID()};
		
		
		return Basedao.exectuIUD(sql, params);
	}

	//删除用户
	public static int del (String id) {
		String sql="delete from USER_LIST where USER_ID=? and USER_STATUS=1";

		Object[] params= {id} ;
		
		return Basedao.exectuIUD(sql, params);
	}

	//判断数据库中该用户名是否被注册，如果未被注册 int count=0
	public static int selectByname(String id) {
		int count =0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;
		//搜索用户sql语句
		try {
			String sql="select count(*) from USER_LIST where USER_ID =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
	//通过查询username和password去判断数据库中有没有此用户，如果有返回值count>0，如果没有，count=0
	public static int selectByNP(String username, String password) {
		int count=0;
		Connection conn= Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;
		//搜索用户sql语句
		try {
			String sql="select count(*) from USER_LIST where USER_ID =? and USER_PASSWORD =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	
	//通过用户名和密码查询用户，返回整个用户实体 用于登录
	public static USER Getsimple(String username, String password) {
		USER u =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday from USER_LIST m where USER_ID=? and USER_PASSWORD =?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}


//	public static void main(String arg[]) {
//		ArrayList<String> countmain =selectByname("hello");
//		//System.out.println(countmain);
//	}
// 	
}
