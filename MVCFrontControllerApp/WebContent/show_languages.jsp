<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <h1 style="color:red;text-align:center">All Languages are </h1>
 
 <%
    String lang[]=(String[])request.getAttribute("langList");
    for(String l:lang){
    	if(l!=null)
    	   out.println("<br>"+l);
    }
 %>
 <br><br>
 <a href="index.html">home</a>
 