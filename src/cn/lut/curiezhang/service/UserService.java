package cn.lut.curiezhang.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.UserDao;
import cn.lut.curiezhang.model.Users;

/**
 * �û������ҵ������
 * @author curiezhang
 *
 */
@Transactional
public class UserService {
	private static final Logger log = LogManager.getLogger(UserService.class);
	/**
	 * ҵ���ע��DAO����
	 */
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * ҵ��㱣���û��ķ���
	 * @param user
	 */
	public void save(Users user) {
		log.info("Service save");
		userDao.save(user);
	}

	/**
	 * ҵ����ѯ�����û��ķ���
	 */
	private Collection<Users> list;
	public Collection<Users> getAll() {
		log.info("Service getAll");
		list = userDao.getAll();
		return list;
	}

	/**
	 * ҵ���ɾ��id�û��ķ���
	 * @param user
	 */
	public void delete(String userId) {
		log.info("Service delete");
		userDao.delete(userId);
	}

	/**
	 * ҵ���ʹ��id��ѯ�û��ķ���
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.info("Service getUserId");
		return userDao.getUserId(userId);
	}

	/**
	 * ҵ����޸��û��ķ���
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
