<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>


<!-- <h1 style="color:green;text-align: center">Welcome To Sesha Jobs Portal</h1> -->

<br><br>
<form:form method="POST" modelAttribute="udCmd" enctype="multipart/form-data">
<table border="0.5" align="center">
  <tr>
    <td><spring:message code="reg.name"/> :- </td>
    <td><form:input path="name"/></td>
  </tr>
  <tr>
    <td><spring:message code="reg.addrs"/> :-</td>
    <td><form:input path="address"/></td>
  </tr>
   <tr>
    <td><spring:message code="reg.photo"/> :-</td>
    <td><input type="file" name="photo"></td>
  </tr>
	<tr>
    <td><spring:message code="reg.resume"/> :-</td>
    <td><input type="file" name="resume"></td>
  </tr>
</table>
<br><br>
 <p align="center"><input type="submit" value="<spring:message code="reg.submit"/>"/></p>
 
 <h3 style="text-align: center;"><a href="getdownload.htm"><spring:message code="reg.download"/></a></h3>
</form:form>
<br>
<p style="text-align: center">
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;
</p> 
<br><br>
<h1 style="color:orange; text-align: center"><spring:message code="reg.thanks"/></h1>


