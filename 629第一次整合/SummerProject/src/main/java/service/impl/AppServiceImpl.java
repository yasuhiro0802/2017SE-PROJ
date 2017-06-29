package service.impl;

import java.util.List;

import model.Question;
import model.User;
import service.AppService;
import dao.UserDao;
import dao.QuestionDao;



public class AppServiceImpl implements AppService {


	private UserDao userDao;
	private QuestionDao questionDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}

	public void setQuestionDao(QuestionDao questionDao){
		this.questionDao=questionDao;
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

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
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
		Question question=questionDao.getQuestionById(1);
		return question;
	}

}
