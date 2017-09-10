package model;

public class Room {

	private int id;
	private int userid_1;
	private int userid_2;
	private String status;
	
	public Room(){
	}
	
	public Room(int id, int userid_1, int userid_2, String status){
		this.id = id;
		this.userid_1 = userid_1;
		this.userid_2 = userid_2;
		this.status = status;		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserid_1() {
		return userid_1;
	}

	public void setUserid_1(int userid_1) {
		this.userid_1 = userid_1;
	}
	
	public int getUserid_2() {
		return userid_2;
	}

	public void setUserid_2(int userid_2) {
		this.userid_2 = userid_2;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
