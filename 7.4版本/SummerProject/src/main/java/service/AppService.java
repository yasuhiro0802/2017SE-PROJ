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
	
	public Integer login(User user);
	
	public Integer register(User user);
	/*
	 * question
	 */
	public Integer addQuestion(Question question);
	
	public Question getRandomQuestion();
	
	public Question getQuestionBySubject(int subId);

}