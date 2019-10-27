<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
    
    <h1 style="color:red;text-align:center"> Employee Search </h1>
    
    <form action="search.htm" method="POST">
        Employee number :: <input type="text" name="empNo"> <br>
        Employee name :: <input type="text" name="ename"> <br>
        Employee salary :: <input type="text" name="sal"> <br>
        Employee Desg :: <input type="text" name="job"> <br>
        <input type="submit"  value="search">
    </form>
    
    