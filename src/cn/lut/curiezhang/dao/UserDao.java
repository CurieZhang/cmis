package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * SSH框架进行用户管理的持久层的DAO类
 * @author curiezhang
 *
 */
public class UserDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(UserDao.class);
	/**
	 * Dao中保存用户信息
	 * @param user
	 */
	public void save(Users user) {
		log.debug("Dao > 存储用户信息，id为{}", user.getUserId());
		this.getHibernateTemplate().save(user);
	}

	/**
	 * Dao中查询所有用户
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Collection<Users> getAll() {
		log.debug("Dao 》 查询所有用户");
		Collection<Users> list;
		list = (Collection<Users>) this.getHibernateTemplate().find("from Users");
		return list;
	}

	/**
	 * Dao中检查用户是否有效
	 * @param username
	 * @param password
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Users checkUser(String username, String password) {
		log.debug("Dao > 检查用户是否存在，用户名为{}", username);
		Collection<Users> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Users where userName='" + username + "' and userPassword='" + password1 + "'";
		list = (Collection<Users>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Users user = list.iterator().next();
		if (username.equals(user.getUserName()) && SecurityFunctions.sha3(password, 512).equals(user.getUserPassword())) {
			log.debug("Dao > 检查结果为用户存在，id为{}", user.getUserId());
			return user;
		}
		return null;
	}

	/**
	 * Dao中删除用户
	 * @param userId
	 */
	public void delete(String userId) {
		log.debug("Dao > 删除指定用户，id为{}", userId);
		Object model = this.getHibernateTemplate().get(Users.class, userId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * Dao中查询指定id的用户
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.debug("Dao > 查询指定id的用户，id为{}", userId);
		return this.getHibernateTemplate().get(Users.class, userId);
	}

	/**
	 * Dao中修改用户
	 * @param user
	 */
	public void update(Users user) {
		log.debug("Dao > 更新用户信息，id为{}", user.getUserId());
		this.getHibernateTemplate().update(user);
	}

	/**
	 * Dao中根据id查询用户信息
	 * @param userId
	 */
	public Users getUserById(String userId) {
		log.debug("DAO > 根据id查询用户信息，id为 {}", userId);
		return this.getHibernateTemplate().get(Users.class, userId);
	}
}
