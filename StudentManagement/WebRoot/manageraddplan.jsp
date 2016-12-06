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

<form method="post" action="manageraddPlan.action">
	<div class="panel admin-panel">
	    <div class="panel-head"><strong class="icon-reorder">新增培养计划</strong></div>
	<div class="body-content">
	<div class="label">
          <label>专业计划号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="planid" value="" />
          <div class="tips"></div>
        </div>
        <div class="form-group">
        <div class="label">
          <label>学期：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="term" value="" />
          <div class="tips"></div>
        </div>
      </div> 
          <table class="table table-hover text-center">
      <tr>
      	<th width="120">是否添加</th>
        <th width="120">课程ID</th>
        <th width="120">课程名</th>       
        <th width="120">学分</th>
        <th width="120">总学时</th>       
        <th width="120">学期</th>
        <th width="120">所属专业</th>      
      </tr> 
     	<s:iterator value="#session.kechengs" var="kechengs">
        <tr>
        <td><input type="checkbox" name="somekechengid" value="<s:property value="#kechengs.kechengid"/>" /></td>
        <td><s:property value="#kechengs.kechengid"/></td>
          <td><s:property value="#kechengs.name"/></td>
          <td><s:property value="#kechengs.credit"/></td>
          <td><s:property value="#kechengs.totaltime"/></td>
          <td><s:property value="#kechengs.term"/></td>
          <td><s:property value="#kechengs.subject.name"/></td>
        </tr>
        </s:iterator>
    </table>
    
     <table class="table table-hover text-center">
      <tr>
        <th width="120">实践环节ID</th>
        <th width="120">实践环节名</th>       
        <th width="120">学分</th>
        <th width="120">周数</th>       
        <th width="120">学期</th>
        <th width="120">所属专业</th>      
      </tr> 
     	<s:iterator value="#session.practices" var="practices">
        <tr>
        <td><input type="checkbox" name="somepracticeid" value="<s:property value="#practices.kechengid"/>" /></td>
          <td><s:property value="#practices.kechengid"/></td>
          <td><s:property value="#practices.name"/></td>
          <td><s:property value="#practices.credit"/></td>
          <td><s:property value="#practices.week"/></td>
          <td><s:property value="#practices.term"/></td>
          <td><s:property value="#practices.subject.name"/></td>
        </tr>
        </s:iterator>
    </table>
	  <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">增加</button>
        </div>
      </div>
          
     </div>
  </div>
 	 

	
	
</form>
</body></html>