<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
    
    <h1 style="color:red;text-align:center"> Customer Registration using  SFC</h1>
    
    <form:form method="POST" commandName="custCmd">
      Customer name ::: <form:input path="cname"/> <br>
      Customer Address ::: <form:input path="cadd"/> <br>
      Customer Mobile Number ::: <form:input path="mobileNo"/> <br>
      Customer Bill Amount ::<form:input path="billAmt"/> <br>
      <input type="submit"  value="Register"/>
    </form:form>
    