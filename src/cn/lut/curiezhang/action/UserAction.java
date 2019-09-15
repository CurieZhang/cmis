package cn.lut.curiezhang.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.service.UserService;
import cn.lut.curiezhang.util.SecurityFunctions;

/**
 * 用户管理的Action类
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
		this.userService = userService;
	}
	
	/**
	 * 模型驱动使用的类
	 */
	private Users model = new Users();
	public void setModel(Users model) {
		this.model = model;
	}
	@Override
	public Object getModel() {
		return (list != null ? list : model);
	}

	/**
	 * 搜索唯一id使用的参数
	 */
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		if(userId != null) {
			this.model = userService.getUserId(userId);
		}
		this.userId = userId;
	}
	
	/**
	 * 搜索所有数据时的返回结果
	 */
	private Collection<Users> list;
	public Collection<Users> getList() {
		return list;
	}
	
	/**
	 * validate()方法执行后会调用execute()方法
	 * 执行update()方法时，也进行了validate()验证？？？所以，就注释掉了
		public void validate() {
			System.out.println("v:" + model.getUserName() + ":");
	        if (model.getUserName() == null || model.getUserName().length() == 0) {
	            addFieldError("userName", "用户名不为空");
	        }
	    }
	 */
	
	/**
	 * 填写表单时执行该方法，可进行有效性验证
	 * @return true 不能通过有效性验证
	 */
	public boolean validateForm() {
        if (model.getUserName() == null || model.getUserName().length() == 0) {
            addFieldError("userName", "用户名不为空");
            return true;
        }
        return false;
    }

	/**
	 * 首页
	 */
    public String index() {
    	list = userService.getAll();
		return SUCCESS;
    }
	/**
	 * 添加
	 */
    public String add() {
    	model = new Users();
    	return "success";
    }
	/**
	 * 删除
	 */
    public String deleteConfirm() {
    	return "success";
    }
	/**
	 * 修改
	 */
    public String modify() {
    	return "success";
    }
	/**
	 * 查询
	 */
    public String browse() {
    	return "success";
    }
	/**
	 * 登录
	 */
    public String loginAdmin() {
    	return "loginAdmin";
    }
    
    /**
     * 创建用户
     * @return
     */
    public String create() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS：建立新用户 {}", model.getUserName());
        Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	names.add(user.getUserName());
        }
        if(names.contains(model.getUserName())){
        	addActionMessage("该用户名已存在！");
        	return "error";
        } else {
        	model.setUserPassword(SecurityFunctions.sha3(model.getUserPassword(), 512));
            userService.save(model);
            addActionMessage("创建用户成功！");
            return "success";
        }
    }

    /**
     * 查找用户
     * @return
     */
    public String findUser() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS：查找用户 {}", model.getUserName());
        Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	names.add(user.getUserName());
        }
        if(names.contains(model.getUserName())){
        	addActionMessage("我们将通过电子邮件，重置用户密码，请注意查收！");
        	return "success";
        } else {
            addActionMessage("该电子邮件的用户不存在，请注册！");
            return "error";
        }
    }

    /**
     * 删除用户
     * @return
     */
    public String delete() {
        log.debug("curieCMS：删除用户 {}", userId);
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
       		names.add(user.getUserId());
        }
        if(names.contains(userId)){
	        userService.delete(userId);
	        addActionMessage("用户删除成功！");
	        return "success";
        } else {
        	addActionMessage("该用户不存在，已删除！");
        	return "error";
        }
    }

    /**
     * 修改用户
     * @return
     */
    public String update() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS：修改用户 {}", model.getUserName());
        String newUserName = model.getUserName();
        String userId = model.getUserId();
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	if(user.getUserId().equals(userId) == false)
        		names.add(user.getUserName());
        }
        if(names.contains(newUserName)){
        	addActionMessage("该用户名已存在！");
        	return "error";
        } else {
            userService.update(model);
            addActionMessage("修改成功！");
            return "success";
        }
    }

    /**
     * 更新密码
     * @return
     */
    public String updatePassword() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS：修改用户 {}", model.getUserName());
        String newUserName = model.getUserName();
        String userId = model.getUserId();
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	if(user.getUserId().equals(userId) == false)
        		names.add(user.getUserName());
        }
        if(names.contains(newUserName)){
        	addActionMessage("该用户名已存在！");
        	return "error";
        } else {
        	model.setUserPassword(SecurityFunctions.sha3(model.getUserPassword(), 512));
            userService.update(model);
            addActionMessage("修改成功！");
            return "success";
        }
    }
}
