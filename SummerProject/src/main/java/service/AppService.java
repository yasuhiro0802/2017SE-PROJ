package service;


import java.util.ArrayList;
import java.util.List;


import model.User;
import model.Question;
import model.GameData;
import model.Item;



public interface AppService {
	/*
	 * user
	 */
	public Integer addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();
	
	public Integer login(User user);
	
	public User getUserByUsername(String username);
	
	public Integer register(User user);
	/*
	 * question
	 */
	public Integer addQuestion(Question question);
	
	public List<Question> getAllQuestion();
	
	public Question getQuestionById(int id);
	
	public Question getRandomQuestion();
	
	public Question getQuestionBySubject(int subId);
	
	public String parseSubject21cn(String in);
	
	public ArrayList<String> getParse(String url);

	public Question pachong(String string , String subject , Integer difficulty);
	/*
	 * gamedata
	 */

	public void addGamedata(int id);
	
	public GameData getGamedataById(int id);
	
	public void updateGamedata(GameData gamedata);
	
	/*
	 * item
	 */
	public Integer addItem(Item item);

	public void deleteItem(Item item);

	public void updateItem(Item item);

	public Item getItemById(int id);
	
	public Item getItemByCharacterId(int characterid);
	
	public List<Item> getAllItems();
	
	public List<Item> getAllCharacterItems();
	
	public List<Item> getAllObjectItems();
}