<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- cmis.title -->
  <title><s:text name="Application.name"/> - <s:text name="Examinee.page.title"/></title>
  <!-- /cmis.title -->
  <jsp:include page="../includes/beginning-notheme.jsp" flush="true" />	
</head>
<body>
  <h4>
    <!-- cmis.navigation -->
    <i class="fa fa-home"></i>&nbsp;
    <a href="${pageContext.request.contextPath}/"><s:text name="Navigation.application.homepage"/></a>
    &nbsp;<i class="fa fa-angle-right"></i>&nbsp;
    <a href="${pageContext.request.contextPath}/admin/index"><s:text name="Navigation.admin.homepage"/></a>
    &nbsp;<i class="fa fa-angle-right"></i>&nbsp;
    <a href="${pageContext.request.contextPath}/admin/examinee/index"><s:text name="Navigation.admin.examinee.homepage"/></a>
    <!-- /cmis.navigation -->
  </h4>
  <!-- mainContent -->
  <!-- cmis.Examinee.title -->
  <h3><s:text name="Examinee.title.modify"/></h3>
  <!-- /cmis.Examinee.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>
  
  <s:form id="myForm" method="post" action="update?examineeId=%{examineeId}" namespace="/admin/examinee" cssClass="form-horizontal" theme="simple">
   <!-- examineeId -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="examineeId"><s:text name="Examinee.fieldName.examineeId"/>&nbsp;<i class="fa fa-flag text-danger"></i></label>
      <div class="col-sm-6">
        <s:if test="model.examineeId != null"> 
          <s:textfield id="examineeId" name="model.examineeId" readonly="true" cssClass="form-control"/>
        </s:if>
        <s:else>
          <s:textfield id="examineeId" name="examineeId" readonly="true" cssClass="form-control"/> 
        </s:else>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeId" />
      </div>
    </div>
   <!-- /examineeId -->
   <!-- examineeName -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="examineeName"><s:text name="Examinee.fieldName.examineeName"/>&nbsp;<i class="fa fa-pen-fancy text-danger"></i></label>
      <div class="col-sm-6">
				<s:if test="model.examineeName != null"> 
	  			<s:textfield id="examineeName" name="model.examineeName" readonly="true" cssClass="form-control"/>
				</s:if>
				<s:else>
		   		<s:textfield id="examineeName" name="examineeName" readonly="true" cssClass="form-control"/> 
				</s:else>
	    </div>
	    <div class="col-sm-6">
	      <s:fielderror fieldName="examineeName" />
	    </div>
    </div>
   <!-- /examineeName -->
   <!-- /examineeCreator -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="examineeAddress"><s:text name="Examinee.fieldName.examineeAddress"/>&nbsp;<i class="fa fa-mobile-alt text-danger"></i></label>
      <div class="col-sm-6">
	      <s:if test="model.examineeAddress != null"> 
	        <s:textfield id="examineeAddress" name="model.examineeAddress" placeholder="%{getText('Examinee.fieldPrompt.examineeAddress')}" cssClass="form-control"/>
	      </s:if>
	      <s:else>
	        <s:textfield id="examineeAddress" name="examineeAddress" placeholder="%{getText('Examinee.fieldPrompt.examineeAddress')}" cssClass="form-control"/> 
	      </s:else>
      </div>
	    <div class="col-sm-6">
        <s:fielderror fieldName="examineeAddress" />
	    </div>
    </div>
    <!-- /examineeCreator -->
    <!-- examineeCreator -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="examineeCreator">
        <s:text name="Examinee.fieldName.examineeCreator"/>&nbsp;<i class="fa fa-examinee text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <s:if test="model.examineeCreator != null"> 
          <s:textfield id="examineeCreator" name="model.examineeCreator" value=""
                     placeholder="%{getText('Examinee.fieldPrompt.examineeCreator')}" class="form-control"/>
        </s:if>
        <s:else>
          <s:textfield id="examineeCreator" name="examineeCreator" value=""
                     placeholder="%{getText('Examinee.fieldPrompt.examineeCreator')}" class="form-control"/>
        </s:else>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeCreator" />
      </div>
    </div>
    <!-- /examineeCreator -->
    <!-- examineeCreatingTime -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="examineeCreatingTime">
        <s:text name="Examinee.fieldName.examineeCreatingTime"/>&nbsp;<i class="fa fa-calendar text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <div class="input-group date" id='datetimepicker1'>
	        <s:if test="model.examineeCreatingTime != null"> 
	          <s:textfield id="examineeCreatingTime" name="model.examineeCreatingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeCreatingTime')}" cssClass="form-control"/>
	        </s:if>
	        <s:else>
            <s:textfield id="examineeCreatingTime" name="examineeCreatingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeCreatingTime')}" cssClass="form-control"/>
	        </s:else>
          <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
          </span>
        </div>
        <%-- <s:textfield id="examineeCreatingTime" name="examineeCreatingTime" value=""
                     placeholder="%{getText('Examinee.fieldPrompt.examineeCreatingTime')}" class="form-control"/> --%>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeCreatingTime" />
      </div>
    </div>
    <!-- /examineeCreatingTime -->
