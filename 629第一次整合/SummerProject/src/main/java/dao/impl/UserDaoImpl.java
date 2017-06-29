package dao.impl;

import java.util.List;

import model.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public void update(User user) {
		getHibernateTemplate().merge(user);
	}

	public User getUserById(int id) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from User as u where u.id=?", id);
		User user = users.size() > 0 ? users.get(0) : null;
		return user;
	}

	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate()
				.find("from User");
		return users;
	}
	
    public User login(User user) {
        // TODO Auto-generated method stub
        String hql="from User where username=? and password=?";
        List<User> loginers =(List<User>) getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
        if(loginers !=null &&loginers.size()>0){
            return loginers.get(0);
        }
        return null;
    }

}
