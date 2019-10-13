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
    <s:text name="Navigation.admin.examinee.homepage"/>
    <!-- /cmis.navigation -->
  </h4>
  <!-- mainContent -->
  <!-- cmis.Examinee.title -->
  <h3><s:text name="Examinee.title.index"/></h3>
  <!-- /cmis.Examinee.title -->
  <hr>
  <s:actionmessage cssClass="alert alert-danger"/>
            
  <table id="dataTable" class="table table-striped table-hover" style="width:100%;">
    <thead>
      <tr>
        <th><s:text name="Examinee.fieldName.examineeId"/></th>
        <th><s:text name="Examinee.fieldName.examineeName"/></th>
        <th><s:text name="Examinee.fieldName.examineePassword"/></th>
        <th><s:text name="Examinee.fieldName.examineePhone"/></th>
        <th><s:text name="Examinee.fieldName.examineeAuditingTime"/></th>
        <th><s:text name="Examinee.fieldName.status"/></th>
        <th width="300px"><s:text name="DataTables.title.operate"/></th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <th><s:text name="Examinee.fieldName.examineeId"/></th>
        <th><s:text name="Examinee.fieldName.examineeName"/></th>
        <th><s:text name="Examinee.fieldName.examineePassword"/></th>
        <th><s:text name="Examinee.fieldName.examineePhone"/></th>
        <th><s:text name="Examinee.fieldName.examineeAuditingTime"/></th>
        <th><s:text name="Examinee.fieldName.status"/></th>
        <th width="300px"><s:text name="DataTables.title.operate"/></th>
      </tr>
    </tfoot>
    <tbody><s:iterator value="model">
      <tr>
        <td class="verticalMiddle">${examineeId}</td>
        <td class="verticalMiddle"><s:property value="examineeName"/></td>
        <td class="verticalMiddle"><s:property value="examineePassword"/></td>
        <td class="verticalMiddle"><s:property value="examineePhone"/></td>
        <td class="verticalMiddle">
          <s:if test="examineeAuditingTime != null">
            <s:date name="examineeAuditingTime" format="yyyy年MM月dd日" />
          </s:if>
        </td>
        <td class="verticalMiddle"><s:property value="status.information"/></td>
        <td width="230px" class="verticalMiddle">
          <div class="btn-group">
            <a href="browse?examineeId=${examineeId}" class="btn btn-success">
              <span class="glyphicon glyphicon-eye-open"></span> <s:text name="DataTables.title.browse"/>
            </a>
            <a href="modify?examineeId=${examineeId}" class="btn btn-warning">
              <span class="glyphicon glyphicon-edit"></span> <s:text name="DataTables.title.modify"/>
            </a>
            <a href="deleteConfirm?examineeId=${examineeId}" class="btn btn-danger">
              <span class="glyphicon glyphicon-trash"></span> <s:text name="DataTables.title.delete"/>
            </a>
          </div>
       </td>
      </tr></s:iterator>
    </tbody>
  </table>
  <script type="text/javascript">
    "use strict";
    $(document).ready(function() {
      $('#dataTable').DataTable( {
        // 功能启用
        "paging":   true,
        "ordering": true,
        "info":     true,
        //分页样式：simple,simple_numbers,full,full_numbers
        "pagingType": "simple_numbers", 
        // 垂直滚动条
        //"scrollY": 350,
        //"scrollCollapse": true,
        // jQueryUI样式支持
        // "jQueryUI": true,
        "renderer": "bootstrap",
        // 保存状态
        "stateSave": true,
        "language": {
          // 格式化数字显示格式
          "decimal":",",
          "thousands":".",
          // 语言国际化
          "lengthMenu": "每页 _MENU_ 条记录",
          "search": "搜索：",
          "zeroRecords": "没有找到记录",
          "info": "当前显示第 _START_ 至 _END_ 项（共 _TOTAL_ 项），正在第 _PAGE_ 页（共 _PAGES_ 页）",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "processing": "处理中...",
          "emptyTable": "表中数据为空",
          "loadingRecords": "载入中...",
          "infoThousands": ",",
          "paginate": {
              "first": "首页",
              "previous": "上页",
              "next": "下页",
              "last": "末页",
              "jump": "跳转"
          }
        },
        // 隐藏列
        "columnDefs": [
          {
            "targets": [ 0 ],
            "visible": false,
            "searchable": false
          },
          {
            "targets": [ 2 ],
            "visible": false
          }
        ],
        // 跟数组下标一样，第一列从0开始，这里表格初始化时，第四列默认降序
        "order": [[ 1, "desc" ]]
      } );
    } );
  </script>
  <hr>
  <a href="${pageContext.request.contextPath}/admin/examinee/add" class="btn btn-primary">
    <span class="glyphicon glyphicon-file"></span> <s:text name="Examinee.button.add"/> 
  </a>
  <!-- BLANK -->
  <br/><br>
  <!-- /BLANK -->
  <!-- /mainContent -->
  <!-- cmis.help -->
  <jsp:include page="../includes/help1.jsp" flush="true" />
    <h4 class="modal-title"><s:text name="Examinee.help.indexTitle"/></h4>
  <jsp:include page="../includes/help2.jsp" flush="true" />
    <p>
      <s:text name="Examinee.help.index"/>
    </p>
  <jsp:include page="../includes/help3.jsp" flush="true" />
  <!-- /cmis.help -->
</body>
</html>