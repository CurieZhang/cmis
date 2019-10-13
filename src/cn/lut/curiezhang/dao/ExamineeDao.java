package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Examinee;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * SSH��ܽ����û�����ĳ־ò��DAO��
 * @author curiezhang
 *
 */
public class ExamineeDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(ExamineeDao.class);
	/**
	 * Dao�б����û���Ϣ
	 * @param examinee
	 */
	public void save(Examinee examinee) {
		log.debug("Dao > �洢�û���Ϣ��idΪ{}", examinee.getExamineeId());
		this.getHibernateTemplate().save(examinee);
	}

	/**
	 * Dao�в�ѯ�����û�
	 */
	@SuppressWarnings({ "unchecked" })
	public Collection<Examinee> getAll() {
		log.debug("Dao �� ��ѯ�����û�");
		Collection<Examinee> list;
		list = (Collection<Examinee>) this.getHibernateTemplate().getSessionFactory().openSession().createQuery( "from Examinee" ).list();
		return list;
	}

	/**
	 * Dao�м���û��Ƿ���Ч
	 * @param examineename
	 * @param password
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Examinee checkExaminee(String examineename, String password) {
		log.debug("Dao > ����û��Ƿ���ڣ��û���Ϊ{}", examineename);
		Collection<Examinee> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Examinee where examineeName='" + examineename + "' and examineePassword='" + password1 + "'";
		list = (Collection<Examinee>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Examinee examinee = list.iterator().next();
		if (examineename.equals(examinee.getExamineeName()) && SecurityFunctions.sha3(password, 512).equals(examinee.getExamineePassword())) {
			log.debug("Dao > �����Ϊ�û����ڣ�idΪ{}", examinee.getExamineeId());
			return examinee;
		}
		return null;
	}

	/**
	 * Dao��ɾ���û�
	 * @param examineeId
	 */
	public void delete(String examineeId) {
		log.debug("Dao > ɾ��ָ���û���idΪ{}", examineeId);
		Object model = this.getHibernateTemplate().get(Examinee.class, examineeId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * Dao�в�ѯָ��id���û�
	 * @param examineeId
	 */
	public Examinee getExamineeId(String examineeId) {
		log.debug("Dao > ��ѯָ��id���û���idΪ{}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}

	/**
	 * Dao���޸��û�
	 * @param examinee
	 */
	public void update(Examinee examinee) {
		log.debug("Dao > �����û���Ϣ��idΪ{}", examinee.getExamineeId());
		this.getHibernateTemplate().update(examinee);
	}

	/**
	 * Dao�и���id��ѯ�û���Ϣ
	 * @param examineeId
	 */
	public Examinee getExamineeById(String examineeId) {
		log.debug("DAO > ����id��ѯ�û���Ϣ��idΪ {}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}
}
