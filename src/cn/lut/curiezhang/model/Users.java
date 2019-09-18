package cn.lut.curiezhang.model;

/**
 * SSH框架进行用户管理的持久层的POJO类
 * @author curiezhang
 *
 */
public class Users {
	// 用户id
	private String userId;
	// 用户名
	private String userName;
	// 用户密码
	private String userPassword;
	// 用户联系电话
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
