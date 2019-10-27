<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <h1 style="color:red;text-align:center">All Countries are </h1>
 
 <%
    String countries[]=(String[])request.getAttribute("countriesList");
    for(String c:countries){
    	if(c!=null&& c.length()>0)
    	   out.println("<br>"+c);
    }
 %>
 <br><br>
 <a href="index.html">home</a>
 