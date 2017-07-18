package model;

public class GameData {

	private int id;
	private int rankpoint;
	private int coin;
	private int singlegame;
	private int singlewin;
	private int rankgame;
	private int rankwin;
	private int teamgame;
	private int teamwin;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	private int item7;
	
	public GameData(){
	}
	
	public GameData(int id) {
		this.id=id;
	}

	public GameData(int id, int rankpoint, int coin, int singlegame, int singlewin, int rankgame, int rankwin, int teamgame, int teamwin,
			int item1, int item2, int item3, int item4, int item5, int item6, int item7) {
		this.id = id;
		this.rankpoint = rankpoint;
		this.coin = coin;
		this.singlegame = singlegame;
		this.singlewin = singlewin;
		this.rankgame = rankgame;
		this.rankwin = rankwin;
		this.teamgame = teamgame;
		this.teamwin = teamwin;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.item7 = item7;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRankpoint() {
		return rankpoint;
	}

	public void setRankpoint(int rankpoint) {
		this.rankpoint = rankpoint;
	}
	
	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getSinglegame() {
		return singlegame;
	}

	public void setSinglegame(int singlegame) {
		this.singlegame = singlegame;
	}

	public int getSinglewin() {
		return singlewin;
	}

	public void setSinglewin(int singlewin) {
		this.singlewin = singlewin;
	}
	
	
	public int getRankgame() {
		return rankgame;
	}

	public void setRankgame(int rankgame) {
		this.rankgame = rankgame;
	}

	public int getRankwin() {
		return rankwin;
	}

	public void setRankwin(int rankwin) {
		this.rankwin = rankwin;
	}
	
	
	public int getTeamgame() {
		return teamgame;
	}

	public void setTeamgame(int teamgame) {
		this.teamgame = teamgame;
	}

	public int getTeamwin() {
		return teamwin;
	}

	public void setTeamwin(int teamwin) {
		this.teamwin = teamwin;
	}
	
	public int getItem1() {
		return item1;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}
	
	public int getItem2() {
		return item2;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}
	
	public int getItem3() {
		return item3;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
	}
	
	public int getItem4() {
		return item4;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public int getItem5() {
		return item5;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}
	
	public int getItem6() {
		return item6;
	}

	public void setItem6(int item6) {
		this.item6 = item6;
	}
	
	public int getItem7() {
		return item7;
	}

	public void setItem7(int item7) {
		this.item7 = item7;
	}
	
}
