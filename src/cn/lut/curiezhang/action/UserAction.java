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
 * �û������Action��
 * @author curiezhang
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<Object> {
	/**
	 * UserAction��ID
	 */
	private static final long serialVersionUID = -2978659526717330712L;
	private static final Logger log = LogManager.getLogger(UserAction.class);
	/**
	 * Struts��Spring���Ϲ����а������Զ�ע���ҵ������
	 */
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * ģ������ʹ�õ���
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
	 * ����Ψһidʹ�õĲ���
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
	 * ������������ʱ�ķ��ؽ��
	 */
	private Collection<Users> list;
	public Collection<Users> getList() {
		return list;
	}
	
	/**
	 * validate()����ִ�к�����execute()����
	 * ִ��update()����ʱ��Ҳ������validate()��֤���������ԣ���ע�͵���
		public void validate() {
			System.out.println("v:" + model.getUserName() + ":");
	        if (model.getUserName() == null || model.getUserName().length() == 0) {
	            addFieldError("userName", "�û�����Ϊ��");
	        }
	    }
	 */
	
	/**
	 * ��д��ʱִ�и÷������ɽ�����Ч����֤
	 * @return true ����ͨ����Ч����֤
	 */
	public boolean validateForm() {
        if (model.getUserName() == null || model.getUserName().length() == 0) {
            addFieldError("userName", "�û�����Ϊ��");
            return true;
        }
        return false;
    }

	/**
	 * ��ҳ
	 */
    public String index() {
    	list = userService.getAll();
		return SUCCESS;
    }
	/**
	 * ���
	 */
    public String add() {
    	model = new Users();
    	return "success";
    }
	/**
	 * ɾ��
	 */
    public String deleteConfirm() {
    	return "success";
    }
	/**
	 * �޸�
	 */
    public String modify() {
    	return "success";
    }
	/**
	 * ��ѯ
	 */
    public String browse() {
    	return "success";
    }
	/**
	 * ��¼
	 */
    public String loginAdmin() {
    	return "loginAdmin";
    }
    
    /**
     * �����û�
     * @return
     */
    public String create() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS���������û� {}", model.getUserName());
        Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	names.add(user.getUserName());
        }
        if(names.contains(model.getUserName())){
        	addActionMessage("���û����Ѵ��ڣ�");
        	return "error";
        } else {
        	model.setUserPassword(SecurityFunctions.sha3(model.getUserPassword(), 512));
            userService.save(model);
            addActionMessage("�����û��ɹ���");
            return "success";
        }
    }

    /**
     * �����û�
     * @return
     */
    public String findUser() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS�������û� {}", model.getUserName());
        Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	names.add(user.getUserName());
        }
        if(names.contains(model.getUserName())){
        	addActionMessage("���ǽ�ͨ�������ʼ��������û����룬��ע����գ�");
        	return "success";
        } else {
            addActionMessage("�õ����ʼ����û������ڣ���ע�ᣡ");
            return "error";
        }
    }

    /**
     * ɾ���û�
     * @return
     */
    public String delete() {
        log.debug("curieCMS��ɾ���û� {}", userId);
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
       		names.add(user.getUserId());
        }
        if(names.contains(userId)){
	        userService.delete(userId);
	        addActionMessage("�û�ɾ���ɹ���");
	        return "success";
        } else {
        	addActionMessage("���û������ڣ���ɾ����");
        	return "error";
        }
    }

    /**
     * �޸��û�
     * @return
     */
    public String update() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS���޸��û� {}", model.getUserName());
        String newUserName = model.getUserName();
        String userId = model.getUserId();
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	if(user.getUserId().equals(userId) == false)
        		names.add(user.getUserName());
        }
        if(names.contains(newUserName)){
        	addActionMessage("���û����Ѵ��ڣ�");
        	return "error";
        } else {
            userService.update(model);
            addActionMessage("�޸ĳɹ���");
            return "success";
        }
    }

    /**
     * ��������
     * @return
     */
    public String updatePassword() {
    	if(validateForm())
    		return "error";
        log.debug("curieCMS���޸��û� {}", model.getUserName());
        String newUserName = model.getUserName();
        String userId = model.getUserId();
    	Collection<String> names = new ArrayList<String>();
        list = userService.getAll();
        for(Users user : list) {
        	if(user.getUserId().equals(userId) == false)
        		names.add(user.getUserName());
        }
        if(names.contains(newUserName)){
        	addActionMessage("���û����Ѵ��ڣ�");
        	return "error";
        } else {
        	model.setUserPassword(SecurityFunctions.sha3(model.getUserPassword(), 512));
            userService.update(model);
            addActionMessage("�޸ĳɹ���");
            return "success";
        }
    }
}
