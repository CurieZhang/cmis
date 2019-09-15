package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * 用户管理的DAO的类
 * @author curiezhang
 *
 */
public class UserDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(UserDao.class);
	/**
	 * Dao中保存用户的方法
	 * @param user
	 */
	public void save(Users user) {
		log.info("Dao save");
		this.getHibernateTemplate().save(user);
	}

	/**
	 * Dao中查询所有用户的方法
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Collection<Users> getAll() {
		log.info("Dao getAll()");
		Collection<Users> list;
		list = (Collection<Users>) this.getHibernateTemplate().find("from Users");
		return list;
	}

	/**
	 * Dao中查询Login用户
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Users checkUser(String username, String password) {
		log.info("Dao checkUser(username, password)");
		Collection<Users> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Users where userName='" + username + "' and userPassword='" + password1 + "'";
		list = (Collection<Users>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Users user = list.iterator().next();
		if (username.equals(user.getUserName()) && SecurityFunctions.sha3(password, 512).equals(user.getUserPassword())) {
			return user;
		}
		return null;
	}

	/**
	 * Dao中查询Login用户
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Users checkCookieUser(String username, String password) {
		log.info("Dao checkCookieUser(username, password)");
		Collection<Users> list;
		String hql = "from Users where userName='" + username + "' and userPassword='" + password + "'";
		list = (Collection<Users>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Users user = list.iterator().next();
		if (username.equals(user.getUserName()) && password.equals(user.getUserPassword())) {
			return user;
		}
		return null;
	}

	/**
	 * 删除用户
	 * @param userId
	 */
	public void delete(String userId) {
		log.info("Dao delete(userId)");
		Object model = this.getHibernateTemplate().get(Users.class, userId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * 查询id用户
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.info("Dao getUserId(userId)");
		return this.getHibernateTemplate().get(Users.class, userId);
	}

	/**
	 * 修改用户
	 * @param user
	 */
	public void update(Users user) {
		log.info("Dao update(user)");
		this.getHibernateTemplate().update(user);
	}

	public void index() {
		
	}
}
