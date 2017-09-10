package dao.impl;

import java.util.List;

import model.Item;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ItemDao;

public class ItemDaoImpl extends HibernateDaoSupport implements ItemDao {

	public Integer save(Item item) {
		return (Integer) getHibernateTemplate().save(item);
	}

	public void delete(Item item) {
		getHibernateTemplate().delete(item);
	}

	public void update(Item item) {
		getHibernateTemplate().merge(item);
	}

	public Item getItemById(int id) {
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) getHibernateTemplate().find(
				"from Item as u where u.id=?", id);
		Item item = items.size() > 0 ? items.get(0) : null;
		return item;
	}

	public Item getItemByCharacterId(int characterid){
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) getHibernateTemplate().find(
				"from Item as u where u.characterid=? and u.category=1", characterid);
		Item item = items.size() > 0 ? items.get(0) : null;
		return item;
	}
	
	public List<Item> getAllItems() {
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) getHibernateTemplate()
				.find("from Item");
		return items;
	}
	
	public List<Item> getAllCharacterItems(){
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) getHibernateTemplate().find(
				"  from Item as u where u.category=1");
		return items;
	}
	
	public List<Item> getAllObjectItems(){
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) getHibernateTemplate().find(
				"  from Item as u where u.category=2");
		return items;
	}
}
