package service;


import java.util.List;


import model.User;
import model.Question;
import model.GameData;



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
	/*
	 * gamedata
	 */

	public void addGamedata(int id);
	
	public GameData getGamedataById(int id);
	
	public void updateGamedata(GameData gamedata);
	
}