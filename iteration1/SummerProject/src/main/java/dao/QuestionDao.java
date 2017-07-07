package dao;

import java.util.List;

import model.Question;

public interface QuestionDao {

	public Integer save(Question question);

	public void delete(Question question);

	public void update(Question question);

	public Question getQuestionById(int id);

	public List<Question> getAllQuestions();
	
	public Integer getMaxId();
	
	public List<Question> getQuestionBySub(int sub);
}