<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>    

    
    <h1 style="color:red;text-align:center">Form3 page</h1>
    
    <form:form  method="POST" commandName="regCmd">
             Expected Salary :: <form:input path="expectedSalary"/> <br>
             PrefferedLocation :: <form:input path="prefferedLocation"/> <br>
             <input type="submit"  name="_target1"  value="previous">
             <input type="submit"  name="_finish"  value="finish">
             <input type="submit"  name="_cancel"  value="cancel">   
    
    </form:form>
    
    