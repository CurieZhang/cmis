package cn.lut.curiezhang.action;

import java.util.Collection;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lut.curiezhang.model.Examinee;
import cn.lut.curiezhang.service.ExamineeService;
import cn.lut.curiezhang.util.SecurityFunctions;

/**
 * SSH框架进行用户管理的视图层的Action类
 * @author curiezhang
 *
 */
public class ExamineeAction extends ActionSupport implements ModelDriven<Object> {
	/**
	 * ExamineeAction的ID
	 */
	private static final long serialVersionUID = -2978659526717330712L;
	private static final Logger log = LogManager.getLogger(ExamineeAction.class);
	/**
	 * Struts和Spring整合过程中按名称自动注入的业务层的类
	 */
	private ExamineeService examineeService;
	public void setExamineeService(ExamineeService examineeService) {
		log.debug("Action > 注入的Service类");
		this.examineeService = examineeService;
	}
	
	/**
	 * Action中模型驱动使用的类
	 */
	private Examinee model = new Examinee();
	public void setModel(Examinee model) {
		log.debug("Action > 设置模型值，id为{}", examineeId);
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (list != null) {
			if(list.size() != 0)
				log.debug("Action > 得到列表第一个元素id值，id为{}", ((Examinee) list.iterator().next()).getExamineeId());
			return list;
		} else {
			log.debug("Action > 得到模型值，id为{}", examineeId);
			return model;
		}
	}

	/**
	 * Action中搜索唯一id使用的参数
	 */
	private String examineeId;
	public String getExamineeId() {
		log.debug("Action > 得到用户id，id为{}", examineeId);
		return examineeId;
	}
	public void setExamineeId(String examineeId) {
		log.debug("Action > 设置用户id，id为{}", examineeId);
		if(examineeId != null) {
			this.model = examineeService.getExamineeId(examineeId);
		}
		this.examineeId = examineeId;
	}
	
	/**
	 * Action中搜索所有数据时的返回结果
	 * @return list
	 */
	private Collection<Examinee> list;
	public Collection<Examinee> getList() {
		log.debug("Action > 查询所有用户");
		return list;
	}
	
	/**
	 * Action中填写表单时执行该方法，可进行有效性验证
	 * @return true 不能通过有效性验证
	 */
	public void validate() {
		log.debug("Action > 有效性验证，id为{}", examineeId);
    }

	/**
	 * Action中首页
	 */
    public String index() {
    	log.debug("Action > 访问index页面");
    	list = examineeService.getAll();
		return SUCCESS;
    }
	/**
	 * Action中添加
	 */
    public String add() {
    	log.debug("Action > 访问add页面");
    	model = new Examinee();
    	return "success";
    }
	/**
	 * Action中确认删除
	 */
    public String deleteConfirm() {
    	log.debug("Action > 访问deleteConfirm页面");
    	return "success";
    }
	/**
	 * Action中修改
	 */
    public String modify() {
    	log.debug("Action > 访问modify页面");
    	return "success";
    }
	/**
	 * Action中查询
	 */
    public String browse() {
    	log.debug("Action > 访问browse页面");
    	return "success";
    }
	/**
	 * Action中登录
	 */
    public String loginAdmin() {
    	log.debug("Action > 访问管理员登录页面");
    	return "loginAdmin";
    }
    
    /**
     * Action中创建新的用户
     * @return
     */
    public String create() {
    	log.debug("Action > 添加新用户，id为 {}", examineeId);
        String info = examineeService.save(model);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action中删除指定id的用户
     * @return
     */
    public String delete() {
        log.debug("Action > 删除指定id的用户，id为 {}", examineeId);
    	String info = examineeService.delete(examineeId);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action中修改用户信息
     * @return
     */
    public String update() {
    	log.debug("Action > 修改用户信息，id为 {}", examineeId);
    	String info = examineeService.update(model);
        addActionMessage(info);
        return "success";
    }

	/**
	 * Action中再次输入密码使用
	 */
	private String examineePassword2;
	public String getExamineePassword2() {
		return examineePassword2;
	}
	public void setExamineePassword2(String examineePassword2) {
		this.examineePassword2 = examineePassword2;
	}

	/**
     * Action中修改用户密码
     * @return
     */
    public String updatePassword() {
    	log.debug("Action > 修改用户信息，id为 {}", examineeId);
        String examineeId = model.getExamineeId();
        model = examineeService.getExamineeById(examineeId);
    	log.debug("Action > 修改用户信息，id为 {},{},{}", examineeId, model.getExamineeName(), model.getExamineePhone());
        
    	model.setExamineePassword(SecurityFunctions.sha3(this.getExamineePassword2(), 512));
        examineeService.update(model);
        String info = ResourceBundle.getBundle("Messages").getString("Examinee.result.updatePassword");
        addActionMessage(info);
        return "success";
    }
}
