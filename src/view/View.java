package view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ctrl.front.FrontController;
import model.vo.BbsVO;

public class View {
	private Scanner sc;
	private FrontController fc;
	private BbsVO bv;
	
	public View() {
		sc = new Scanner(System.in);
		fc = new FrontController();
	}
	
	public void mainMenu() {
		int selNum;
		
		while(true) {
			System.out.println("******* MVS BBS *******");
			System.out.println("1. 게시물 작성");
			System.out.println("2. 게시물 수정");
			System.out.println("3. 게시물 삭제");
			System.out.println("4. 게시물 목록 조회");
			System.out.println("5. 게시물 상세 조회");
			System.out.println("99. 프로그램 종료");
			System.out.println("***********************");
			System.out.print("수행할 작업 번호를 선택하세요. : ");
			selNum = sc.nextInt();
			sc.nextLine();
			
			switch (selNum) {
			case 1:
				System.out.println("게시물을 작성합니다.");
				insert();
				break;
				
			case 2:
				System.out.println("게시물을 수정합니다.");
				update();
				break;
				
			case 3:
				System.out.println("게시물을 삭제합니다.");
				delete();
				break;
				
			case 4:
				System.out.println("게시물 목록을 조회합니다.");
				selectAll();
				break;
				
			case 5:
				System.out.println("게시물을 조회합니다.");
				select();
				break;
				
			case 99:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("다시 선택해주세요.");
				break;
			}
		}
	}
	
	public void insert() {
		bv = new BbsVO();
		System.out.print("제목 : ");
		bv.setSubject(sc.nextLine());
		System.out.print("내용 : ");
		bv.setContent(sc.nextLine());
		System.out.print("작성자 : ");
		bv.setWriter(sc.nextLine());
		
		System.out.println((Integer)fc.requestProc(1, bv) == 1 ? "insert success" : "insert fail");
	}
	
	public void update() {
		bv = new BbsVO();
		System.out.print("수정할 게시물 번호를 입력하세요. : ");
		bv.setSeq(sc.nextInt());
		sc.nextLine();
		System.out.print("수정할 내용을 입력하세요. : ");
		bv.setContent(sc.nextLine());
		
		System.out.println((Integer)fc.requestProc(2, bv) == 1 ? "update success" : "update fail");
	}
	
	public void delete() {
		bv = new BbsVO();
		System.out.print("삭제할 게시물 번호를 입력하세요. : ");
		bv.setSeq(sc.nextInt());
		sc.nextLine();
		
		System.out.println((Integer)fc.requestProc(3, bv) == 1 ? "delete success" : "delete fail");
	}
	
	public void selectAll() {
		List<Object> list = (List<Object>) fc.requestProc(4, null);
		Iterator<Object> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(((BbsVO)it.next()).info());
		}
	}
	
	public void select() {
		bv = new BbsVO();
		System.out.print("조회할 게시물 번호를 입력하세요. : ");
		bv.setSeq(sc.nextInt());
		sc.nextLine();
		
		System.out.println(fc.requestProc(4, bv));
	}
}
