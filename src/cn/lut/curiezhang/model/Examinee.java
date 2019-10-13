package cn.lut.curiezhang.model;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * SSH��ܽ��п�������ĳ־ò��POJO��
 * @author curiezhang
 *
 */
public class Examinee {
	//	ksh    ������
	private String examineeId;
	//	xm      ����
	private String examineeName;
	// ��Ƭ
	private String examineePictureUrl;
	//	xbdm   �Ա����
	private String examineeSexId;
	@SuppressWarnings("unused")
	private String examineeSexIdView;
	//	xbdm   �Ա�����
	private String examineeSexName;
	//	csrq    ��������
	private Date examineeBirthday;
	// ��ϵ��ַ
	private String examineeAddress;
	// ��������
	private String examineeZipCode;
	// ��ϵ�绰
	private String examineeContactPhone;
	// �ƶ��绰
	private String examineeMobilePhone;
	// ��������
	private String examineeCountyDistrictId;
	// ��������
	private String examineeCountyDistrictName;
	//	zzmmdm   ������ò����
	private String examineePoliticalStatusId;
	//	zzmmdm   ������ò����
	private String examineePoliticalStatusName;
	//	mzdm      �������
	private String examineeNationalityId;
	//	mzdm      ��������
	private String examineeNationalityName;
	//	kslxdm    �������ʹ���   
	private String examineeExamineeTypeId;
	//	kslxdm    ������������
	private String examineeExamineeTypeName;
	//	kldm       �������      ����������
	private String examineeDisciplineId;
	//	klmc     ��������          ����������
	private String examineeDisciplineName;
	//	kslbdm    ����������     
	private String examineeExamineeCategoryId;
	//	kslbdm    �����������
	private String examineeExamineeCategoryName;
	//	bylbdm  ��ҵ������    ʡ����Ժ�ļ���Ӧ���д���
	private String examineeGraduationCategoryId;
	//	Bylbmc  ��ҵ�������    ��ͨ���б�ҵ   �����е�רҵѧУ��ҵ   ְҵ���б�ҵ �е�ʦ����ҵ
	private String examineeGraduationCategoryName;
	//	byxxmc  ��ҵѧУ����
	private String examineeGraduationSchoolId;
	//	byxxmc  ��ҵѧУ���� 
	private String examineeGraduationSchoolName;
	//	wyyzdm  �������ִ���
	private String examineeForeignLanguageId;
	//	Wyyzmc  ������������
	private String examineeForeignLanguageName;
	//	sfzh   ���֤��
	private String examineeIdNumber;
	//	bmddm   ���������
	private String examineeRegistrationPointId;
	//	Bmdmc   ����������
	private String examineeRegistrationPointName;
	// ������
	private String examineeCreator;
	// ����ʱ��
	private Date examineeCreatingTime;
	// �����
	private String examineeAuditor;
	// ���ʱ��
	private Date examineeAuditingTime;
	// ����	0����ƽ̨ 1ѧ�� 2ԺУ 3���� 4�������
	private Byte examineeType;
	@SuppressWarnings("unused")
	private String examineeTypeView;
	// ��ע
	private String examineeMemo;
	// ������Ϣ�д���ʱʹ�ã�
	private String examineeError;
	// ״̬ 0���� 1ȷ�� 2�д���
	private Byte examineeStatus;
	@SuppressWarnings("unused")
	private String examineeStatusView;
	// ��������
	private Discipline discipline;
	// ��������
	private CountyDistrict countyDistrict;
	public Examinee() {
	}
	public Examinee(String examineeId) {
		this.examineeId = examineeId;
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
	public String getExamineePictureUrl() {
		return examineePictureUrl;
	}
	public void setExamineePictureUrl(String examineePictureUrl) {
		this.examineePictureUrl = examineePictureUrl;
	}
	public String getExamineeSexId() {
		return examineeSexId;
	}
	public void setExamineeSexId(String examineeSexId) {
		this.examineeSexId = examineeSexId;
	}
	public String getExamineeSexIdView() {
		if (this.examineeSexId == null || this.examineeSexId.trim().length() == 0) {
			return ResourceBundle.getBundle("Messages").getString("Application.null");
		} else if (this.examineeSexId.trim().equals("1")) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeSex.1");
		} else if (this.examineeSexId.trim().equals("2")) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeSex.2");
		} else {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeSex.others");
		}
	}
	public void setExamineeSexIdView(String examineeSexIdView) {
		this.examineeSexIdView = examineeSexIdView;
	}
	public String getExamineeSexName() {
		return examineeSexName;
	}
	public void setExamineeSexName(String examineeSexName) {
		this.examineeSexName = examineeSexName;
	}
	public Date getExamineeBirthday() {
		return examineeBirthday;
	}
	public void setExamineeBirthday(Date examineeBirthday) {
		this.examineeBirthday = examineeBirthday;
	}
	public String getExamineeAddress() {
		return examineeAddress;
	}
	public void setExamineeAddress(String examineeAddress) {
		this.examineeAddress = examineeAddress;
	}
	public String getExamineeZipCode() {
		return examineeZipCode;
	}
	public void setExamineeZipCode(String examineeZipCode) {
		this.examineeZipCode = examineeZipCode;
	}
	public String getExamineeContactPhone() {
		return examineeContactPhone;
	}
	public void setExamineeContactPhone(String examineeContactPhone) {
		this.examineeContactPhone = examineeContactPhone;
	}
	public String getExamineeMobilePhone() {
		return examineeMobilePhone;
	}
	public void setExamineeMobilePhone(String examineeMobilePhone) {
		this.examineeMobilePhone = examineeMobilePhone;
	}
	public String getExamineeCountyDistrictId() {
		return examineeCountyDistrictId;
	}
	public void setExamineeCountyDistrictId(String examineeCountyDistrictId) {
		this.examineeCountyDistrictId = examineeCountyDistrictId;
	}
	public String getExamineeCountyDistrictName() {
		return examineeCountyDistrictName;
	}
	public void setExamineeCountyDistrictName(String examineeCountyDistrictName) {
		this.examineeCountyDistrictName = examineeCountyDistrictName;
	}
	public String getExamineePoliticalStatusId() {
		return examineePoliticalStatusId;
	}
	public void setExamineePoliticalStatusId(String examineePoliticalStatusId) {
		this.examineePoliticalStatusId = examineePoliticalStatusId;
	}
	public String getExamineePoliticalStatusName() {
		return examineePoliticalStatusName;
	}
	public void setExamineePoliticalStatusName(String examineePoliticalStatusName) {
		this.examineePoliticalStatusName = examineePoliticalStatusName;
	}
	public String getExamineeNationalityId() {
		return examineeNationalityId;
	}
	public void setExamineeNationalityId(String examineeNationalityId) {
		this.examineeNationalityId = examineeNationalityId;
	}
	public String getExamineeNationalityName() {
		return examineeNationalityName;
	}
	public void setExamineeNationalityName(String examineeNationalityName) {
		this.examineeNationalityName = examineeNationalityName;
	}
	public String getExamineeExamineeTypeId() {
		return examineeExamineeTypeId;
	}
	public void setExamineeExamineeTypeId(String examineeExamineeTypeId) {
		this.examineeExamineeTypeId = examineeExamineeTypeId;
	}
	public String getExamineeExamineeTypeName() {
		return examineeExamineeTypeName;
	}
	public void setExamineeExamineeTypeName(String examineeExamineeTypeName) {
		this.examineeExamineeTypeName = examineeExamineeTypeName;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	public String getExamineeDisciplineId() {
		return examineeDisciplineId;
	}
	public void setExamineeDisciplineId(String examineeDisciplineId) {
		this.examineeDisciplineId = examineeDisciplineId;
	}
	public String getExamineeDisciplineName() {
		return examineeDisciplineName;
	}
	public void setExamineeDisciplineName(String examineeDisciplineName) {
		this.examineeDisciplineName = examineeDisciplineName;
	}
	public String getExamineeExamineeCategoryId() {
		return examineeExamineeCategoryId;
	}
	public void setExamineeExamineeCategoryId(String examineeExamineeCategoryId) {
		this.examineeExamineeCategoryId = examineeExamineeCategoryId;
	}
	public String getExamineeExamineeCategoryName() {
		return examineeExamineeCategoryName;
	}
	public void setExamineeExamineeCategoryName(String examineeExamineeCategoryName) {
		this.examineeExamineeCategoryName = examineeExamineeCategoryName;
	}
	public String getExamineeGraduationCategoryId() {
		return examineeGraduationCategoryId;
	}
	public void setExamineeGraduationCategoryId(String examineeGraduationCategoryId) {
		this.examineeGraduationCategoryId = examineeGraduationCategoryId;
	}
	public String getExamineeGraduationCategoryName() {
		return examineeGraduationCategoryName;
	}
	public void setExamineeGraduationCategoryName(String examineeGraduationCategoryName) {
		this.examineeGraduationCategoryName = examineeGraduationCategoryName;
	}
	public String getExamineeGraduationSchoolId() {
		return examineeGraduationSchoolId;
	}
	public void setExamineeGraduationSchoolId(String examineeGraduationSchoolId) {
		this.examineeGraduationSchoolId = examineeGraduationSchoolId;
	}
	public String getExamineeGraduationSchoolName() {
		return examineeGraduationSchoolName;
	}
	public void setExamineeGraduationSchoolName(String examineeGraduationSchoolName) {
		this.examineeGraduationSchoolName = examineeGraduationSchoolName;
	}
	public String getExamineeForeignLanguageId() {
		return examineeForeignLanguageId;
	}
	public void setExamineeForeignLanguageId(String examineeForeignLanguageId) {
		this.examineeForeignLanguageId = examineeForeignLanguageId;
	}
	public String getExamineeForeignLanguageName() {
		return examineeForeignLanguageName;
	}
	public void setExamineeForeignLanguageName(String examineeForeignLanguageName) {
		this.examineeForeignLanguageName = examineeForeignLanguageName;
	}
	public String getExamineeIdNumber() {
		return examineeIdNumber;
	}
	public void setExamineeIdNumber(String examineeIdNumber) {
		this.examineeIdNumber = examineeIdNumber;
	}
	public String getExamineeRegistrationPointId() {
		return examineeRegistrationPointId;
	}
	public void setExamineeRegistrationPointId(String examineeRegistrationPointId) {
		this.examineeRegistrationPointId = examineeRegistrationPointId;
	}
	public String getExamineeRegistrationPointName() {
		return examineeRegistrationPointName;
	}
	public void setExamineeRegistrationPointName(String examineeRegistrationPointName) {
		this.examineeRegistrationPointName = examineeRegistrationPointName;
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
	public Byte getExamineeType() {
		return examineeType;
	}
	public void setExamineeType(Byte examineeType) {
		this.examineeType = examineeType;
	}
	public String getExamineeTypeView() {
		if (this.examineeType == null) {
			return ResourceBundle.getBundle("Messages").getString("Application.null");
		} else if (this.examineeType == 0) {
			return ResourceBundle.getBundle("Messages").getString("Application.type.0");
		} else if (this.examineeType == 1) {
			return ResourceBundle.getBundle("Messages").getString("Application.type.1");
		} else if (this.examineeType == 2) {
			return ResourceBundle.getBundle("Messages").getString("Application.type.2");
		} else if (this.examineeType == 3) {
			return ResourceBundle.getBundle("Messages").getString("Application.type.3");
		} else if (this.examineeType == 4) {
			return ResourceBundle.getBundle("Messages").getString("Application.type.4");
		} else {
			return ResourceBundle.getBundle("Messages").getString("Application.type.others");
		}
	}
	public void setExamineeTypeView(String examineeTypeView) {
		this.examineeTypeView = examineeTypeView;
	}
	public String getExamineeMemo() {
		return examineeMemo;
	}
	public void setExamineeMemo(String examineeMemo) {
		this.examineeMemo = examineeMemo;
	}
	public String getExamineeError() {
		return examineeError;
	}
	public void setExamineeError(String examineeError) {
		this.examineeError = examineeError;
	}
	public Byte getExamineeStatus() {
		return examineeStatus;
	}
	public void setExamineeStatus(Byte examineeStatus) {
		this.examineeStatus = examineeStatus;
	}
	public String getExamineeStatusView() {
		// ���null�ж�
		if (this.examineeStatus == null) {
			return ResourceBundle.getBundle("Messages").getString("Application.null");
		} else if (this.examineeStatus == 0) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeStatus.0");
		} else if (this.examineeStatus == 1) {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeStatus.1");
		} else {
			return ResourceBundle.getBundle("Messages").getString("Examinee.fieldName.examineeStatus.2");
		}
	}
	public void setExamineeStatusView(String examineeStatusView) {
		this.examineeStatusView = examineeStatusView;
	}
	public CountyDistrict getCountyDistrict() {
		return countyDistrict;
	}
	public void setCountyDistrict(CountyDistrict countyDistrict) {
		this.countyDistrict = countyDistrict;
	}
}
