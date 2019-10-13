package cn.lut.curiezhang.model;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * SSH框架进行用户管理的持久层的POJO类
 * @author curiezhang
 *
 */
public class Examinee {
	// 用户id
	private String examineeId;
	// 用户名
	private String examineeName;
	// 用户密码
	private String examineePassword;
	// 用户联系电话
	private String examineePhone;
	// 创建人
	private String examineeCreator;
	// 创建时间
	private Date examineeCreatingTime;
	// 审核人
	private String examineeAuditor;
	// 审核时间
	private Date examineeAuditingTime;
	// 用户状态：0学生 1院校 2考点 3管理员 4锁定学生 5锁定院校 6锁定考点 7锁定管理员 8找回学生密码 9找回院校密码 10找回考点密码 11找回管理员密码
	private ExamineeStatus status;
	@SuppressWarnings("unused")
	private String statusView;
	public Examinee() {
		super();
	}
	public Examinee(String examineeId, String examineeName, String examineePassword) {
		super();
		this.examineeId = examineeId;
		this.examineeName = examineeName;
		this.examineePassword = examineePassword;
	}
	public String getExamineeId() {
		return examineeId;
	}
	public void setExamineeId(String examineeId) {
		this.examineeId = examineeId;
	}
	public String getExamineeName() {
		return examineeName;
	}
	public void setExamineeName(String examineeName) {
		this.examineeName = examineeName;
	}
	public String getExamineePassword() {
		return examineePassword;
	}
	public void setExamineePassword(String examineePassword) {
		this.examineePassword = examineePassword;
	}
	public String getExamineePhone() {
		return examineePhone;
	}
	public void setExamineePhone(String examineePhone) {
		this.examineePhone = examineePhone;
	}
	public String getExamineeCreator() {
		return examineeCreator;
	}
	public void setExamineeCreator(String examineeCreator) {
		this.examineeCreator = examineeCreator;
	}
	public Date getExamineeCreatingTime() {
		return examineeCreatingTime;
	}
	public void setExamineeCreatingTime(Date examineeCreatingTime) {
		this.examineeCreatingTime = examineeCreatingTime;
	}
	public String getExamineeAuditor() {
		return examineeAuditor;
	}
	public void setExamineeAuditor(String examineeAuditor) {
		this.examineeAuditor = examineeAuditor;
	}
	public Date getExamineeAuditingTime() {
		return examineeAuditingTime;
	}
	public void setExamineeAuditingTime(Date examineeAuditingTime) {
		this.examineeAuditingTime = examineeAuditingTime;
	}
	public ExamineeStatus getStatus() {
		return status;
	}
	public void setStatus(ExamineeStatus status) {
		this.status = status;
	}
	public String getStatusView() {
		if (this.status == null) {
			return ResourceBundle.getBundle("Messages").getString("Application.null");
		} else if (status == ExamineeStatus.STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.STUDENT");
		} else if (status == ExamineeStatus.COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.COLLEGE");
		} else if (status == ExamineeStatus.SITE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.SITE");
		} else if (status == ExamineeStatus.ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.ADMINISTRATOR");
		} else if (status == ExamineeStatus.LOCK_STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.LOCK_STUDENT");
		} else if (status == ExamineeStatus.LOCK_COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.LOCK_COLLEGE");
		} else if (status == ExamineeStatus.LOCK_SITE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.LOCK_SITE");
		} else if (status == ExamineeStatus.LOCK_ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.LOCK_ADMINISTRATOR");
		} else if (status == ExamineeStatus.FIND_PASSWORD_STUDENT) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.FIND_PASSWORD_STUDENT");
		} else if (status == ExamineeStatus.FIND_PASSWORD_COLLEGE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.FIND_PASSWORD_COLLEGE");
		} else if (status == ExamineeStatus.FIND_PASSWORD_SITE) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.FIND_PASSWORD_SITE");
		} else if (status == ExamineeStatus.FIND_PASSWORD_ADMINISTRATOR) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.status.FIND_PASSWORD_ADMINISTRATOR");
		} else {
			return "";
		}
	}
	public void setStatusView(String statusView) {
		this.statusView = statusView;
	}
}
