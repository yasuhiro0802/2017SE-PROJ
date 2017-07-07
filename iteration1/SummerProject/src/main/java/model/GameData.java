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
	
	public GameData(){
	}
	
	public GameData(int id) {
		this.id=id;
	}

	public GameData(int id, int rankpoint, int coin, int singlegame, int singlewin, int rankgame, int rankwin, int teamgame, int teamwin) {
		this.id = id;
		this.rankpoint = rankpoint;
		this.coin = coin;
		this.singlegame = singlegame;
		this.singlewin = singlewin;
		this.rankgame = rankgame;
		this.rankwin = rankwin;
		this.teamgame = teamgame;
		this.teamwin = teamwin;
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

}
