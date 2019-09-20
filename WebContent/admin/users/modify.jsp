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
  <!-- mainContent -->
  <!-- cmis.Users.title -->
  <h3><s:text name="Users.title.modify"/></h3>
  <!-- /cmis.Users.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>
  
  <s:form id="myForm" method="post" action="update?userId=%{userId}" namespace="/admin/users" cssClass="form-horizontal" theme="simple">
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userId"><s:text name="Users.fieldName.userId"/></label>
      <div class="col-sm-6">
        <s:if test="model.userId != null"> 
          <s:textfield id="userId" name="model.userId" readonly="true" cssClass="form-control"/>
        </s:if>
        <s:else>
          <s:textfield id="userId" name="userId" readonly="true" cssClass="form-control"/> 
        </s:else>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userId" />
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userName"><s:text name="Users.fieldName.userName"/></label>
      <div class="col-sm-6">
				<s:if test="model.userName != null"> 
	  			<s:textfield id="userName" name="model.userName" readonly="true" cssClass="form-control"/>
				</s:if>
				<s:else>
		   		<s:textfield id="userName" name="userName" readonly="true" cssClass="form-control"/> 
				</s:else>
	    </div>
	    <div class="col-sm-6">
	      <s:fielderror fieldName="userName" />
	    </div>
    </div>
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPassword"><s:text name="Users.fieldName.userPassword"/></label>
      <div class="col-sm-6">
	      <s:textfield id="userPassword" type="password" name="userPassword" placeholder="%{getText('Users.fieldPrompt.userPassword')}" cssClass="form-control" />
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userPassword" />
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPassword2"><s:text name="Users.fieldName.userPasswordConfirm"/></label>
      <div class="col-sm-6">
     		<s:textfield id="userPassword2" type="password" placeholder="%{getText('Users.fieldPrompt.userPasswordConfirm')}" name="userPassword2" cssClass="form-control" />
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="userPassword2" />
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-6 control-label" for="userPhone"><s:text name="Users.fieldName.userPhone"/></label>
      <div class="col-sm-6">
	      <s:if test="model.userPhone != null"> 
	        <s:textfield id="userPhone" name="model.userPhone" placeholder="%{getText('Users.fieldPrompt.userPhone')}" cssClass="form-control"/>
	      </s:if>
	      <s:else>
	        <s:textfield id="userPhone" name="userPhone" placeholder="%{getText('Users.fieldPrompt.userPhone')}" cssClass="form-control"/> 
	      </s:else>
      </div>
	    <div class="col-sm-6">
        <s:fielderror fieldName="userPhone" />
	    </div>
    </div>
<% String reset = java.util.ResourceBundle.getBundle("Messages").getString("Users.button.reset"); %>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-6">
        <s:submit cssClass="btn btn-primary" value="%{getText('Users.button.modify')}"/>
        <input type="button" id="reset" class="btn btn-info" value="<%=reset%>" onclick="cleanMyForm()"/>
      </div>
    </div>
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
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Users.help.modifyTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Users.help.modify"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>