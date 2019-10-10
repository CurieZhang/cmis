package cn.lut.curiezhang.model;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * SSH��ܽ����û�����ĳ־ò��POJO��
 * @author curiezhang
 *
 */
public class Users {
	// �û�id
	private String userId;
	// �û���
	private String userName;
	// �û�����
	private String userPassword;
	// �û���ϵ�绰
	private String userPhone;
	// ������
	private String userCreator;
	// ����ʱ��
	private Date userCreatingTime;
	// �����
	private String userAuditor;
	// ���ʱ��
	private Date userAuditingTime;
	// �û�״̬��0ѧ�� 1ԺУ 2���� 3����Ա 4����ѧ�� 5����ԺУ 6�������� 7��������Ա 8�һ�ѧ������ 9�һ�ԺУ���� 10�һؿ������� 11�һع���Ա����
	private UserStatus status;
	@SuppressWarnings("unused")
	private String statusView;
	public Users() {
		super();
	}
	public Users(String userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserCreator() {
		return userCreator;
	}
	public void setUserCreator(String userCreator) {
		this.userCreator = userCreator;
	}
	public Date getUserCreatingTime() {
		return userCreatingTime;
	}
	public void setUserCreatingTime(Date userCreatingTime) {
		this.userCreatingTime = userCreatingTime;
	}
	public String getUserAuditor() {
		return userAuditor;
	}
	public void setUserAuditor(String userAuditor) {
		this.userAuditor = userAuditor;
	}
	public Date getUserAuditingTime() {
		return userAuditingTime;
	}
	public void setUserAuditingTime(Date userAuditingTime) {
		this.userAuditingTime = userAuditingTime;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public String getStatusView() {
		if (this.status == null) {
			return ResourceBundle.getBundle("Messages").getString("Application.null");
		} else if (status == UserStatus.STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.STUDENT");
		} else if (status == UserStatus.COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.COLLEGE");
		} else if (status == UserStatus.SITE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.SITE");
		} else if (status == UserStatus.ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.ADMINISTRATOR");
		} else if (status == UserStatus.LOCK_STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.LOCK_STUDENT");
		} else if (status == UserStatus.LOCK_COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.LOCK_COLLEGE");
		} else if (status == UserStatus.LOCK_SITE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.LOCK_SITE");
		} else if (status == UserStatus.LOCK_ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.LOCK_ADMINISTRATOR");
		} else if (status == UserStatus.FIND_PASSWORD_STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.FIND_PASSWORD_STUDENT");
		} else if (status == UserStatus.FIND_PASSWORD_COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.FIND_PASSWORD_COLLEGE");
		} else if (status == UserStatus.FIND_PASSWORD_SITE) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.FIND_PASSWORD_SITE");
		} else if (status == UserStatus.FIND_PASSWORD_ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Users.status.FIND_PASSWORD_ADMINISTRATOR");
		} else {
			return "";
		}
	}
	public void setStatusView(String statusView) {
		this.statusView = statusView;
	}
}
