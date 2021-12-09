package model.vo;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private int point;
	
	public UserVO(String id, String pwd, String name, int point) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", point=" + point + "]";
	}

}
