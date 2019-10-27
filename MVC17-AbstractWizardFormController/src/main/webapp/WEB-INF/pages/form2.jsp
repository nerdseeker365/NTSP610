<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>    

    
    <h1 style="color:red;text-align:center">Form2 page</h1>
    
    <form:form  method="POST" commandName="regCmd">
             JobDomain :: <form:input path="domain"/> <br>
             experience :: <form:input path="experience"/> <br>
             <input type="submit"  name="_target0"  value="previous">
             <input type="submit"  name="_target2"  value="next">
             <input type="submit"  name="_cancel"  value="cancel">   
    
    </form:form>
    
    