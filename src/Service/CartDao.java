package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.Basedao;
import onlineshop_enity.CART;
import onlineshop_enity.CATEGORY;

public class CartDao {
	public static  int insert(CART cart) {
		String sql="insert into CART values(null,?,?,?,?,?,?,?,1)";
		
		Object[] params= {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
		};
		
		return Basedao.exectuIUD(sql, params);
	}

	public static ArrayList<CART> getCart(String uid) {
		ArrayList<CART> list =new ArrayList<CART>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select * from CART where cart_u_id= ? and cart_status=1 order by cart_id desc";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uid);		
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				CART cart=new CART(
						rs.getInt("cart_id"),
						rs.getString("cart_p_filename"),
						rs.getString("cart_p_name"),
						rs.getFloat("cart_p_price"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_p_stock"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_u_id"),
						rs.getInt("cart_status"));
				
				list.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
	}
//用于在添加购物车时检查有没有相同商品
	public static CART getCartShop(String uid, String pid) {
		CART cart =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select * from CART where cart_u_id= ? and cart_p_id =? and cart_status=1 order by cart_id desc";
				ps=conn.prepareStatement(sql);
				ps.setString(1, uid);
				ps.setInt(2, Integer.parseInt(pid));
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				cart=new CART(
						rs.getInt("cart_id"),
						rs.getString("cart_p_filename"),
						rs.getString("cart_p_name"),
						rs.getFloat("cart_p_price"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_p_stock"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_u_id"),
						rs.getInt("cart_status"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return cart;
	}

	public static int updatenum(int cart_id, int newcount) {
		String sql="update CART set cart_quantity=? where cart_id =?";
		Object[] params= {newcount,cart_id};
		
		return Basedao.exectuIUD(sql, params);
		
	}

	
	//删除购物车中的单条记录
	public static int deletesingle(int id) {
		String sql="delete from cart where cart_id=?";
		
		Object[] params= {id};
		return Basedao.exectuIUD(sql, params);
		
		
	}

	public static CART GetCartOrder(String id) {
		CART cart =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select * from CART where cart_id= ? and cart_status=1 order by cart_id desc";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				cart=new CART(
						rs.getInt("cart_id"),
						rs.getString("cart_p_filename"),
						rs.getString("cart_p_name"),
						rs.getFloat("cart_p_price"),
						rs.getInt("cart_quantity"),
						rs.getInt("cart_p_stock"),
						rs.getInt("cart_p_id"),
						rs.getString("cart_u_id"),
						rs.getInt("cart_status"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return cart;
	}

	public static int changestatus(int pid) {
		String sql="update CART set cart_status=2 where cart_id =? ";
		Object[] params= {pid};
		
		return Basedao.exectuIUD(sql, params);
	
	}

	

	
}
