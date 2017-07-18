package service.impl;

import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


import model.Question;
import model.User;
import model.GameData;
import model.Item;
import service.AppService;
import dao.UserDao;
import dao.QuestionDao;
import dao.GamedataDao;
import dao.ItemDao;




public class AppServiceImpl implements AppService {


	private UserDao userDao;
	private QuestionDao questionDao;
	private GamedataDao gamedataDao;
	private ItemDao itemDao;

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
	
	public void setItemDao(ItemDao itemDao){
		this.itemDao=itemDao;
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
		System.out.println("get data by id");
		return gamedataDao.getGameDataById(id);
	}
	
	public void updateGamedata(GameData gamedata){
		gamedataDao.update(gamedata);
	}
	
	/*
	 * item
	 */
	public Integer addItem(Item item) {
		return itemDao.save(item);
	}

	public void deleteItem(Item item) {
		itemDao.delete(item);
	}

	public void updateItem(Item item) {
		itemDao.update(item);
	}

	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}
	
	public Item getItemByCharacterId(int characterid){
		return itemDao.getItemByCharacterId(characterid);
	}
	
	public List<Item> getAllItems(){
		return itemDao.getAllItems();
	}
	
	public List<Item> getAllCharacterItems(){
		return itemDao.getAllCharacterItems();
	}
	
	public List<Item> getAllObjectItems(){
		return itemDao.getAllObjectItems();
	}
	
	public String parseSubject21cn(String in){
		if(in.equals("Chinese"))
			return "2";
		else if(in.equals("Maths"))
			return "3";
		else if(in.equals("English"))
			return "4";
		else if(in.equals("Physics"))
			return "6";
		else if(in.equals("Chemistry"))
			return "7";
		else if(in.equals("History"))
			return "8";
		else if(in.equals("Politics"))
			return "9";
		else if(in.equals("Geography"))
			return "10";
		else if(in.equals("Biology"))
			return "11";
		else{
			
			return "0";
		}

	}
	
	
	
	
	
	public String getPageContent(String strUrl,String strPostRequest,int maxLength){
		StringBuffer buffer = new StringBuffer();
		System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
		System.setProperty("sun.net.client.defaultReadTimeout", "5000");

		try{
			URL newUrl = new URL(strUrl);
			HttpURLConnection hConnect = (HttpURLConnection) newUrl.openConnection();
			if(strPostRequest.length() > 0) {
				hConnect.setDoOutput(true);
				OutputStreamWriter out = new OutputStreamWriter(hConnect.getOutputStream());
				out.write(strPostRequest);
				out.flush();
				out.close();
			}
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(hConnect.getInputStream(),"UTF-8"));
			int ch;
			for(int length = 0; (ch = rd.read())> -1 && (maxLength<=0 || length<maxLength);length++)
				buffer.append((char) ch);
			String s = buffer.toString();

			s.replaceAll("//&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
			//System.out.println(buffer);
			
			rd.close();
			hConnect.disconnect();
			return buffer.toString().trim();
		} catch (Exception e){
			return null;
		}
	}
	
	
	public ArrayList<String> getParse(String url){

		ArrayList<String> tasks = new ArrayList<String>();
		AppServiceImpl pi =new AppServiceImpl();
		boolean next = true;
		int nextIndex = 0;
		int startIndex = 0;
		//int endIndex = 0;
		System.out.println(url);
		String wuBuffer = pi.getPageContent(url, "post", 100500);

		while(next){
			startIndex = wuBuffer.indexOf("查看解析",nextIndex);

			if(startIndex == -1)
				next = false;
			else{
				String wanted = wuBuffer.substring(startIndex-42, startIndex-19);
				tasks.add("http://tiku.21cnjy.com/"+wanted);
				
				nextIndex = startIndex+1;
			}
				
		}
		

	
		return tasks;
	}
	
	public Question pachong(String url , String sub , Integer diff){
		String question ="";
		String answerA ="";
		String answerB ="";
		String answerC ="";
		String answerD ="";
		String answer ="";
		Integer subject = Integer.parseInt(sub);
		Integer difficulty = diff;
		int firIndex = 0;
		int secIndex = 0;
		int startIn = 0;
		int endIn = 0;
		int endIn1 = 0;
		
		//addQuestion(Question question)
		AppServiceImpl pis =new AppServiceImpl();
		String qusBuffer = pis.getPageContent(url, "post", 100500);
		if(qusBuffer == null)
			return null;
		//System.out.println(qusBuffer);
		startIn =qusBuffer.indexOf("<dt>");
		endIn = qusBuffer.indexOf("<tab",startIn);
		endIn1 = qusBuffer.indexOf("<br",startIn);
		if(endIn == -1)
			endIn = endIn1;
		//System.out.println(startIn);
		question = qusBuffer.substring(startIn+9, endIn);
		question = question.replace("&nbsp;", "");
		//System.out.println(endIn);
		if(question.indexOf("<img") != -1 || question.indexOf("图") != -1 || question.length() > 120)
			return null;
		
		while(question.indexOf("<") != -1){
			firIndex = question.indexOf("<");
			secIndex = question.indexOf(">");
			question = question.substring(0, firIndex) + question.substring(secIndex+1, question.length());
		}
		
		startIn = qusBuffer.indexOf(">A",endIn);
		//System.out.println(question);


		endIn = qusBuffer.indexOf("<",startIn);

		answerA = qusBuffer.substring(startIn+1, endIn);
		if(answerA.indexOf("<img") != -1)
			return null;
		while(answerA.indexOf("<") != -1){
			firIndex = answerA.indexOf("<");
			//System.out.println(firIndex);
			secIndex = answerA.indexOf(">");
			//System.out.println(secIndex);
			answerA = answerA.substring(0, firIndex) + answerA.substring(secIndex+1, answerA.length());
		}
		if(answerA.equals(""))
			return null;
		
		startIn = qusBuffer.indexOf(">B",endIn);
		endIn = qusBuffer.indexOf("<",startIn);
		answerB = qusBuffer.substring(startIn+1, endIn);
		while(answerB.indexOf("<") != -1){
			firIndex = answerB.indexOf("<");
			//System.out.println(firIndex);
			secIndex = answerB.indexOf(">");
			//System.out.println(secIndex);
			answerB = answerB.substring(0, firIndex) + answerB.substring(secIndex+1, answerB.length());
		}
		if(answerB.equals(""))
			return null;
		
		startIn = qusBuffer.indexOf(">C",endIn);
		endIn = qusBuffer.indexOf("<",startIn);
		answerC = qusBuffer.substring(startIn+1, endIn);
		while(answerC.indexOf("<") != -1){
			firIndex = answerC.indexOf("<");
			//System.out.println(firIndex);
			secIndex = answerC.indexOf(">");
			//System.out.println(question);
			answerC = answerC.substring(0, firIndex) + answerC.substring(secIndex+1, answerC.length());
		}
		if(answerC.equals(""))
			return null;
		
		startIn = qusBuffer.indexOf(">D",endIn);

		endIn = qusBuffer.indexOf("<",startIn);
		answerD = qusBuffer.substring(startIn+1, endIn);
		while(answerD.indexOf("<") != -1){
			firIndex = answerD.indexOf("<");
			secIndex = answerD.indexOf(">");
			answerD = answerD.substring(0, firIndex) + answerD.substring(secIndex+1, answerD.length());
		}
		if(answerD.equals(""))
			return null;
		
		startIn = qusBuffer.indexOf("答案",endIn);
		answer = qusBuffer.substring(startIn+12,startIn+13);
		

		Question added = new Question(question,answerA,answerB,answerC,answerD,answer,subject,difficulty);


		
		return added;

	}
}
