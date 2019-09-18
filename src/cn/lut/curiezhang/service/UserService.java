package cn.lut.curiezhang.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.UserDao;
import cn.lut.curiezhang.model.Users;

/**
 * SSH��ܽ����û������ҵ����Service��
 * @author curiezhang
 *
 */
@Transactional
public class UserService {
	private static final Logger log = LogManager.getLogger(UserService.class);
	/**
	 * Serviceҵ���ע��DAO��
	 */
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		log.debug("Service > ע��DAO��");
		this.userDao = userDao;
	}

	/**
	 * Serviceҵ��㱣���û�
	 * @param user
	 */
	public void save(Users user) {
		log.debug("Service > �洢�û���Ϣ��idΪ {}", user.getUserId());
		userDao.save(user);
	}

	/**
	 * Serviceҵ����ѯ�����û�
	 * @return list
	 */
	private Collection<Users> list;
	public Collection<Users> getAll() {
		log.debug("Service > ��ѯ�����û�");
		list = userDao.getAll();
		return list;
	}

	/**
	 * Serviceҵ���ɾ��ָ��id���û�
	 * @param user
	 */
	public void delete(String userId) {
		log.debug("Service > ɾ��ָ��id���û���idΪ {}", userId);
		userDao.delete(userId);
	}

	/**
	 * Serviceҵ������id��ѯ�û���Ϣ
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.debug("Service > ����id��ѯ�û���Ϣ��idΪ {}", userId);
		return userDao.getUserId(userId);
	}

	/**
	 * Serviceҵ����޸��û���Ϣ
	 * @param user
	 */
	public void update(Users user) {
		log.debug("Service > �޸��û���Ϣ��idΪ {}", user.getUserId());
		userDao.update(user);
	}
	
	/**
	 * Serviceҵ�������û������������û��Ƿ����
	 * @param username
	 * @param password
	 */
	public Users checkUser(String username, String password) {
		log.debug("Service > �����û������������û���Ϣ���û���Ϊ {}", username);
		return userDao.checkUser(username, password);
	}

	/**
	 * Serviceҵ������id��ѯ�û�
	 * @param userId
	 */
	public Users getUserById(String userId) {
		log.debug("Service > ����id��ѯ�û���Ϣ��idΪ {}", userId);
		return userDao.getUserById(userId);
	}

}
