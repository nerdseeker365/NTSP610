<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:red;text-align:center">Registration Page </h1>

<form:form  commandName="regCmd">
   <p style="color:red">
       <form:errors path="*"/>
   </p> <br>
     Employee number:: <form:input path="empNo"/> <br>
     Employee name:: <form:input path="empName"/> <br>
     DOB:: <form:input path="dob"/>(dd-MM-yyyy) <br>
     DOJ:: <form:input path="doj"/>(dd-MM-yyyy) <br>
     DOM:: <form:input path="dom"/>(dd-MM-yyyy) <br>
     <input type="submit"  value="register">
</form:form>
 <br><br>
  <c:if test="${!empty regCmd }">
      command obj data is :: ${regCmd}
 </c:if>
 
    
    
