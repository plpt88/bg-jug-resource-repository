<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.jug.bg.bdd.domain.health.WeightCategory"%>
<%@page import="org.jug.bg.bdd.domain.health.HealthRecord"%>
<%@ page import="org.jug.bg.bdd.domain.health.BodyMassIndex"%>
<%@ page import="org.jug.bg.bdd.web.health.WebConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body {font-size:12.5pt;font-family: Verdana, Arial, Helvetica, sans-serif;}
	div.line {margin:5px;font-size:12.5pt;font-family: Verdana, Arial, Helvetica, sans-serif;}
	div.container {border:1px #ccc solid; width: 35%;}
	span.label {width: 50px; font-weight:bold;}	
	span.lineValue{ margin-left: 50%; text-align:left;font-weight:normal;}
</style>
<title>Body Mass Index Calculator</title>
</head>
<body>
<h4 id="<%=WebConstants.ID_PAGE_HEADING %>"><%=WebConstants.HEADING_RESULTS_PAGE%></h4>

<%
	BodyMassIndex bmi = (BodyMassIndex) (request
			.getAttribute(WebConstants.PARAM_BMI));
	HealthRecord healthRecord = (HealthRecord) request
			.getAttribute(WebConstants.PARAM_HEALTH_RECORD);
	WeightCategory weightCategory = (WeightCategory) request
			.getAttribute(WebConstants.PARAM_WEIGHT_CATEGORY);
%>
<div class="container">
	<div id="massLine" class="line">
		<span class="label">Mass:</span>
		<span id="<%=WebConstants.ID_MASS%>" class="lineValue">
			<%= healthRecord.getWeight() %> kg
		</span>
	</div>
	<div id="heightLine" class="line">
		<span class="label">Height:</span>
		<span id="<%=WebConstants.ID_HEIGHT%>" class="lineValue">
			<%= healthRecord.getHeight() %> m
		</span>
	</div>
	<div id="bmiLine" class="line">
		<span class="label">BMI:</span>
		<span id="<%=WebConstants.ID_BMI_VALUE%>" class="lineValue">
			<%=bmi.value()%>
		</span>
	</div>
	<div id="weightCategoryLine" class="line">
		<span class="label">Weight Category:</span>
		<span id="<%=WebConstants.ID_WEIGHT_CATEGORY%>" class="lineValue">
			<%= weightCategory.getStringValue() %>
		</span>
	</div>
</div>
</body>
</html>