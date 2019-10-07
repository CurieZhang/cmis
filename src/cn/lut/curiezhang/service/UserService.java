package cn.lut.curiezhang.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.UserDao;
import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.util.SecurityFunctions;

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
	public String save(Users user) {
		log.debug("Service > 存储用户信息，id为 {}", user.getUserId());
		/*
		 * Collection<String> names = new ArrayList<String>(); Collection<String> ids =
		 * new ArrayList<String>(); list = getAll(); for(Users user1 : list) {
		 * names.add(user1.getUserName()); ids.add(user1.getUserId()); }
		 */
        if(isExistByName(user) || isExist(user.getUserId())){
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.createError");
        	return info;
        } else {
        	user.setUserPassword(SecurityFunctions.sha3(user.getUserPassword(), 512));
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.create");
    		userDao.save(user);
            return info;
        }
	}
	
	/**
	 * Service业务层判断用户是否存在
	 * @param userId
	 */
	private boolean isExist(String userId) {
		Users user = getUserById(userId);
		if (user != null)
			return true;
		else
			return false;
	}
	/**
	 * Service业务层判断用户是否存在
	 * @param userId
	 */
	private boolean isExistByName(Users user) {
    	Collection<String> names = new ArrayList<String>();
        list = getAll();
        for(Users user1 : list) {
        	if(user1.getUserId().equals(user.getUserId()) == false)
        		names.add(user1.getUserName());
        }
		if (names.contains(user.getUserName()))
			return true;
		else
			return false;
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
	public String delete(String userId) {
		log.debug("Service > 删除指定id的用户，id为 {}", userId);
        if(userId == null) {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
        	return info;
        }
		/*
		 * Collection<String> names = new ArrayList<String>(); list = getAll();
		 * for(Users user : list) { names.add(user.getUserId()); }
		 */
        if(isExist(userId)){
    		userDao.delete(userId);
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.delete");
        	return info;
        } else {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
        	return info;
        }
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
	public String update(Users user) {
		log.debug("Service > 修改用户信息，id为 {}", user.getUserId());
        //String newUserName = user.getUserName();
		/*
		 * String userId = user.getUserId(); Collection<String> names = new
		 * ArrayList<String>(); list = getAll(); for(Users user1 : list) {
		 * if(user1.getUserId().equals(userId) == false) names.add(user1.getUserName());
		 * }
		 */
        if(isExistByName(user)){
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.updateError");
        	return info;
        } else {
        	user.setUserPassword(SecurityFunctions.sha3(user.getUserPassword(), 512));
            userDao.update(user);
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.update");
        	return info;
        }
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
