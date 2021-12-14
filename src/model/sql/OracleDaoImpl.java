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
			psmt = conn.prepareStatement("INSERT INTO BBS_TBL VALUES (BBS_SEQ.NEXTVAL,?,?,?,SYSDATE,0)");
			psmt.setString(1, bv.getSubject());
			psmt.setString(2, bv.getContent());
			psmt.setString(3, bv.getWriter());
			
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// conn의 null 여부를 판단하지 않고, conn 라인에서 오류가 발생할 경우
			// null.close()를 호출하기 때문에 NullPointer 예외가 추가로 발생
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
			psmt = conn.prepareStatement("UPDATE BBS_TBL SET CONTENT = ?, REGDATE = SYSDATE WHERE SEQ = ?");
			psmt.setString(1, bv.getContent());
			psmt.setInt(2, bv.getSeq());
			
			flag = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
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
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	@Override
	public List<Object> selectCustom(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Object> list = null;
		BbsVO bv = (BbsVO)obj;
		String qString = bv.getSearchCondition() + " LIKE '%" + bv.getSearchKeyword() + "%'";
		System.out.println(qString);
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("SELECT SEQ, SUBJECT, CONTENT, WRITER, TO_CHAR(REGDATE, 'YYYY-MM-DD'), VIEWCNT FROM BBS_TBL "
					+ "WHERE "
					+ qString
					+ " "
					+ "ORDER BY SEQ DESC");
			
			rs = psmt.executeQuery();
			list = new ArrayList<Object>();
			while(rs.next()) {
				list.add(new BbsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<Object> selectRow() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Object> list = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("SELECT SEQ, SUBJECT, CONTENT, WRITER, TO_CHAR(REGDATE, 'YYYY-MM-DD'), VIEWCNT FROM BBS_TBL ORDER BY SEQ DESC");
			
			rs = psmt.executeQuery();
			list = new ArrayList<Object>();
			while(rs.next()) {
				list.add(new BbsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	private void updateViewCnt(Object obj) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			psmt = conn.prepareStatement("UPDATE BBS_TBL SET VIEWCNT = VIEWCNT + 1 WHERE SEQ = ?");
			psmt.setInt(1, ((BbsVO)obj).getSeq());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
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
			updateViewCnt(obj);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				o = new BbsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return o;
	}
}
