package model.vo;

public class BbsVO extends FilterVO {
	private int seq;
	private String subject;
	private String content;
	private String writer;
	private String regDate;
	private int viewCnt;
	
	public BbsVO() {
		
	}
	
	public BbsVO(int seq, String subject, String content, String writer, String regDate, int viewCnt) {
		super();
		this.seq = seq;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	@Override
	public String toString() {
		return "BbsVO [seq=" + seq + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	
	public String info() {
		return "BbsVO [seq=" + seq + ", subject=" + subject + ", writer=" + writer
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}

}
