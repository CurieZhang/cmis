package cn.lut.curiezhang.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lut.curiezhang.model.Examinee;
import cn.lut.curiezhang.util.SecurityFunctions;


/**
 * SSH��ܽ��п�������ĳ־ò��DAO��
 * @author curiezhang
 *
 */
public class ExamineeDao extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger(ExamineeDao.class);
	/**
	 * Dao�б��濼����Ϣ
	 * @param examinee
	 */
	public void save(Examinee examinee) {
		log.debug("Dao > �洢������Ϣ��idΪ{}", examinee.getExamineeId());
		this.getHibernateTemplate().save(examinee);
	}

	/**
	 * Dao�в�ѯ���п���
	 */
	@SuppressWarnings({ "unchecked" })
	public Collection<Examinee> getAll() {
		log.debug("Dao �� ��ѯ���п���");
		Collection<Examinee> list;
		list = (Collection<Examinee>) this.getHibernateTemplate().getSessionFactory().openSession().createQuery( "from Examinee" ).list();
		return list;
	}

	/**
	 * Dao�м�鿼���Ƿ���Ч
	 * @param examineename
	 * @param password
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Examinee checkExaminee(String examineename, String password) {
		log.debug("Dao > ��鿼���Ƿ���ڣ�������Ϊ{}", examineename);
		Collection<Examinee> list;
		String password1 = SecurityFunctions.sha3(password, 512);
		String hql = "from Examinee where examineeName='" + examineename + "' and examineePassword='" + password1 + "'";
		list = (Collection<Examinee>) this.getHibernateTemplate().find(hql);
		if(list == null || list.isEmpty())
			return null;
		Examinee examinee = list.iterator().next();
		if (examineename.equals(examinee.getExamineeName())) {
			log.debug("Dao > �����Ϊ�������ڣ�idΪ{}", examinee.getExamineeId());
			return examinee;
		}
		return null;
	}

	/**
	 * Dao��ɾ������
	 * @param examineeId
	 */
	public void delete(String examineeId) {
		log.debug("Dao > ɾ��ָ��������idΪ{}", examineeId);
		Object model = this.getHibernateTemplate().get(Examinee.class, examineeId);
		this.getHibernateTemplate().delete(model);
	}

	/**
	 * Dao�в�ѯָ��id�Ŀ���
	 * @param examineeId
	 */
	public Examinee getExamineeId(String examineeId) {
		log.debug("Dao > ��ѯָ��id�Ŀ�����idΪ{}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}

	/**
	 * Dao���޸Ŀ���
	 * @param examinee
	 */
	public void update(Examinee examinee) {
		log.debug("Dao > ���¿�����Ϣ��idΪ{}", examinee.getExamineeId());
		this.getHibernateTemplate().update(examinee);
	}

	/**
	 * Dao�и���id��ѯ������Ϣ
	 * @param examineeId
	 */
	public Examinee getExamineeById(String examineeId) {
		log.debug("DAO > ����id��ѯ������Ϣ��idΪ {}", examineeId);
		return this.getHibernateTemplate().get(Examinee.class, examineeId);
	}
}
