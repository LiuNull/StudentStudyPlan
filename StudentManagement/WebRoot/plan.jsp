<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="studentlistPlan">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">专业培养计划列表</strong></div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th width="240">专业</th>       
        <th width="240">学期</th>     
      </tr> 
     	<s:iterator value="#session.plans" var="plans">
        <tr>
          <td><s:property value="#plans.planid"/></td>
          <td><s:property value="#plans.subject.name"/></td>
          <td><s:property value="#plans.term"/></td>
        </tr>
        </s:iterator>
    </table>
  </div>
</form>
</body></html>