<script>
    $(function () {  
        $('#datetimepicker1').datetimepicker({  
            fontAwesome:'font-awesome',  
            format: 'yyyy-mm-dd',  
            language: 'zh-CN'  
        });  
    });  
</script>
    <!-- examineeAuditor -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="examineeAuditor">
        <s:text name="Examinee.fieldName.examineeAuditor"/>&nbsp;<i class="fa fa-examinee text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <s:if test="model.examineeAuditor != null"> 
          <s:textfield id="examineeAuditor" name="model.examineeAuditor" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeAuditor')}" cssClass="form-control"/>
        </s:if>
        <s:else>
          <s:textfield id="examineeAuditor" name="examineeAuditor" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeAuditor')}" cssClass="form-control"/>
        </s:else>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeAuditor" />
      </div>
    </div>
    <!-- /examineeAuditor -->
    <!-- examineeAuditingTime -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="examineeAuditingTime">
        <s:text name="Examinee.fieldName.examineeAuditingTime"/>&nbsp;<i class="fa fa-calendar text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <div class="input-group date" id='datetimepicker2'>
          <s:if test="model.examineeAuditingTime != null"> 
            <s:textfield id="examineeAuditingTime" name="model.examineeAuditingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeAuditingTime')}" cssClass="form-control"/>
          </s:if>
          <s:else>
            <s:textfield id="examineeAuditingTime" name="examineeAuditingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeAuditingTime')}" cssClass="form-control"/>
          </s:else>
          <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
          </span>
        </div>
        <%-- <s:textfield id="examineeAuditingTime" name="examineeAuditingTime" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeAuditingTime')}" cssClass="form-control"/> --%>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeAuditingTime" />
      </div>
    </div>
    <!-- /examineeAuditingTime -->
<script>
    $(function () {  
        $('#datetimepicker2').datetimepicker({  
          fontAwesome:'font-awesome',  
          format: 'yyyy-mm-dd',  
          language: 'zh-CN'  
        });  
    });  
</script>
    <!-- status -->
    <div class="form-group">
      <label class="col-sm-6 control-label text-danger" for="status">
        <s:text name="Examinee.fieldName.examineeStatus"/>&nbsp;<i class="fa fa-arrow-circle-right text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:select id="examineeStatus" name="model.examineeStatus" 
                  list="#{0:getText('Examinee.fieldName.examineeStatus.0'), 1:getText('Examinee.fieldName.examineeStatus.1'), 2:getText('Examinee.fieldName.examineeStatus.2')}" 
                  listKey="key" listValue="value" value="%{model.examineeStatus}"
                  class="selectpicker show-tick" data-width="100%" data-container="body"/>
      </div>
      <div class="col-sm-6 control-label">
        <s:fielderror fieldName="examineeStatus" />
      </div>
    </div>
    <!-- /status -->
<% String reset = java.util.ResourceBundle.getBundle("Messages").getString("Examinee.button.reset"); %>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-6">
        <s:submit cssClass="btn btn-primary" value="%{getText('Examinee.button.modify')}"/>
        <input type="button" id="reset" class="btn btn-info" value="<%=reset%>" onclick="cleanMyForm()"/>
      </div>
    </div>
  </s:form>
  <hr>
  <a href="${pageContext.request.contextPath}/admin/examinee/index" class="btn btn-info">
    <!-- cmis.Examinee.home -->
    <span class="glyphicon glyphicon-arrow-left"></span> <s:text name="Examinee.button.home"/>
    <!-- /cmis.Examinee.home -->
  </a>
  <!-- BLANK -->
  <br/><br/>
  <!-- /BLANK -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Examinee.help.modifyTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Examinee.help.modify"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>