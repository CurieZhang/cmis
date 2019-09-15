package cn.lut.curiezhang.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.UserDao;
import cn.lut.curiezhang.model.Users;

/**
 * 用户管理的业务层的类
 * @author curiezhang
 *
 */
@Transactional
public class UserService {
	private static final Logger log = LogManager.getLogger(UserService.class);
	/**
	 * 业务层注入DAO的类
	 */
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 业务层保存用户的方法
	 * @param user
	 */
	public void save(Users user) {
		log.info("Service save");
		userDao.save(user);
	}

	/**
	 * 业务层查询所有用户的方法
	 */
	private Collection<Users> list;
	public Collection<Users> getAll() {
		log.info("Service getAll");
		list = userDao.getAll();
		return list;
	}

	/**
	 * 业务层删除id用户的方法
	 * @param user
	 */
	public void delete(String userId) {
		log.info("Service delete");
		userDao.delete(userId);
	}

	/**
	 * 业务层使用id查询用户的方法
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.info("Service getUserId");
		return userDao.getUserId(userId);
	}

	/**
	 * 业务层修改用户的方法
	 * @param user
	 */
	public void update(Users user) {
		log.info("Service update");
		userDao.update(user);
	}
	
	public Users checkUser(String username, String password) {
		log.info("Service checkUser");
		return userDao.checkUser(username, password);
	}

	public Users checkCookieUser(String username, String password) {
		log.info("Service checkCookieUser");
		return userDao.checkCookieUser(username, password);
	}

}
