package dao.impl;

import java.util.List;

import model.Question;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.QuestionDao;

public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {

	public Integer save(Question question) {
		return (Integer) getHibernateTemplate().save(question);
	}

	public void delete(Question question) {
		getHibernateTemplate().delete(question);
	}

	public void update(Question question) {
		getHibernateTemplate().merge(question);
	}

	public Question getQuestionById(int id) {
		@SuppressWarnings("unchecked")
		List<Question> questions = (List<Question>) getHibernateTemplate().find(
				"from Question as u where u.id=?", id);
		Question question = questions.size() > 0 ? questions.get(0) : null;
		return question;
	}

	public List<Question> getAllQuestions() {
		@SuppressWarnings("unchecked")
		List<Question> questions = (List<Question>) getHibernateTemplate()
				.find("from Question");
		return questions;
	}
	
	public Integer getMaxId() {
		@SuppressWarnings("unchecked")
		List<Integer> maxId = (List<Integer>) getHibernateTemplate().find(
				" from Question where id = max(id) ");
		return maxId.get(0);
	}

}
