import java.util.Iterator;
import java.util.List;

import ctrl.front.FrontController;
import model.vo.BbsVO;

public class BbsMain {

	public static void main(String[] args) {
		FrontController fc = new FrontController();
		
		// int seq, String subject, String content, String writer, String regDate, int viewCnt
		// insert
//		BbsVO bv = new BbsVO();
//		bv.setSubject("20211210_test01");
//		bv.setContent("test content");
//		bv.setWriter("Cheon");
//		bv.setViewCnt(0);
//		
//		System.out.println((Integer)fc.requestProc(1, bv) == 1 ? "insert success" : "insert fail");
		
		// update
//		BbsVO bv = new BbsVO();
//		bv.setSeq(22);
//		bv.setViewCnt(2);
//		
//		System.out.println((Integer)fc.requestProc(2, bv) == 1 ? "update success" : "update fail");
		
		// delete
//		BbsVO bv = new BbsVO();
//		bv.setSeq(23);
//		System.out.println((Integer)fc.requestProc(3, bv) == 1 ? "delete success" : "delete fail");
		
		// select all
//		List<Object> list = (List<Object>) fc.requestProc(4, null);
//		Iterator<Object> it = list.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		// select
		BbsVO bv = new BbsVO();
		bv.setSeq(22);
		
		System.out.println(fc.requestProc(4, bv));
	}

}
