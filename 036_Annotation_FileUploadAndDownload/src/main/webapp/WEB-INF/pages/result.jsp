<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1 style="color:green; text-align: center"> ${msg } <br>
																			${file1 } <br>
																			${file2 } <br><spring:message code="reg.suc"/><br>
										</h1>
<br>
<br>
<br>

<h3 align="center"><a href="upload.htm"><spring:message code="reg.home"/></a></h3>