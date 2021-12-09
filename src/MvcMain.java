import java.util.Iterator;

import model.sql.OracleDao;
import model.sql.OracleDaoImpl;
import model.vo.BbsVO;

public class MvcMain {

	public static void main(String[] args) {
		OracleDao od = new OracleDaoImpl();
		
		// insert test
//		System.out.println("게시물 작성");
//		BbsVO bv = new BbsVO();
//		bv.setSubject("test1");
//		bv.setContent("test content");
//		bv.setWriter("Cheon");
//		bv.setViewCnt(0);
//		
//		System.out.println(od.insertRow(bv) == 1 ? "success" : "fail");
		
		// select test
//		System.out.println("게시물 조회");
//		BbsVO bv = new BbsVO();
//		bv.setSeq(0);
//		
//		System.out.println(((BbsVO)od.selectRow(bv)).toString());
		
		// select all test
//		System.out.println("전체 게시물 조회");
//		Iterator<Object> it = od.selectRow().iterator(); 
//		
//		while(it.hasNext()) {
//			System.out.println(((BbsVO)it.next()).toString());
//		}
		
		// update test, 실제 적용 시에는 조회된 최신 데이터를 기준으로 update
//		System.out.println("게시물 수정");
//		BbsVO bv = new BbsVO();
//		bv.setSeq(0);
//		bv.setViewCnt(1);
//		
//		System.out.println(od.updateRow(bv) == 1 ? "success" : "fail");
		
		// delete test
		System.out.println("게시물 삭제");
		BbsVO bv = new BbsVO();
		bv.setSeq(0);
		
		System.out.println(od.deleteRow(bv) == 1 ? "success" : "fail");
	}

}
