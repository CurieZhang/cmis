package cn.lut.curiezhang.model;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * SSH框架进行考生管理的持久层的POJO类
 * @author curiezhang
 *
 */
public class Examinee {
	//	ksh    考生号
	private String examineeId;
	//	xm      姓名
	private String examineeName;
	// 照片
	private String examineePictureUrl;
	//	xbdm   性别代码
	private String examineeSexId;
	@SuppressWarnings("unused")
	private String examineeSexIdView;
	//	xbdm   性别名称
	private String examineeSexName;
	//	csrq    出生日期
	private Date examineeBirthday;
	// 联系地址
	private String examineeAddress;
	// 邮政编码
	private String examineeZipCode;
	// 联系电话
	private String examineeContactPhone;
	// 移动电话
	private String examineeMobilePhone;
	// 县区代码
	private String examineeCountyDistrictId;
	// 县区名称
	private String examineeCountyDistrictName;
	//	zzmmdm   政治面貌代码
	private String examineePoliticalStatusId;
	//	zzmmdm   政治面貌名称
	private String examineePoliticalStatusName;
	//	mzdm      民族代码
	private String examineeNationalityId;
	//	mzdm      民族名称
	private String examineeNationalityName;
	//	kslxdm    考生类型代码   
	private String examineeExamineeTypeId;
	//	kslxdm    考生类型名称
	private String examineeExamineeTypeName;
	//	kldm       科类代码      见科类代码表
	private String examineeDisciplineId;
	//	klmc     科类名称          见科类代码表
	private String examineeDisciplineName;
	//	kslbdm    考生类别代码     
	private String examineeExamineeCategoryId;
	//	kslbdm    考生类别名称
	private String examineeExamineeCategoryName;
	//	bylbdm  毕业类别代码    省考试院文件里应该有此项
	private String examineeGraduationCategoryId;
	//	Bylbmc  毕业类别名称    普通高中毕业   其他中等专业学校毕业   职业高中毕业 中等师范毕业
	private String examineeGraduationCategoryName;
	//	byxxmc  毕业学校代码
	private String examineeGraduationSchoolId;
	//	byxxmc  毕业学校名称 
	private String examineeGraduationSchoolName;
	//	wyyzdm  外语语种代码
	private String examineeForeignLanguageId;
	//	Wyyzmc  外语语种名称
	private String examineeForeignLanguageName;
	//	sfzh   身份证号
	private String examineeIdNumber;
	//	bmddm   报名点代码
	private String examineeRegistrationPointId;
	//	Bmdmc   报名点名称
	private String examineeRegistrationPointName;
	// 创建人
	private String examineeCreator;
	// 创建时间
	private Date examineeCreatingTime;
	// 审核人
	private String examineeAuditor;
	// 审核时间
	private Date examineeAuditingTime;
	// 类型	0整个平台 1学生 2院校 3考点 4管理机构
	private Byte examineeType;
	@SuppressWarnings("unused")
	private String examineeTypeView;
	// 备注
	private String examineeMemo;
	// 错误（信息有错误时使用）
	private String examineeError;
	// 状态 0正常 1确认 2有错误
	private Byte examineeStatus;
	@SuppressWarnings("unused")
	private String examineeStatusView;
	// 考生科类
	private Discipline discipline;
	// 县区代码
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
		// 添加null判断
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
