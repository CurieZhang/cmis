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
 * SSH框架进行考生管理的业务层的Service类
 * @author curiezhang
 *
 */
@Transactional
public class ExamineeService {
	private static final Logger log = LogManager.getLogger(ExamineeService.class);
	/**
	 * Service业务层注入DAO类
	 */
	private ExamineeDao examineeDao;
	public void setExamineeDao(ExamineeDao examineeDao) {
		log.debug("Service > 注入DAO类");
		this.examineeDao = examineeDao;
	}

	/**
	 * Service业务层保存考生
	 * @param examinee
	 */
	public String save(Examinee examinee) {
		log.debug("Service > 存储考生信息，id为 {}", examinee.getExamineeId());
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
	 * Service业务层判断考生是否存在
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
	 * Service业务层判断考生是否存在
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
	 * Service业务层查询所有考生
	 * @return list
	 */
	private Collection<Examinee> list;
	public Collection<Examinee> getAll() {
		log.debug("Service > 查询所有考生");
		list = examineeDao.getAll();
		return list;
	}

	/**
	 * Service业务层删除指定id的考生
	 * @param examinee
	 */
	public String delete(String examineeId) {
		log.debug("Service > 删除指定id的考生，id为 {}", examineeId);
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
	 * Service业务层根据id查询考生信息
	 * @param examineeId
	 */
	public Examinee getExamineeId(String examineeId) {
		log.debug("Service > 根据id查询考生信息，id为 {}", examineeId);
		return examineeDao.getExamineeId(examineeId);
	}

	/**
	 * Service业务层修改考生信息
	 * @param examinee
	 */
	public String update(Examinee examinee) {
		log.debug("Service > 修改考生信息，id为 {}", examinee.getExamineeId());
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
	 * Service业务层根据考生名和密码检查考生是否存在
	 * @param examineename
	 * @param password
	 */
	public Examinee checkExaminee(String examineename, String password) {
		log.debug("Service > 根据考生名和密码检查考生信息，考生名为 {}", examineename);
		return examineeDao.checkExaminee(examineename, password);
	}

	/**
	 * Service业务层根据id查询考生
	 * @param examineeId
	 */
	public Examinee getExamineeById(String examineeId) {
		log.debug("Service > 根据id查询考生信息，id为 {}", examineeId);
		return examineeDao.getExamineeById(examineeId);
	}

}
