package cn.lut.curiezhang.model;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * SSH��ܽ����û�����ĳ־ò��POJO��
 * @author curiezhang
 *
 */
public class Examinee {
	// �û�id
	private String examineeId;
	// �û���
	private String examineeName;
	// �û�����
	private String examineePassword;
	// �û���ϵ�绰
	private String examineePhone;
	// ������
	private String examineeCreator;
	// ����ʱ��
	private Date examineeCreatingTime;
	// �����
	private String examineeAuditor;
	// ���ʱ��
	private Date examineeAuditingTime;
	// �û�״̬��0ѧ�� 1ԺУ 2���� 3����Ա 4����ѧ�� 5����ԺУ 6�������� 7��������Ա 8�һ�ѧ������ 9�һ�ԺУ���� 10�һؿ������� 11�һع���Ա����
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
