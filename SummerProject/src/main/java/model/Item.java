package model;

public class Item {

	private int id;
	private int category;
	private double blood;
	private double attack;
	private double speed;
	private int coin;
	private String description;
	private int characterid;
	private String path;

	public Item(){
	}
	
	public Item( int id, int category, double blood, double attack, double speed, int coin, String description) {
		this.id = id;
		this.category = category;
		this.blood = blood;
		this.attack = attack;
		this.speed = speed;
		this.coin = coin;
		this.description = description;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	public double getBlood() {
		return blood;
	}

	public void setBlood(double blood) {
		this.blood = blood;
	}
	
	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public int getCoin(){
		return coin;
	}
	
	public void setCoin(int coin){
		this.coin = coin;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getCharacterid(){
		return characterid;
	}
	
	public void setCharacterid(int characterid){
		this.characterid = characterid;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setPath(String path){
		this.path = path;
	}

	
}
