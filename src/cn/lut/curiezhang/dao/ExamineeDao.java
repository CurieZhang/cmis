package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Examinee;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * SSH框架进行用户管理的持久层的DAO类
 * @author curiezhang
 *
 */
public class ExamineeDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(ExamineeDao.class);
	/**
	 * Dao中保存用户信息
	 * @param examinee
	 */
	public void save(Examinee examinee) {
		log.debug("Dao > 存储用户信息，id为{}", examinee.getExamineeId());
		this.getHibernateTemplate().save(examinee);
	}

	/**
	 * Dao中查询所有用户
	 */
	@SuppressWarnings({ "unchecked" })
	public Collection<Examinee> getAll() {
		log.debug("Dao 》 查询所有用户");
		Collection<Examinee> list;
		list = (Collection<Examinee>) this.getHibernateTemplate().getSessionFactory().openSession().createQuery( "from Examinee" ).list();
		return list;
	}

	/**
	 * Dao中检查用户是否有效
	 * @param examineename
	 * @param password
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Examinee checkExaminee(String examineename, String password) {
		log.debug("Dao > 检查用户是否存在，用户名为{}", examineename);
		Collection<Examinee> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Examinee where examineeName='" + examineename + "' and examineePassword='" + password1 + "'";
		list = (Collection<Examinee>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Examinee examinee = list.iterator().next();
		if (examineename.equals(examinee.getExamineeName()) && SecurityFunctions.sha3(password, 512).equals(examinee.getExamineePassword())) {
			log.debug("Dao > 检查结果为用户存在，id为{}", examinee.getExamineeId());
			return examinee;
		}
		return null;
	}

	/**
	 * Dao中删除用户
	 * @param examineeId
	 */
	public void delete(String examineeId) {
		log.debug("Dao > 删除指定用户，id为{}", examineeId);
		Object model = this.getHibernateTemplate().get(Examinee.class, examineeId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * Dao中查询指定id的用户
	 * @param examineeId
	 */
	public Examinee getExamineeId(String examineeId) {
		log.debug("Dao > 查询指定id的用户，id为{}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}

	/**
	 * Dao中修改用户
	 * @param examinee
	 */
	public void update(Examinee examinee) {
		log.debug("Dao > 更新用户信息，id为{}", examinee.getExamineeId());
		this.getHibernateTemplate().update(examinee);
	}

	/**
	 * Dao中根据id查询用户信息
	 * @param examineeId
	 */
	public Examinee getExamineeById(String examineeId) {
		log.debug("DAO > 根据id查询用户信息，id为 {}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}
}
