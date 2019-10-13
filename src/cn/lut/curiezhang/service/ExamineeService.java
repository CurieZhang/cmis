package cn.lut.curiezhang.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import cn.lut.curiezhang.dao.ExamineeDao;
import cn.lut.curiezhang.model.Examinee;

/**
 * SSH��ܽ��п��������ҵ����Service��
 * @author curiezhang
 *
 */
@Transactional
public class ExamineeService {
	private static final Logger log = LogManager.getLogger(ExamineeService.class);
	/**
	 * Serviceҵ���ע��DAO��
	 */
	private ExamineeDao examineeDao;
	public void setExamineeDao(ExamineeDao examineeDao) {
		log.debug("Service > ע��DAO��");
		this.examineeDao = examineeDao;
	}

	/**
	 * Serviceҵ��㱣�濼��
	 * @param examinee
	 */
	public String save(Examinee examinee) {
		log.debug("Service > �洢������Ϣ��idΪ {}", examinee.getExamineeId());
		/*
		 * Collection<String> names = new ArrayList<String>(); Collection<String> ids =
		 * new ArrayList<String>(); list = getAll(); for(Examinee examinee1 : list) {
		 * names.add(examinee1.getExamineeName()); ids.add(examinee1.getExamineeId()); }
		 */
        if(isExistByName(examinee) || isExist(examinee.getExamineeId())){
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.createError");
        	return info;
        } else {
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.create");
    		examineeDao.save(examinee);
            return info;
        }
	}
	
	/**
	 * Serviceҵ����жϿ����Ƿ����
	 * @param examineeId
	 */
	private boolean isExist(String examineeId) {
		Examinee examinee = getExamineeById(examineeId);
		if (examinee != null)
			return true;
		else
			return false;
	}
	/**
	 * Serviceҵ����жϿ����Ƿ����
	 * @param examineeId
	 */
	private boolean isExistByName(Examinee examinee) {
    	Collection<String> names = new ArrayList<String>();
        list = getAll();
        for(Examinee examinee1 : list) {
        	if(examinee1.getExamineeId().equals(examinee.getExamineeId()) == false)
        		names.add(examinee1.getExamineeName());
        }
		if (names.contains(examinee.getExamineeName()))
			return true;
		else
			return false;
	}

	/**
	 * Serviceҵ����ѯ���п���
	 * @return list
	 */
	private Collection<Examinee> list;
	public Collection<Examinee> getAll() {
		log.debug("Service > ��ѯ���п���");
		list = examineeDao.getAll();
		return list;
	}

	/**
	 * Serviceҵ���ɾ��ָ��id�Ŀ���
	 * @param examinee
	 */
	public String delete(String examineeId) {
		log.debug("Service > ɾ��ָ��id�Ŀ�����idΪ {}", examineeId);
        if(examineeId == null) {
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.deleteError");
        	return info;
        }
		/*
		 * Collection<String> names = new ArrayList<String>(); list = getAll();
		 * for(Examinee examinee : list) { names.add(examinee.getExamineeId()); }
		 */
        if(isExist(examineeId)){
    		examineeDao.delete(examineeId);
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.delete");
        	return info;
        } else {
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.deleteError");
        	return info;
        }
	}

	/**
	 * Serviceҵ������id��ѯ������Ϣ
	 * @param examineeId
	 */
	public Examinee getExamineeId(String examineeId) {
		log.debug("Service > ����id��ѯ������Ϣ��idΪ {}", examineeId);
		return examineeDao.getExamineeId(examineeId);
	}

	/**
	 * Serviceҵ����޸Ŀ�����Ϣ
	 * @param examinee
	 */
	public String update(Examinee examinee) {
		log.debug("Service > �޸Ŀ�����Ϣ��idΪ {}", examinee.getExamineeId());
        //String newExamineeName = examinee.getExamineeName();
		/*
		 * String examineeId = examinee.getExamineeId(); Collection<String> names = new
		 * ArrayList<String>(); list = getAll(); for(Examinee examinee1 : list) {
		 * if(examinee1.getExamineeId().equals(examineeId) == false) names.add(examinee1.getExamineeName());
		 * }
		 */
        if(isExistByName(examinee)){
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.updateError");
        	return info;
        } else {
            examineeDao.update(examinee);
            String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.update");
        	return info;
        }
	}
	
	/**
	 * Serviceҵ�����ݿ������������鿼���Ƿ����
	 * @param examineename
	 * @param password
	 */
	public Examinee checkExaminee(String examineename, String password) {
		log.debug("Service > ���ݿ������������鿼����Ϣ��������Ϊ {}", examineename);
		return examineeDao.checkExaminee(examineename, password);
	}

	/**
	 * Serviceҵ������id��ѯ����
	 * @param examineeId
	 */
	public Examinee getExamineeById(String examineeId) {
		log.debug("Service > ����id��ѯ������Ϣ��idΪ {}", examineeId);
		return examineeDao.getExamineeById(examineeId);
	}

}
