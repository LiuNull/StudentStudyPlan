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
    <div class="panel-head"><strong class="icon-reorder">个人详细信息</strong></div>
    <table class="table table-hover text-center">
    <tr>
      <td>学生号：</td>      
      <td><s:property value="#session.student.studentid"/></td>     
    </tr> 
    
    <tr>
      <td>姓名：</td>      
      <td><s:property value="#session.student.name"/></td>     
    </tr> 
    
    <tr>
      <td>专业：</td>      
      <td><s:property value="#session.student.subject.name"/></td>      
    </tr>  

    <tr>
      <td>班级：</td>      
      <td><s:property value="#session.studentclazz"/></td>      
    </tr>  
    <tr>
      <td>年龄：</td>      
      <td><s:property value="#session.student.age"/></td>      
    </tr>   
    <tr>
      <td>性别：</td>      
      <td><s:if test="#session.student.sex==0">女</s:if>
      	<s:else>男</s:else>
      </td>      
    </tr>   
  </table>
  </div>
</form>
</body></html>