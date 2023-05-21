package org.jsp.springhibernatedemo.dao;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class UserDao extends HibernateDaoSupport {
@Transactional
public User saveUser(User u) {
	getHibernateTemplate().save(u);
	return u;

}
@Transactional
public User updateUser(User u) {
	getHibernateTemplate().update(u);
	return u;

}
public User findUser(int id) {
	return getHibernateTemplate().get(User.class, id);
}
@Transactional
public boolean deleteUser(int id) {
	User u=getHibernateTemplate().get(User.class, id);
	if (u!=null) {
		getHibernateTemplate().delete(u);
		return true;
	} else {
    return false;
	}
}
}
