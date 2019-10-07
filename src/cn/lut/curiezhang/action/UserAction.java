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
 * SSH��ܽ����û��������ͼ���Action��
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
		log.debug("Action > ע���Service��");
		this.userService = userService;
	}
	
	/**
	 * Action��ģ������ʹ�õ���
	 */
	private Users model = new Users();
	public void setModel(Users model) {
		log.debug("Action > ����ģ��ֵ��idΪ{}", userId);
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (list != null) {
			if(list.size() != 0)
				log.debug("Action > �õ��б��һ��Ԫ��idֵ��idΪ{}", ((Users) list.iterator().next()).getUserId());
			return list;
		} else {
			log.debug("Action > �õ�ģ��ֵ��idΪ{}", userId);
			return model;
		}
	}

	/**
	 * Action������Ψһidʹ�õĲ���
	 */
	private String userId;
	public String getUserId() {
		log.debug("Action > �õ��û�id��idΪ{}", userId);
		return userId;
	}
	public void setUserId(String userId) {
		log.debug("Action > �����û�id��idΪ{}", userId);
		if(userId != null) {
			this.model = userService.getUserId(userId);
		}
		this.userId = userId;
	}
	
	/**
	 * Action��������������ʱ�ķ��ؽ��
	 * @return list
	 */
	private Collection<Users> list;
	public Collection<Users> getList() {
		log.debug("Action > ��ѯ�����û�");
		return list;
	}
	
	/**
	 * Action����д��ʱִ�и÷������ɽ�����Ч����֤
	 * @return true ����ͨ����Ч����֤
	 */
	public void validate() {
		log.debug("Action > ��Ч����֤��idΪ{}", userId);
    }

	/**
	 * Action����ҳ
	 */
    public String index() {
    	log.debug("Action > ����indexҳ��");
    	list = userService.getAll();
		return SUCCESS;
    }
	/**
	 * Action�����
	 */
    public String add() {
    	log.debug("Action > ����addҳ��");
    	model = new Users();
    	return "success";
    }
	/**
	 * Action��ȷ��ɾ��
	 */
    public String deleteConfirm() {
    	log.debug("Action > ����deleteConfirmҳ��");
    	return "success";
    }
	/**
	 * Action���޸�
	 */
    public String modify() {
    	log.debug("Action > ����modifyҳ��");
    	return "success";
    }
	/**
	 * Action�в�ѯ
	 */
    public String browse() {
    	log.debug("Action > ����browseҳ��");
    	return "success";
    }
	/**
	 * Action�е�¼
	 */
    public String loginAdmin() {
    	log.debug("Action > ���ʹ���Ա��¼ҳ��");
    	return "loginAdmin";
    }
    
    /**
     * Action�д����µ��û�
     * @return
     */
    public String create() {
    	log.debug("Action > ������û���idΪ {}", userId);
        String info = userService.save(model);
        addActionMessage(info);
        return "success";
    }

    /**
     * Action��ɾ��ָ��id���û�
     * @return
     */
    public String delete() {
        log.debug("Action > ɾ��ָ��id���û���idΪ {}", userId);
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
     * Action���޸��û���Ϣ
     * @return
     */
    public String update() {
    	log.debug("Action > �޸��û���Ϣ��idΪ {}", userId);
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
	 * Action���ٴ���������ʹ��
	 */
	private String userPassword2;
	public String getUserPassword2() {
		return userPassword2;
	}
	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	/**
     * Action���޸��û�����
     * @return
     */
    public String updatePassword() {
    	log.debug("Action > �޸��û���Ϣ��idΪ {}", userId);
        String userId = model.getUserId();
        model = userService.getUserById(userId);
    	log.debug("Action > �޸��û���Ϣ��idΪ {},{},{}", userId, model.getUserName(), model.getUserPhone());
        
    	model.setUserPassword(SecurityFunctions.sha3(this.getUserPassword2(), 512));
        userService.update(model);
        String info = ResourceBundle.getBundle("Messages").getString("Users.result.updatePassword");
        addActionMessage(info);
        return "success";
    }
}
