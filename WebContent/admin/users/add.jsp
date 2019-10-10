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
  <title><s:text name="Application.name"/> - <s:text name="Users.page.title"/></title>
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
    <a href="${pageContext.request.contextPath}/admin/users/index"><s:text name="Navigation.admin.users.homepage"/></a>
    <!-- /cmis.navigation -->
  </h4>
<% String help = java.util.ResourceBundle.getBundle("Messages").getString("Navigation.help"); %>
          <div class="btn btn-warning">
            <a data-toggle="modal" data-original-title="<%=help%>" data-placement="bottom"
               class="btn btn-default btn-sm"
               href="#helpModal">
               <i class="fa fa-question"></i>
            </a>
          </div>
  <!-- mainContent -->
  <!-- cmis.Users.title -->
  <h3><s:text name="Users.title.add"/></h3>
  <!-- /cmis.Users.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>

  <s:form id="myForm" action="create" method="post" namespace="/admin/users" cssClass="form-horizontal" theme="simple" validate="false">
    <!-- userId -->
    <div class="form-group">
      <label class="col-sm-6 text-danger" for="userId">
        <s:text name="Users.fieldName.userId"/>&nbsp;<i class="fa fa-flag text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="userId" name="userId" 
                     placeholder="%{getText('Users.fieldPrompt.userId')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userId" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /userId -->
    <!-- userName -->
    <div class="form-group">
      <label class="col-sm-6 text-danger" for="userName">
        <s:text name="Users.fieldName.userName"/>&nbsp;<i class="fa fa-pen-fancy text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="userName" name="userName" 
                     placeholder="%{getText('Users.fieldPrompt.userName')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userName" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /userName -->
    <!-- userPassword -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPassword">
        <s:text name="Users.fieldName.userPassword"/>&nbsp;<i class="fa fa-ellipsis-h text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="userPassword" name="userPassword" type="password" 
                     placeholder="%{getText('Users.fieldPrompt.userPassword')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userPassword" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /userPassword -->
    <!-- userPassword2 -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPassword2">
        <s:text name="Users.fieldName.userPasswordConfirm"/>&nbsp;<i class="fa fa-ellipsis-h text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="userPassword2" type="password" 
                     placeholder="%{getText('Users.fieldPrompt.userPasswordConfirm')}" name="userPassword2" cssClass="form-control" />
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userPassword2" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /userPassword2 -->
    <!-- userPhone -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPhone">
        <s:text name="Users.fieldName.userPhone"/>&nbsp;<i class="fa fa-mobile-alt text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="userPhone" name="userPhone" 
                     placeholder="%{getText('Users.fieldPrompt.userPhone')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userPhone" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /userPhone -->
    <!-- userCreator -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="userCreator">
        <s:text name="Users.fieldName.userCreator"/>&nbsp;<i class="fa fa-user text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <s:textfield id="userCreator" name="userCreator" value=""
                     placeholder="%{getText('Users.fieldPrompt.userCreator')}" class="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userCreator" />
      </div>
    </div>
    <!-- /userCreator -->
    <!-- userCreatingTime -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="userCreatingTime">
        <s:text name="Users.fieldName.userCreatingTime"/>&nbsp;<i class="fa fa-calendar text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <div class="input-group date" id='datetimepicker1'>
          <s:textfield id="userCreatingTime" name="userCreatingTime" 
                       placeholder="%{getText('Users.fieldPrompt.userCreatingTime')}" cssClass="form-control"/>
          <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
          </span>
        </div>
        <%-- <s:textfield id="userCreatingTime" name="userCreatingTime" value=""
                     placeholder="%{getText('Users.fieldPrompt.userCreatingTime')}" class="form-control"/> --%>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userCreatingTime" />
      </div>
    </div>
    <!-- /userCreatingTime -->
<script>
    $(function () {  
        $('#datetimepicker1').datetimepicker({  
            fontAwesome:'font-awesome',  
            //format: 'YYYY-MM-DD',  
            language: 'zh-CN'  
        });  
    });  
