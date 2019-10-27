<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    <h1 style="text-align: center; color: green;"><spring:message code="reg.dw.wc"/></h1>
    
  <c:choose>
	 <c:when test = "${!empty flist}">
		<table border="1" align="center">
			<c:forEach var="fname" items="${flist}">
				<tr>
 					<td>${fname}</td>
 					<td><a href="download.htm?filename=${fname}"><spring:message code="reg.dw.dw"/></a></td>
 				</tr>
			</c:forEach>
		</table>
	 </c:when>

	<c:otherwise>
        	<h3 style="text-align: center; color: red;">No Files Found...! May Be Shifted SomeWhere</h3>
         </c:otherwise>
	</c:choose>	
	
	<br><br>
 <h2 style="text-align: center;"><a href="upload.htm"><spring:message code="reg.home"/></a></h2> 
	
	
	  
	
	
	
	
	
	
	
<!--	 <c:if test="${!empty fileList }">
 <table border="1" align="center">
 <c:forEach var="fname" items="${fileList }">
 	<tr>
 		<td>${fname }</td>
 		<td><a href="download.htm?filename=${fname }">Download</a></td>
 	</tr>
 </c:forEach>
 </table>
 </c:if> -->
 
	