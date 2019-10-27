<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>    

    <h1 style="color:red;text-align:center">Result page</h1>
    
    <br><br>
   <c:if test="${!empty resultMsg }">
       Status  ::  ${resultMsg }
  </c:if>
   <br>
    <c:if test="${!empty cmdData }">
       Command Data  ::  ${cmdData }
  </c:if>
   <br><br>
  <a href="login.htm">home</a>
    