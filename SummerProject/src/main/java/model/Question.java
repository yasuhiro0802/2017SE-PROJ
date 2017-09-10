package model;

public class Question {

	private int id;
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String answer;
	private int subject;
	private int difficulty;

	public Question() {
	}

	public Question(String question, String answerA, String answerB, String answerC, String answerD, String answer, int subject, int difficulty) {
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.answer = answer;
		this.subject = subject;
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	
	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	
	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getSubject(){
		return subject;
	}
	
	public void setSubject(int subject){
		this.subject = subject;
	}

	public int getDifficulty(){
		return difficulty;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}

}
