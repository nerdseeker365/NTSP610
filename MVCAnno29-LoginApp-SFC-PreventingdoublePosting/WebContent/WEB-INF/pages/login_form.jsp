<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

 <h1 style="color:red;text-align:center"> Login Form  </h1>

<form:form modelAttribute="userCmd"  >
    <form:errors path="*"/>
    Login username ::: <form:input path="user"/> <br>
    Login Password :::<form:input path="pwd"/> <br>
    <input type="hidden"  name="cToken"  value="${sToken}"/>
    DOB ::  <form:input path="dob"/>(dd-MM-yyyy) <br>
    <input type="submit"  value="Login">    
</form:form>    
 