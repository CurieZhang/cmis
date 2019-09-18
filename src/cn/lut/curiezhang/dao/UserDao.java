package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * SSH��ܽ����û�����ĳ־ò��DAO��
 * @author curiezhang
 *
 */
public class UserDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(UserDao.class);
	/**
	 * Dao�б����û���Ϣ
	 * @param user
	 */
	public void save(Users user) {
		log.debug("Dao > �洢�û���Ϣ��idΪ{}", user.getUserId());
		this.getHibernateTemplate().save(user);
	}

	/**
	 * Dao�в�ѯ�����û�
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Collection<Users> getAll() {
		log.debug("Dao �� ��ѯ�����û�");
		Collection<Users> list;
		list = (Collection<Users>) this.getHibernateTemplate().find("from Users");
		return list;
	}

	/**
	 * Dao�м���û��Ƿ���Ч
	 * @param username
	 * @param password
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Users checkUser(String username, String password) {
		log.debug("Dao > ����û��Ƿ���ڣ��û���Ϊ{}", username);
		Collection<Users> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Users where userName='" + username + "' and userPassword='" + password1 + "'";
		list = (Collection<Users>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Users user = list.iterator().next();
		if (username.equals(user.getUserName()) && SecurityFunctions.sha3(password, 512).equals(user.getUserPassword())) {
			log.debug("Dao > �����Ϊ�û����ڣ�idΪ{}", user.getUserId());
			return user;
		}
		return null;
	}

	/**
	 * Dao��ɾ���û�
	 * @param userId
	 */
	public void delete(String userId) {
		log.debug("Dao > ɾ��ָ���û���idΪ{}", userId);
		Object model = this.getHibernateTemplate().get(Users.class, userId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * Dao�в�ѯָ��id���û�
	 * @param userId
	 */
	public Users getUserId(String userId) {
		log.debug("Dao > ��ѯָ��id���û���idΪ{}", userId);
		return this.getHibernateTemplate().get(Users.class, userId);
	}

	/**
	 * Dao���޸��û�
	 * @param user
	 */
	public void update(Users user) {
		log.debug("Dao > �����û���Ϣ��idΪ{}", user.getUserId());
		this.getHibernateTemplate().update(user);
	}

	/**
	 * Dao�и���id��ѯ�û���Ϣ
	 * @param userId
	 */
	public Users getUserById(String userId) {
		log.debug("DAO > ����id��ѯ�û���Ϣ��idΪ {}", userId);
		return this.getHibernateTemplate().get(Users.class, userId);
	}
}
