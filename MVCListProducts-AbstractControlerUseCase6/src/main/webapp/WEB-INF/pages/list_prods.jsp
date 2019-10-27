<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:choose>
    <c:when test="${!empty  listProds }">
       <table border="1" bgcolor="cyan">
           <tr style="color:red">
              <th>SrNo</th><th>pid</th><th>pname</th><th>price</th><th>stockQty</th><th>mfgDate</th><th>expiryDate</th>
            </tr>
            <c:forEach var="prod"  items="${listProds}">
               <tr>
                 <td>${prod.srNo}</td>
                 <td>${prod.pid}</td>
                 <td>${prod.pname}</td>
                 <td>${prod.price}</td>
                 <td>${prod.stockQty}</td>
                 <td>${prod.mfgDate}</td>
                 <td>${prod.expiryDate}</td>
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
    <a href="JavaScript:doPrint()">print</a>
    <script language="JavaScript">
        function doPrint(){
        	frames.focus();
        	frames.print();
        }
    </script>
    
    
