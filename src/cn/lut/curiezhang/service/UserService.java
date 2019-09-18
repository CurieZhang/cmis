package cn.lut.curiezhang.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.UserDao;
import cn.lut.curiezhang.model.Users;

/**
 * SSH框架进行用户管理的业务层的Service类
 * @author curiezhang
 *
 */
@Transactional
public class UserService {
	private static final Logger log = LogManager.getLogger(UserService.class);
	/**
	 * Service业务层注入DAO类
	 */
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		log.debug("Service > 注入DAO类");
		this.userDao = userDao;
	}

	/**
	 * Service业务层保存用户
	 * @param user
	 */
	public void save(Users user) {
		log.debug("Service > 存储用户信息，id为 {}", user.getUserId());
		userDao.save(user);
	}

	/**
	 * Service业务层查询所有用户
	 * @return list
	 */
	private Collection<Users> list;
	public Collection<Users> getAll() {
		log.debug("Service > 查询所有用户");
		list = userDao.getAll();
		return list;
	}

	/**
	 * Service业务层删除指定id的用户
	 * @param user
	 */
	public void delete(String userId) {
		log.debug("Service > 删除指定id的用户，id为 {}", userId);
		userDao.delete(userId);
	}

	/**
	 * Service业务层根据id查询用户信息
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.debug("Service > 根据id查询用户信息，id为 {}", userId);
		return userDao.getUserId(userId);
	}

	/**
	 * Service业务层修改用户信息
	 * @param user
	 */
	public void update(Users user) {
		log.debug("Service > 修改用户信息，id为 {}", user.getUserId());
		userDao.update(user);
	}
	
	/**
	 * Service业务层根据用户名和密码检查用户是否存在
	 * @param username
	 * @param password
	 */
	public Users checkUser(String username, String password) {
		log.debug("Service > 根据用户名和密码检查用户信息，用户名为 {}", username);
		return userDao.checkUser(username, password);
	}

	/**
	 * Service业务层根据id查询用户
	 * @param userId
	 */
	public Users getUserById(String userId) {
		log.debug("Service > 根据id查询用户信息，id为 {}", userId);
		return userDao.getUserById(userId);
	}

}
