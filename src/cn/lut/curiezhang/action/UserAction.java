package cn.lut.curiezhang.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.service.UserService;
import cn.lut.curiezhang.util.SecurityFunctions;

/**
 * SSH框架进行用户管理的视图层的Action类
 * @author curiezhang
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<Object> {
	/**
	 * UserAction的ID
	 */
	private static final long serialVersionUID = -2978659526717330712L;
	private static final Logger log = LogManager.getLogger(UserAction.class);
	/**
	 * Struts和Spring整合过程中按名称自动注入的业务层的类
	 */
	private UserService userService;
	public void setUserService(UserService userService) {
		log.debug("Action > 注入的Service类");
		this.userService = userService;
	}
	
	/**
	 * Action中模型驱动使用的类
	 */
	private Users model = new Users();
	public void setModel(Users model) {
		log.debug("Action > 设置模型值，id为{}", userId);
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (list != null) {
			if(list.size() != 0)
				log.debug("Action > 得到列表第一个元素id值，id为{}", ((Users) list.iterator().next()).getUserId());
			return list;
		} else {
			log.debug("Action > 得到模型值，id为{}", userId);
			return model;
		}
	}

	/**
	 * Action中搜索唯一id使用的参数
	 */
	private String userId;
	public String getUserId() {
		log.debug("Action > 得到用户id，id为{}", userId);
		return userId;
	}
	public void setUserId(String userId) {
		log.debug("Action > 设置用户id，id为{}", userId);
		if(userId != null) {
			this.model = userService.getUserId(userId);
		}
		this.userId = userId;
	}
	
	/**
	 * Action中搜索所有数据时的返回结果
	 * @return list
	 */
	private Collection<Users> list;
	public Collection<Users> getList() {
		log.debug("Action > 查询所有用户");
		return list;
	}
	
	/**
	 * Action中填写表单时执行该方法，可进行有效性验证
	 * @return true 不能通过有效性验证
	 */
	public void validate() {
		log.debug("Action > 有效性验证，id为{}", userId);
    }

	/**
	 * Action中首页
	 */
    public String index() {
    	log.debug("Action > 访问index页面");
    	list = userService.getAll();
		return SUCCESS;
    }
	/**
	 * Action中添加
	 */
    public String add() {
    	log.debug("Action > 访问add页面");
    	model = new Users();
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
    	log.debug("Action > 添加新用户，id为 {}", userId);
        String info = userService.save(model);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action中删除指定id的用户
     * @return
     */
    public String delete() {
        log.debug("Action > 删除指定id的用户，id为 {}", userId);
        if(userId == null) {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
            addActionMessage(info);
        	return "error";
        }
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
       		names.add(user.getUserId());
        }
        if(names.contains(userId)){
	        userService.delete(userId);
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.delete");
            addActionMessage(info);
	        return "success";
        } else {
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.deleteError");
            addActionMessage(info);
        	return "error";
        }
    }

    /**
     * Action中修改用户信息
     * @return
     */
    public String update() {
    	log.debug("Action > 修改用户信息，id为 {}", userId);
        String newUserName = model.getUserName();
        String userId = model.getUserId();
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	if(user.getUserId().equals(userId) == false)
        		names.add(user.getUserName());
        }
        if(names.contains(newUserName)){
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.updateError");
            addActionMessage(info);
        	return "error";
        } else {
        	model.setUserPassword(SecurityFunctions.sha3(this.getUserPassword2(), 512));
            userService.update(model);
            String info = ResourceBundle.getBundle("Messages").getString("Users.result.update");
            addActionMessage(info);
            return "success";
        }
    }

	/**
	 * Action中再次输入密码使用
	 */
	private String userPassword2;
	public String getUserPassword2() {
		return userPassword2;
	}
	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	/**
     * Action中修改用户密码
     * @return
     */
    public String updatePassword() {
    	log.debug("Action > 修改用户信息，id为 {}", userId);
        String userId = model.getUserId();
        model = userService.getUserById(userId);
    	log.debug("Action > 修改用户信息，id为 {},{},{}", userId, model.getUserName(), model.getUserPhone());
        
    	model.setUserPassword(SecurityFunctions.sha3(this.getUserPassword2(), 512));
        userService.update(model);
        String info = ResourceBundle.getBundle("Messages").getString("Users.result.updatePassword");
        addActionMessage(info);
        return "success";
    }
}
