<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,org.jug.bg.bdd.web.health.WebConstants;" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body {font-size:12.5pt;font-family: Verdana, Arial, Helvetica, sans-serif;}
	div#errContainer {padding: 5px; border:1px #faa solid; color: red; font-weight: bold; width: 35%;}
	div#formContainer {margin-top:20px; padding: 5px; border:1px #ccc solid; width: 35%;}
	div#massContainer, div#massContainer, div#calculateBttnContainer {margin-top: 5px; margin-bottom: 5px;}
</style>
<title>Body Mass Index Calculator</title>
</head>
<body>
<h4 id="<%= WebConstants.ID_PAGE_HEADING %>"><%= WebConstants.HEADING_MAIN_PAGE %></h4>
<%-- Exception Handling --%><%

String hasProblemStr = (String) request
			.getAttribute(WebConstants.PARAM_HAS_PROBLEM);
boolean hasProblem = StringUtils.isEmpty(hasProblemStr) 
						? false 
						: Boolean.parseBoolean(hasProblemStr);
Throwable problem = (Exception) request
			.getAttribute(WebConstants.PARAM_PROBLEM); 

 if(hasProblem) { 

%><div id="errContainer" >
	<span id="<%= WebConstants.ID_ERR_MSG %>"><%= WebConstants.ERR_MSG %></span><br/><%
	
	if (problem != null) { 
	%><span id="errReason"><%= problem.getMessage() %></span><%
	}
	
%></div><% 
} 
%><%-- BMI Form --%>
<div id="formContainer">
<form action="bmi" method="POST">
	<fieldset>
		<legend>Body Mass Index Calculator</legend>
		<div id="massContainer" style="margin-top: 10px;">
			<label for="massId">Mass:</label>&nbsp;<input id="massId" name="<%= WebConstants.PARAM_MASS %>" type="text" />&nbsp;kg
		</div>
		<div id="heightContainer">
			<label for="heightId">Height:</label>&nbsp;<input id="heightId" name="<%= WebConstants.PARAM_HEIGHT %>" type="text" />&nbsp;m
		</div>
		<div id="calculateBttnContainer">
			<input id="<%= WebConstants.ID_CALCULATE_BTTN %>" type="submit" value="Calculate"/>
		</div>
	</fieldset>
</form>
</div>
</body>
</html>