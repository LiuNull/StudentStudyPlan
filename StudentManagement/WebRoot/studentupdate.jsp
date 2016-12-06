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
<!-- <form method="post" action="studentlistPlan"> -->
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">修改个人信息</strong></div>
    <!-- <div class="body-content"> -->
    <form method="post" class="form-x" action="studentupdateInfo.action">      
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="name" value="<s:property value="#session.student.name"/>" />
          <div class="tips"></div>
        </div>
      </div>        
      <div class="form-group">
        <div class="label">
          <label>旧密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="password" value="<s:property value="#session.student.password"/>" readonly="readonly"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="newpassword" value=""  placeholder="请输入新的密码"/>         
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="newpassword2" value="" placeholder="请重新输入新的密码"/>         
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="age" value="<s:property value="#session.student.age"/>"/>        
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="radio" name="sex" value="1" />男
			<br />  
			<input type="radio" name="sex" value="0" />女   
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  <!-- </div> -->
  </div>
<!-- </form> -->
</body></html>