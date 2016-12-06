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
  <div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>新增课程</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="manageraddKecheng.action">      
      <div class="form-group">

      	<div class="label">
          <label>课程号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="kechengid" value="" />
          <div class="tips"></div>
        </div>
      </div>

	  <div class="form-group">
        <div class="label">
          <label>课程名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name" value="" />
          <div class="tips"></div>
        </div>
      </div>      

      <div class="form-group">
        <div class="label">
          <label>学分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="credit" value=""/>         
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>总学时：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="totaltime" value=""/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学期：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="term" value=""/>        
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>是否选修：</label>
        </div>
        <div class="field">
          <input type="radio" name="iselective" value="1" />选修
			<br />  
			<input type="radio" name="iselective" value="0" />必修
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 增加</button>
        </div>
      </div>
      
      
    </form>
  </div>
</div>
</body></html>