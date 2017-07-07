package dao.impl;

import java.util.List;

import model.GameData;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.GamedataDao;

public class GamedataDaoImpl extends HibernateDaoSupport implements GamedataDao {

	public void save(GameData gamedata) {
		getHibernateTemplate().save(gamedata);
	}

	public void delete(GameData gamedata) {
		getHibernateTemplate().delete(gamedata);
	}

	public void update(GameData gamedata) {
		getHibernateTemplate().merge(gamedata);
	}

	public GameData getGameDataById(int id) {
		@SuppressWarnings("unchecked")
		List<GameData> gamedatas = (List<GameData>) getHibernateTemplate().find(
				"from GameData as u where u.id=?", id);
		GameData gamedata = gamedatas.size() > 0 ? gamedatas.get(0) : null;
		return gamedata;
	}

	public List<GameData> getAllGameDatas() {
		@SuppressWarnings("unchecked")
		List<GameData> gamedatas = (List<GameData>) getHibernateTemplate()
				.find("from GameData");
		return gamedatas;
	}
	
	
}
