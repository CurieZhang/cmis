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
  <h3><s:text name="Examinee.title.deleteConfirm"/></h3>
  <!-- /cmis.Examinee.title -->
  <hr>

  <s:form method="post" action="delete?examineeId=%{model.examineeId}" namespace="/admin/examinee" cssClass="form-horizontal" theme="simple">
    <p>
      <s:text name="Examinee.deleteConfirm.prompt">
        <s:param><s:text name="Examinee.deleteConfirm"/></s:param>
        <s:param><s:property value="model.examineeName" /></s:param>
      </s:text>
      <s:actionmessage cssClass="alert alert-danger"/>
    </p>
    <div class="btn-group">
      <input type="submit" value="<s:text name='Button.delete'/>" class="btn btn-danger" />
      <input type="button" value="<s:text name='Button.cancel'/>" class="btn btn-success" 
             onclick="window.location.href = '${pageContext.request.contextPath}/admin/examinee/index'" />
    </div>
  </s:form>
    <br />
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
    <h4 class="modal-title"><s:text name="Examinee.help.deleteConfirmTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Examinee.help.deleteConfirm"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</html>