package dao;

import java.util.List;

import model.GameData;

public interface GamedataDao {

	public void save(GameData gamedata);

	public void delete(GameData gameData);

	public void update(GameData gameData);

	public GameData getGameDataById(int id);

	public List<GameData> getAllGameDatas();
	
	
}