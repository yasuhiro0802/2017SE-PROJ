package service;


import java.util.List;


import model.User;
import model.Question;



public interface AppService {
	/*
	 * user
	 */
	public Integer addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();
	
	
	/*
	 * question
	 */
	public Integer addQuestion(Question question);
	
	public Question getRandomQuestion();

}