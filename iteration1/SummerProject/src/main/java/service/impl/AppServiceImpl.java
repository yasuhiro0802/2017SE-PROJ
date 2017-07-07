package service.impl;

import java.util.List;
import java.util.Random;

import model.Question;
import model.User;
import model.GameData;
import service.AppService;
import dao.UserDao;
import dao.QuestionDao;
import dao.GamedataDao;



public class AppServiceImpl implements AppService {


	private UserDao userDao;
	private QuestionDao questionDao;
	private GamedataDao gamedataDao;
	//static List<Question> 
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}

	public void setQuestionDao(QuestionDao questionDao){
		this.questionDao=questionDao;
	}
	
	public void setGamedataDao(GamedataDao gamedataDao){
		this.gamedataDao=gamedataDao;
	}
	/*
	 * user
	 */
	//basic function of User---add,delete,update,retrieve
	public Integer addUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public User getUserByUsername(String username){
		return userDao.findUserByUsername(username);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public Integer login(User user){
		User temp=userDao.findUserByUsername(user.getUsername());
		if (temp != null)
		{
			if (temp.getPassword().equals(user.getPassword()))
				return 1;		//correct
			return -1;		//wrong password
		}
		return 0;			//no such username
	}
	
	
	public Integer register(User user){
		if (userDao.findUserByUsername(user.getUsername()) != null)
		{
			return 0;		//username repeat
		}
		
		return addUser(user);
		
	}
	
	/*
	 * question
	 */
	//add question into database
	public Integer addQuestion(Question question){
		return questionDao.save(question);
	}
	
	//return question by random id
	public Question getRandomQuestion(){
		//complete random function
		//return question No.1
		Random rand = new Random();
		
		Integer MaxId = questionDao.getMaxId();
		Integer randomId = rand.nextInt(MaxId)+1;         //here has to be modified
		System.out.println(randomId);
		Question question=questionDao.getQuestionById(randomId);
		return question;
	}
	
	public Question getQuestionById(int id){
		return questionDao.getQuestionById(id);
	}
	
	public List<Question> getAllQuestion(){
		return questionDao.getAllQuestions();
	}

	
	public Question getQuestionBySubject(int subId){
		Random rand = new Random();
		
		//Integer MaxId = questionDao.getMaxId();
		List<Question> getIds = questionDao.getQuestionBySub(subId);
		
		Question question=questionDao.getQuestionById(1);
		return question;
	}
	
	public void addGamedata(int id) {
		GameData gamedata = new GameData(id);
		gamedataDao.save(gamedata);
		
	} 
	
	public GameData getGamedataById(int id){
		return gamedataDao.getGameDataById(id);
	}
	
	public void updateGamedata(GameData gamedata){
		gamedataDao.update(gamedata);
	}
}
