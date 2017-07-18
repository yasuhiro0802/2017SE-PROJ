package dao;

import java.util.List;

import model.Item;

public interface ItemDao {

	public Integer save(Item item);

	public void delete(Item item);

	public void update(Item item);

	public Item getItemById(int id);
	
	public Item getItemByCharacterId(int characterid);

	public List<Item> getAllItems();
	
	public List<Item> getAllCharacterItems();
	
	public List<Item> getAllObjectItems();
}