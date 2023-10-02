package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.Basedao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.PRODUCT;

public class ProductDao {

	public static int insert(PRODUCT p) {
	//插入商品	
		String sql="insert into product values(null,?,?,?,?,?,?,?)";
		Object[] params= {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_PICTURE()
				};
		return Basedao.exectuIUD(sql, params);
	
	
}
	//分页查询
	public static ArrayList<PRODUCT> selectALL(int cpage, int count, String keyword) {
		ArrayList<PRODUCT> list =new ArrayList<PRODUCT>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="";
			if(keyword!=null) {
				sql="select * from PRODUCT where PRODUCT_NAME like ? limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}
			else{
				sql="select * from PRODUCT  limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
				
			}
			//执行准备好的SQL语句
			
			rs=ps.executeQuery();
			while(rs.next()) {
				PRODUCT p=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")
						);
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	
	//查找单个product
	public static PRODUCT selectById(int id) {
		PRODUCT product =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select* from product  where PRODUCT_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);		
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				product=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")				
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return product;
	}
	//更新product
	public static int update(PRODUCT p) {
		String sql="update product set PRODUCT_NAME =?, PRODUCT_DESCRIPTION =?,PRODUCT_PRICE =?,PRODUCT_STOCK =? ,PRODUCT_FID =?,PRODUCT_CID =?,PRODUCT_PICTURE =? where PRODUCT_ID = ? ";
		Object[] params= {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_PICTURE(),
				p.getPRODUCT_ID()
				
				};
		
		
		return Basedao.exectuIUD(sql, params);
	}
	//删除product
	public static int del(String id) {
		String sql="delete from PRODUCT where PRODUCT_ID=? ";

		Object[] params= {id} ;
		
		return Basedao.exectuIUD(sql, params);
	}
	//后台分页查找，获取总页数
	public static int[] totalpage(int count, String keyword) {
		int [] arr = {0,1};//0代表总记录数，1代表页数
		Connection conn= Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;

		//搜索用户sql语句
		try {
			String sql;
			if(keyword!=null) {
				sql="select count(*) from PRODUCT where PRODUCT_NAME like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				
			}else
			{
				sql="select count(*) from PRODUCT";
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
	//根据fid查找
	public static ArrayList<PRODUCT> selectbyfid(int id) {
		ArrayList<PRODUCT> list =new ArrayList<PRODUCT>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			
			String sql="select * from PRODUCT  where PRODUCT_FID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				PRODUCT p=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")
						);
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static ArrayList<PRODUCT> selectbycid(int id) {
		ArrayList<PRODUCT> list =new ArrayList<PRODUCT>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			
			String sql="select * from PRODUCT where PRODUCT_CID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				PRODUCT p=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")
						);
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	//直接查询所有product，用于最近浏览功能
	public static ArrayList<PRODUCT> selectAllById(ArrayList<Integer> ids) {
		ArrayList<PRODUCT> lastview =new ArrayList<PRODUCT>();
		PRODUCT p=null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			
			for(int i=0;i<ids.size();i++) {
			
			String sql="select * from PRODUCT where PRODUCT_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ids.get(i));
			
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				 p=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")
						);
				
				lastview.add(p);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
	
		return lastview;
	}

	public static int updatestock(int pid, int stock) {
		String sql="update product set PRODUCT_STOCK =? where PRODUCT_ID = ? ";
		Object[] params= {
				stock,
				pid
				};
		
		
		return Basedao.exectuIUD(sql, params);
	}
	//查询所有商品
	public static ArrayList<PRODUCT> selectALLbyid() {
		ArrayList<PRODUCT> list =new ArrayList<PRODUCT>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select * from PRODUCT";
			ps=conn.prepareStatement(sql);
			//执行准备好的SQL语句
			
			rs=ps.executeQuery();
			while(rs.next()) {
				PRODUCT p=new PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getFloat("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_PICTURE")
						);
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	
		
	}


