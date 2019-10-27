<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:choose>
      <c:when test="${!empty deptLocs}">
         <table border="1"  bgcolor="cyan">
             <tr><th>DeptNo</th><th>DeptName</th><th>DeptLoc</th></tr>
             <c:forEach var="map" items="${deptLocs}">
                <tr>
                   <td>${map.deptno} </td>
                   <td>${map.dname} </td>
                   <td>${map.loc} </td>
                </tr>
             </c:forEach>
         </table>
      </c:when>
      <c:otherwise>
           <b><i>Depts Not found </i></b>
      </c:otherwise>
  </c:choose>
  
  
 
 
