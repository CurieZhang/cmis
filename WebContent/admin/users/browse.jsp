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
  <h3><s:text name="Users.title.browse"/> - <s:property value="model.userName"/></h3>
  <!-- /cmis.Users.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>
  
  <table class="table table-striped">
    <!-- userId -->
    <tr>
      <td class="span3 verticalMiddle text-right" width="120px"><s:text name="Users.fieldName.userId"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.userId"/></td>
    </tr>
    <!-- /userId -->
    <!-- userName -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Users.fieldName.userName"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.userName"/></td>
    </tr>
    <!-- /userName -->
    <!-- userPhone -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Users.fieldName.userPhone"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.userPhone"/></td>
    </tr>
    <!-- /userPhone -->
    <!-- userCreator -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Users.fieldName.userCreator"/>
      </td>
      <td class="span9 verticalMiddle"><s:property value="model.userCreator"/></td>
    </tr>
    <!-- /userCreator -->
    <!-- userCreatingTime -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Users.fieldName.userCreatingTime"/>
      </td>
      <td class="span9 verticalMiddle"><s:date name="model.userCreatingTime" format="yyyy年MM月dd日"/></td>
    </tr>
    <!-- /userCreatingTime -->
    <!-- userAuditor -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Users.fieldName.userAuditor"/>
      </td>
      <td class="span9 verticalMiddle"><s:property value="model.userAuditor"/></td>
    </tr>
    <!-- /userAuditor -->
    <!-- userAuditingTime -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Users.fieldName.userAuditingTime"/>
      </td>
      <td class="span9 verticalMiddle"><s:date name="model.userAuditingTime" format="yyyy年MM月dd日"/></td>
    </tr>
    <!-- /userAuditingTime -->
    <!-- status -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Users.fieldName.status"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.status.information"/></td>
    </tr>
    <!-- /status -->
  </table>
  
  <hr>
  <a href="${pageContext.request.contextPath}/admin/users/index" class="btn btn-info">
    <!-- cmis.Users.home -->
    <span class="glyphicon glyphicon-arrow-left"></span> <s:text name="Users.button.home"/>
    <!-- /cmis.Users.home -->
  </a>
  <!-- BLANK -->
  <br/><br>
  <!-- /BLANK -->
  <!-- /mainContent -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Users.help.browseTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Users.help.browse"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>