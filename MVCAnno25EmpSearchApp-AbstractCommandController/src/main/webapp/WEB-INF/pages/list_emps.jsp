<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:choose>
    <c:when test="${!empty  listRDTO }">
       <table border="1" bgcolor="cyan">
           <tr style="color:red">
              <th>empNo</th><th>ename</th><th>job</th><th>salary</th>
            </tr>
            <c:forEach var="emp"  items="${listRDTO}">
               <tr>
                 <td>${emp.empNo}</td>
                 <td>${emp.ename}</td>
                 <td>${emp.job}</td>
                 <td>${emp.sal}</td>
               </tr>
            </c:forEach>
       </table>
    </c:when>
    <c:otherwise>
          <h1 style="color:red;text-align:center">Records  not found </h1>
    </c:otherwise>
</c:choose>    
    <br><br>
    <a href="welcome.htm">home</a> &nbsp;&nbsp;
    
