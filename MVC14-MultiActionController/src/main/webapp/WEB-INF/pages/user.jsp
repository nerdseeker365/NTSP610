<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<h1 style="color:red;text-align:center">Form page with multiple submit Buttons </h1>

<form action="process.htm"  method="POST">
    username ::  <input type="text" name="name"> <br>
    address ::  <input type="text" name="addrs"> <br>
    email ::  <input type="text" name="email"> <br>
    desg ::  <input type="text" name="desg"> <br>
    <input type="submit"  value="insert"  name="s1">
    <input type="submit"  value="update"  name="s1">
    <input type="submit"  value="delete"  name="s2">
    <input type="submit"  value="view"  name="s1"> 
</form> 
 <br><br><br><br>
     <c:if test="${!empty operation}">
             ${operation}  is Performed
     </c:if>
    
