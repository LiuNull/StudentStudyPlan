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
<form method="post" action="managerlistKechengByTerm">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">课程列表</strong></div>
<div class="body-content">

    <form method="post" class="form-x" action="managerlistKechengByTerm">
      <div class="form-group">
        <div class="field">
          <input type="text" id="url1" name="term" class="input tips" style="width:25%; float:left;"  value=""  placeholder="请输入需要查询的学期"/>
          &nbsp;&nbsp;
         <button class="button bg-main icon-check-square-o" type="submit"> 查询</button>
        </div>
      </div>
    </form>
    
  </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">课程ID</th>
        <th width="120">课程名</th>       
        <th width="120">学分</th>
        <th width="120">总学时</th>       
        <th width="120">学期</th>
        <th width="120">所属专业</th>      
      </tr> 
     	<s:iterator value="#session.kechengs" var="kechengs">
        <tr>
          <td><s:property value="#kechengs.kechengid"/></td>
          <td><s:property value="#kechengs.name"/></td>
          <td><s:property value="#kechengs.credit"/></td>
          <td><s:property value="#kechengs.totaltime"/></td>
          <td><s:property value="#kechengs.term"/></td>
          <td><s:property value="#kechengs.subject.name"/></td>
        </tr>
        </s:iterator>
    </table>
  </div>
</form>
</body></html>