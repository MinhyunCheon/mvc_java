import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.vo.UserVO;

public class OracleMain {
	/**
	 * JDBC 절차(java.sql.*)
	 * ORM? VO와 Table을 Mapping
	 * 1 ~ 6의 과정에는 예외 상황이 발생할 가능성 존재
	 * try - catch - finally를 통해 처리
	 * 1. Driver loading
	 * 2. DB Connection
	 * 3. Statement(Query) - SQL을 담을 그릇
	 * 4. execute(DML[return x], SELECT)
	 * - SELECT -> executeQuery() -> return ResultSet
	 * - DML -> executeUpdate() -> return int(1 or 0, 성공 여부)
	 * 5. ResultSet(결과 집합)
	 * 6. close
	 */
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER = "hr";
	public static final String PWD = "hr";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			System.out.println("1. Driver loading");
			
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("2. DB Connection");
			
			// insert test
//			UserVO user = new UserVO("user01", "user01", "Cheon", 1000);
//			String insertSQL = "INSERT INTO USER_TBL VALUES(?, ?, ?, ?)";
//			PreparedStatement psmt = conn.prepareStatement(insertSQL);
//			psmt.setString(1, user.getId());
//			psmt.setString(2, user.getPwd());
//			psmt.setString(3, user.getName());
//			psmt.setInt(4, user.getPoint());
//			System.out.println("3. Statement(Query)");
//			
//			System.out.println(psmt.executeUpdate() == 1 ? "실행 성공" : "실행 실패");
//			System.out.println("insert : " + user);
//			System.out.println("4. execute");
			
			// select test
//			String selectSQL = "SELECT * FROM USER_TBL";
//			PreparedStatement psmt = conn.prepareStatement(selectSQL);
//			ResultSet result = psmt.executeQuery();
//			List<UserVO> list = new ArrayList<UserVO>();
//			
//			while(result.next()) {
//				UserVO user = new UserVO(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
//				list.add(user);
//			}
//			
//			Iterator<UserVO> it = list.iterator();
//			while(it.hasNext()) {
//				UserVO temp = it.next();
//				
//				System.out.println(temp);
//			}
			
			// select where test
			String selectSQL = "SELECT * FROM USER_TBL WHERE ID = ?";
			PreparedStatement psmt = conn.prepareStatement(selectSQL);
			psmt.setString(1, "user01");
			ResultSet result = psmt.executeQuery();
			UserVO user = null;
			
			while(result.next()) {
				user = new UserVO(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
//				System.out.println("ID : " + result.getString(1));
//				System.out.println("PWD : " + result.getString(2));
//				System.out.println("NAME : " + result.getString(3));
//				System.out.println("POINT : " + result.getInt(4));
			}
			
			if(user == null) {
				System.out.println("존재하지 않는 아이디입니다.");
			} else {
				System.out.println(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
