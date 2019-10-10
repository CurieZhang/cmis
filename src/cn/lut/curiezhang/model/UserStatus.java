package cn.lut.curiezhang.model;

import java.util.ResourceBundle;

public enum UserStatus {
	// 用户状态：0学生 1院校 2考点 3管理员 4锁定学生 5锁定院校 6锁定考点 7锁定管理员 8找回学生密码 9找回院校密码 10找回考点密码 11找回管理员密码
	STUDENT(Byte.valueOf("0"), ResourceBundle.getBundle("Messages").getString("Users.status." + 0)),
	COLLEGE(Byte.valueOf("1"), ResourceBundle.getBundle("Messages").getString("Users.status." + 1)),
	SITE(Byte.valueOf("2"), ResourceBundle.getBundle("Messages").getString("Users.status." + 2)),
	ADMINISTRATOR(Byte.valueOf("3"), ResourceBundle.getBundle("Messages").getString("Users.status." + 3)),
	LOCK_STUDENT(Byte.valueOf("10"), ResourceBundle.getBundle("Messages").getString("Users.status." + 10)),
	LOCK_COLLEGE(Byte.valueOf("11"), ResourceBundle.getBundle("Messages").getString("Users.status." + 11)),
	LOCK_SITE(Byte.valueOf("12"), ResourceBundle.getBundle("Messages").getString("Users.status." + 12)),
	LOCK_ADMINISTRATOR(Byte.valueOf("13"), ResourceBundle.getBundle("Messages").getString("Users.status." + 13)),
	FIND_PASSWORD_STUDENT(Byte.valueOf("90"), ResourceBundle.getBundle("Messages").getString("Users.status." + 90)),
	FIND_PASSWORD_COLLEGE(Byte.valueOf("91"), ResourceBundle.getBundle("Messages").getString("Users.status." + 91)),
	FIND_PASSWORD_SITE(Byte.valueOf("92"), ResourceBundle.getBundle("Messages").getString("Users.status." + 92)),
	FIND_PASSWORD_ADMINISTRATOR(Byte.valueOf("93"), ResourceBundle.getBundle("Messages").getString("Users.status." + 93));
	
	private Byte index;
	private String information;
	public Byte getIndex() {
		return index;
	}
	public void setIndex(Byte index) {
		this.index = index;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	private UserStatus(Byte index, String information) {
		this.index = index;
		this.information = information;
	}
	private UserStatus(Byte index) {
		this.index = index;
	}
}
