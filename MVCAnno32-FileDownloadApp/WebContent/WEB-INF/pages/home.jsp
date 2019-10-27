<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>    

    <h1 style="color:red;text-align:center">Select Files to Download</h1>
    <c:choose>
       <c:when test="${!empty filesList}">
          <table border="1"  align="center">
               <c:forEach  var="f"  items="${filesList}">
                  <tr>
                    <td>${f}</td>
                    <td><a href="download.htm?fname=${f}">donwload</a>  </td>
                  </tr>
               </c:forEach>
          </table>
       </c:when>
       <c:otherwise>
            <h1 style="color:red;text-align:center">No Files found </h1>
       </c:otherwise>
    </c:choose>
    
    
    
    