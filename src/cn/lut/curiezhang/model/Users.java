package cn.lut.curiezhang.model;

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
}
