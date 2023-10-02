package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.Basedao;
import onlineshop_enity.ORDER;
import onlineshop_enity.PRODUCT;
import onlineshop_enity.USER;

public class OrderDao {

	public static int insert(ORDER order) {
		
			String sql="insert into ORDER_list values(null,?,?,NOW(),?,?,?,null)";
			
			Object[] params= {
					order.getProduct_id(),
					order.getBuyer_id(),
					order.getProduct_amount(),
					order.getOrder_status(),
					order.getOrder_delivery()
			};
			
			return Basedao.exectuIUD(sql, params);
		}

	public static int[] totalpage(int count, String keyword) {
		int [] arr = {0,1};//0代表总记录数，1代表页数
		Connection conn= Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;

		//搜索用户sql语句
		try {
			String sql;
			if(keyword!=null) {
				sql="select count(*) from order_list where buyer_id like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				
			}else
			{
				sql="select count(*) from order_list";
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

	public static ArrayList<ORDER> selectAll(int cpage, int count, String keyword) {
		ArrayList<ORDER> list =new ArrayList<ORDER>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="";
			if(keyword!=null) {
				sql="select * from order_list where buyer_id like ? order by PUACHER_TIME desc limit ?,? ";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}
			else{
				sql="select * from order_list  order by PUACHER_TIME desc limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
				
			}
			//执行准备好的SQL语句
			
			rs=ps.executeQuery();
			while(rs.next()) {
				ORDER o=new ORDER(
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getString("buyer_id"),
						rs.getString("puacher_time"),
						rs.getInt("product_amount"),
						rs.getInt("product_status"),
						rs.getString("order_delivery"),
						rs.getString("order_delivery_num")
						);
				
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static ORDER selectbyid(String id) {
		ORDER o =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select * from order_list where order_id=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);		
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				o=new ORDER(
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getString("buyer_id"),
						rs.getString("puacher_time"),
						rs.getInt("product_amount"),
						rs.getInt("product_status"),
						rs.getString("order_delivery"),
						rs.getString("order_delivery_num")
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return o;
	}

	public static int adddeliverynum(String id, String num) {
		String sql="update order_list set order_delivery_num=? , product_status=2 where order_id =?";
		Object[] params= {num,id};
		
		
		return Basedao.exectuIUD(sql, params);
	}

	public static ArrayList<ORDER> selectbyuid(String uid) {
		ArrayList<ORDER> list =new ArrayList<ORDER>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="";
			sql="select * from order_list  where buyer_id =? order by PUACHER_TIME desc ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,uid);
			//执行准备好的SQL语句
			
			rs=ps.executeQuery();
			while(rs.next()) {
				ORDER o=new ORDER(
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getString("buyer_id"),
						rs.getString("puacher_time"),
						rs.getInt("product_amount"),
						rs.getInt("product_status"),
						rs.getString("order_delivery"),
						rs.getString("order_delivery_num")
						);
				
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static int buyerrecive(String id) {
		String sql="update order_list set  product_status=3 where order_id =?";
		Object[] params= {id};
		
		
		return Basedao.exectuIUD(sql, params);
		
	}
		
	

}
