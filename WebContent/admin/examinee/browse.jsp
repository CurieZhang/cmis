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
  <h3><s:text name="Examinee.title.browse"/> - <s:property value="model.examineeName"/></h3>
  <!-- /cmis.Examinee.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>
  
  <table class="table table-striped">
    <!-- examineeId -->
    <tr>
      <td class="span3 verticalMiddle text-right" width="120px"><s:text name="Examinee.fieldName.examineeId"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeId"/></td>
    </tr>
    <!-- /examineeId -->
    <!-- examineeName -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Examinee.fieldName.examineeName"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeName"/></td>
    </tr>
    <!-- /examineeName -->
    <!-- examineeAddress -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Examinee.fieldName.examineeAddress"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeAddress"/></td>
    </tr>
    <!-- /examineeAddress -->
    <!-- examineeCreator -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Examinee.fieldName.examineeCreator"/>
      </td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeCreator"/></td>
    </tr>
    <!-- /examineeCreator -->
    <!-- examineeCreatingTime -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Examinee.fieldName.examineeCreatingTime"/>
      </td>
      <td class="span9 verticalMiddle"><s:date name="model.examineeCreatingTime" format="yyyy年MM月dd日"/></td>
    </tr>
    <!-- /examineeCreatingTime -->
    <!-- examineeAuditor -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Examinee.fieldName.examineeAuditor"/>
      </td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeAuditor"/></td>
    </tr>
    <!-- /examineeAuditor -->
    <!-- examineeAuditingTime -->
    <tr class="hidden">
      <td class="span3 verticalMiddle text-right" width="120px">
        <s:text name="Examinee.fieldName.examineeAuditingTime"/>
      </td>
      <td class="span9 verticalMiddle"><s:date name="model.examineeAuditingTime" format="yyyy年MM月dd日"/></td>
    </tr>
    <!-- /examineeAuditingTime -->
    <!-- status -->
    <tr>
      <td class="span3 verticalMiddle text-right"><s:text name="Examinee.fieldName.examineeStatus"/></td>
      <td class="span9 verticalMiddle"><s:property value="model.examineeStatusView"/></td>
    </tr>
    <!-- /status -->
  </table>
  
  <hr>
  <a href="${pageContext.request.contextPath}/admin/examinee/index" class="btn btn-info">
    <!-- cmis.Examinee.home -->
    <span class="glyphicon glyphicon-arrow-left"></span> <s:text name="Examinee.button.home"/>
    <!-- /cmis.Examinee.home -->
  </a>
  <!-- BLANK -->
  <br/><br>
  <!-- /BLANK -->
  <!-- /mainContent -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Examinee.help.browseTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Examinee.help.browse"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>