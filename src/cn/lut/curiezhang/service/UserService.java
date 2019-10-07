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
	public String save(Users user) {
		log.debug("Service > �洢�û���Ϣ��idΪ {}", user.getUserId());
		Collection<String> names = new ArrayList<String>();
        Collection<String> ids = new ArrayList<String>();
        list = getAll();
        for(Users user1 : list) {
        	names.add(user1.getUserName());
        	ids.add(user1.getUserId());
        }
        if(names.contains(user.getUserName()) || ids.contains(user.getUserId())){
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
	public String delete(String userId) {
		log.debug("Service > ɾ��ָ��id���û���idΪ {}", userId);
        if(userId == null) {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
        	return info;
        }
    	Collection<String> names = new ArrayList<String>();
        list = getAll();
        for(Users user : list) {
       		names.add(user.getUserId());
        }
        if(names.contains(userId)){
    		userDao.delete(userId);
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.delete");
        	return info;
        } else {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
        	return info;
        }
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
