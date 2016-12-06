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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改课程</strong></div>
  <div class="body-content">
  
  	 <form method="post" class="form-x" action="managersearchpractice.action">
      <div class="form-group">
        <div class="field">
          <input type="text" id="url1" name="kechengid" class="input tips" style="width:25%; float:left;"  value=""  placeholder="请输入需要修改的课程号"/>
          &nbsp;&nbsp;
         <button class="button bg-main icon-check-square-o" type="submit"> 查询</button>
        </div>
      </div>
    </form>
    
    <form method="post" class="form-x" action="managerupdatePractice.action">      
      <div class="form-group">

      	<div class="label">
          <label>实践环节号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="kechengid" value="<s:property value="#session.practice.kechengid"/>" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>

	  <div class="form-group">
        <div class="label">
          <label>实践环节名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name" value="<s:property value="#session.practice.name"/>" />
          <div class="tips"></div>
        </div>
      </div>      

      <div class="form-group">
        <div class="label">
          <label>学分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="credit" value="<s:property value="#session.practice.credit"/>"/>         
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>周数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="week" value="<s:property value="#session.practice.week"/>"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学期：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="term" value="<s:property value="#session.practice.term"/>"/>        
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>是否为选修：</label>
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
          <button class="button bg-main icon-check-square-o" type="submit">修改</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>