</script>
    <!-- userAuditor -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="userAuditor">
        <s:text name="Users.fieldName.userAuditor"/>&nbsp;<i class="fa fa-user text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <s:textfield id="userAuditor" name="userAuditor" 
                     placeholder="%{getText('Users.fieldPrompt.userAuditor')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userAuditor" />
      </div>
    </div>
    <!-- /userAuditor -->
    <!-- userAuditingTime -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="userAuditingTime">
        <s:text name="Users.fieldName.userAuditingTime"/>&nbsp;<i class="fa fa-calendar text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <div class="input-group date" id='datetimepicker2'>
          <s:textfield id="userAuditingTime" name="userAuditingTime" 
                       placeholder="%{getText('Users.fieldPrompt.userAuditingTime')}" cssClass="form-control"/>
          <span class="input-group-addon">  
            <span class="glyphicon glyphicon-calendar"></span>  
          </span>
        </div>
        <%-- <s:textfield id="userAuditingTime" name="userAuditingTime" 
                     placeholder="%{getText('Users.fieldPrompt.userAuditingTime')}" cssClass="form-control"/> --%>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userAuditingTime" />
      </div>
    </div>
    <!-- /userAuditingTime -->
<script>
    $(function () {  
        $('#datetimepicker2').datetimepicker({  
        	fontAwesome:'font-awesome',  
        	//format: 'YYYY-MM-DD',  
        	language: 'zh-CN'  
        });  
    });  
</script>
    <!-- status -->
    <div class="form-group">
      <label class="col-sm-6 control-label text-danger" for="status">
        <s:text name="Users.fieldName.status"/>&nbsp;<i class="fa fa-arrow-circle-right text-danger"></i>
      </label>
      <div class="col-sm-6">
        <select data-placeholder="%{getText('Users.fieldPrompt.status')}" 
                id="status" name="status" class="selectpicker show-tick" data-width="100%" data-container="body">
          <option value="STUDENT" selected><s:text name="Users.status.STUDENT"/></option>
          <option value="COLLEGE"><s:text name="Users.status.COLLEGE"/></option>
          <option value="SITE"><s:text name="Users.status.SITE"/></option>
          <option value="ADMINISTRATOR"><s:text name="Users.status.ADMINISTRATOR"/></option>
          <option value="LOCK_STUDENT"><s:text name="Users.status.LOCK_STUDENT"/></option>
          <option value="LOCK_COLLEGE"><s:text name="Users.status.LOCK_COLLEGE"/></option>
          <option value="LOCK_SITE"><s:text name="Users.status.LOCK_SITE"/></option>
          <option value="LOCK_ADMINISTRATOR"><s:text name="Users.status.LOCK_ADMINISTRATOR"/></option>
          <option value="FIND_PASSWORD_STUDENT"><s:text name="Users.status.FIND_PASSWORD_STUDENT"/></option>
          <option value="FIND_PASSWORD_COLLEGE"><s:text name="Users.status.FIND_PASSWORD_COLLEGE"/></option>
          <option value="FIND_PASSWORD_SITE"><s:text name="Users.status.FIND_PASSWORD_SITE"/></option>
          <option value="FIND_PASSWORD_ADMINISTRATOR"><s:text name="Users.status.FIND_PASSWORD_ADMINISTRATOR"/></option>
        </select>
      </div>
      <div class="col-sm-6 control-label">
        <s:fielderror fieldName="status" />
      </div>
    </div>
    <!-- /status -->
<% String reset = java.util.ResourceBundle.getBundle("Messages").getString("Users.button.reset"); %>
    <!-- button -->
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-6">
        <s:submit cssClass="btn btn-primary" value="%{getText('Users.button.save')}"/>
        <input type="button" id="reset" class="btn btn-info" value="<%=reset%>" onclick="cleanMyForm()"/>
      </div>
    </div>
    <!-- /button -->
  </s:form>
  <hr>
  <a href="${pageContext.request.contextPath}/admin/users/index" class="btn btn-info">
    <!-- cmis.Users.home -->
    <span class="glyphicon glyphicon-arrow-left"></span> <s:text name="Users.button.home"/>
    <!-- /cmis.Users.home -->
  </a>
  <!-- BLANK -->
  <br/><br/>
  <!-- /BLANK -->
  <!-- /mainContent -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Users.help.addTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Users.help.add"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>