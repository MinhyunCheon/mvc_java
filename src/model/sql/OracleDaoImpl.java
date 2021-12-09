package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.BbsVO;

public class OracleDaoImpl implements OracleDao {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER = "hr";
	public static final String PWD = "hr";
	
	public OracleDaoImpl() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertRow(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int flag = 0;
		BbsVO bv = null;
		
		try {
			bv = (BbsVO)obj;
			
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("INSERT INTO BBS_TBL VALUES (BBS_SEQ.NEXTVAL,?,?,?,SYSDATE,?)");
			psmt.setString(1, bv.getSubject());
			psmt.setString(2, bv.getContent());
			psmt.setString(3, bv.getWriter());
			psmt.setInt(4, bv.getViewCnt());
			
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return flag;
	}

	@Override
	public int updateRow(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int flag = 0;
		BbsVO bv = (BbsVO)obj;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("UPDATE BBS_TBL SET VIEWCNT = ? WHERE SEQ = ?");
			psmt.setInt(1, bv.getViewCnt() + 1);
			psmt.setInt(2, bv.getSeq());
			
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public int deleteRow(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int flag = 0;
		BbsVO bv = (BbsVO)obj;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("DELETE BBS_TBL WHERE SEQ = ?");
			psmt.setInt(1, bv.getSeq());
			
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public List<Object> selectRow() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Object> list = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("SELECT * FROM BBS_TBL");
			
			rs = psmt.executeQuery();
			list = new ArrayList<Object>();
			while(rs.next()) {
				list.add(new BbsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public Object selectRow(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Object o = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("SELECT * FROM BBS_TBL WHERE SEQ = ?");
			psmt.setInt(1, ((BbsVO)obj).getSeq());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				o = new BbsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return o;
	}
}
