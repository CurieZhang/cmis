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
<% String help = java.util.ResourceBundle.getBundle("Messages").getString("Navigation.help"); %>
          <div class="btn btn-warning">
            <a data-toggle="modal" data-original-title="<%=help%>" data-placement="bottom"
               class="btn btn-default btn-sm"
               href="#helpModal">
               <i class="fa fa-question"></i>
            </a>
          </div>
  <!-- mainContent -->
  <!-- cmis.Examinee.title -->
  <h3><s:text name="Examinee.title.add"/></h3>
  <!-- /cmis.Examinee.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>

  <s:form id="myForm" action="create" method="post" namespace="/admin/examinee" cssClass="form-horizontal" theme="simple" validate="false">
    <!-- examineeId -->
    <div class="form-group">
      <label class="col-sm-6 text-danger" for="examineeId">
        <s:text name="Examinee.fieldName.examineeId"/>&nbsp;<i class="fa fa-flag text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="examineeId" name="examineeId" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeId')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeId" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /examineeId -->
    <!-- examineeName -->
    <div class="form-group">
      <label class="col-sm-6 text-danger" for="examineeName">
        <s:text name="Examinee.fieldName.examineeName"/>&nbsp;<i class="fa fa-pen-fancy text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="examineeName" name="examineeName" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeName')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeName" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /examineeName -->
    <!-- examineeAddress -->
    <div class="form-group">
      <label class="col-sm-6 control-label" for="examineeAddress">
        <s:text name="Examinee.fieldName.examineeAddress"/>&nbsp;<i class="fa fa-mobile-alt text-danger"></i>
      </label>
      <div class="col-sm-6">
        <s:textfield id="examineeAddress" name="examineeAddress" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeAddress')}" cssClass="form-control"/>
      </div>
      <div class="col-sm-6">
        <s:fielderror fieldName="examineeAddress" cssClass="alert alert-danger"/>
      </div>
    </div>
    <!-- /examineeAddress -->
    <!-- examineeCreator -->
    <div class="form-group hidden">
      <label class="col-sm-6 control-label" for="examineeCreator">
        <s:text name="Examinee.fieldName.examineeCreator"/>&nbsp;<i class="fa fa-examinee text-danger"></i>
        &nbsp;&nbsp;&nbsp;&nbsp;
      </label>
      <div class="col-sm-6">
        <s:textfield id="examineeCreator" name="examineeCreator" value=""
                     placeholder="%{getText('Examinee.fieldPrompt.examineeCreator')}" class="form-control"/>
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
          <s:textfield id="examineeCreatingTime" name="examineeCreatingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeCreatingTime')}" cssClass="form-control"/>
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
            //format: 'YYYY-MM-DD',  
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
        <s:textfield id="examineeAuditor" name="examineeAuditor" 
                     placeholder="%{getText('Examinee.fieldPrompt.examineeAuditor')}" cssClass="form-control"/>
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
          <s:textfield id="examineeAuditingTime" name="examineeAuditingTime" 
                       placeholder="%{getText('Examinee.fieldPrompt.examineeAuditingTime')}" cssClass="form-control"/>
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
        	//format: 'YYYY-MM-DD',  
        	language: 'zh-CN'  
        });  
    });  
</script>
    <!-- examineeStatus -->
    <div class="form-group">
      <label class="col-sm-6 control-label text-danger" for="examineeStatus">
        <s:text name="Examinee.fieldName.examineeStatus"/>&nbsp;<i class="fa fa-arrow-circle-right text-danger"></i>
      </label>
      <div class="col-sm-6">
        <select data-placeholder="%{getText('Examinee.fieldName.examineeStatus')}" 
                id="examineeStatus" name="examineeStatus" class="selectpicker show-tick" data-width="100%" data-container="body">
          <option value="0" selected><s:text name="Examinee.fieldName.examineeStatus.0"/></option>
          <option value="1"><s:text name="Examinee.fieldName.examineeStatus.1"/></option>
          <option value="2"><s:text name="Examinee.fieldName.examineeStatus.2"/></option>
        </select>
      </div>
      <div class="col-sm-6 control-label">
        <s:fielderror fieldName="examineeStatus" />
      </div>
    </div>
    <!-- /examineeStatus -->
<% String reset = java.util.ResourceBundle.getBundle("Messages").getString("Examinee.button.reset"); %>
    <!-- button -->
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-6">
        <s:submit cssClass="btn btn-primary" value="%{getText('Examinee.button.save')}"/>
        <input type="button" id="reset" class="btn btn-info" value="<%=reset%>" onclick="cleanMyForm()"/>
      </div>
    </div>
    <!-- /button -->
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
  <!-- /mainContent -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Examinee.help.addTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Examinee.help.add"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>