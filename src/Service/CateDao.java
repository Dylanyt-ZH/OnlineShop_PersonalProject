package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.Basedao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.USER;

public class CateDao {
	//获取所有分类
	public static ArrayList<CATEGORY> selectALL(){
		ArrayList<CATEGORY> list =new ArrayList<CATEGORY>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="";
			
				sql="select * from category";
				ps=conn.prepareStatement(sql);
			
			
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				CATEGORY cate=new CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_NAME")

						);
				
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
		
		
	}

	public static int insert(CATEGORY cate) {
		
			String sql="insert into category values(null,?,?)";
			Object[] params= {
					cate.getCATE_NAME(),
					cate.getCATE_PARENT_NAME()
					};
			return Basedao.exectuIUD(sql, params);
		
		
	}

	public static CATEGORY selectById(int id) {
		CATEGORY cate =null;
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql="select* from category  where CATE_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);		
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				cate=new CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_NAME")				
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return cate;
	}

	public static int update(CATEGORY cate) {
		String sql="update category set CATE_NAME =?, CATE_PARENT_NAME =? where CATE_ID=?";
		Object[] params= {
				
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_NAME(),
				cate.getCATE_ID()
				};
		
		
		return Basedao.exectuIUD(sql, params);
	}

	//此函数用于首页表头的夫分类与子分类
	public static ArrayList<CATEGORY> selectCate(String flag){
		ArrayList<CATEGORY> list =new ArrayList<CATEGORY>();
		ResultSet rs=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		
		try {
			String sql=null;
			
			if(flag!=null&&flag.equals("father")) {
				sql="select * from category where CATE_PARENT_NAME =0";
			}
			else {
				sql="select * from category where CATE_PARENT_NAME !=0";
			}	
			ps=conn.prepareStatement(sql);
			//执行准备好的SQL语句
			rs=ps.executeQuery();
			while(rs.next()) {
				CATEGORY cate=new CATEGORY(
						rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_NAME")

						);
				
				list.add(cate);
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
