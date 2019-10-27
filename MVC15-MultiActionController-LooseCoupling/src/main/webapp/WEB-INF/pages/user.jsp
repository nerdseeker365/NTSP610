<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<h1 style="color:red;text-align:center">Form page with multiple submit Buttons </h1>

<form  name="frm"  method="POST">
    username ::  <input type="text" name="name"> <br>
    address ::  <input type="text" name="addrs"> <br>
    email ::  <input type="text" name="email"> <br>
    desg ::  <input type="text" name="desg"> <br>
    <input type="button"  value="add"  onclick="sendRequest(this.value)">
    <input type="button"  value="modify"  onclick="sendRequest(this.value)">
    <input type="button"  value="remove"  onclick="sendRequest(this.value)">
    <input type="button"  value="display"  onclick="sendRequest(this.value)"> 
</form> 
 <br><br><br><br>
     <c:if test="${!empty operation}">
             ${operation}  is Performed
     </c:if>
    <script language="JavaScript">
        function  sendRequest(cap){
        	if(cap=="add")
        		frm.action="add.htm";
        	else if(cap=="modify")
        		frm.action="modify.htm";
        	else if(cap=="remove")
        		frm.action="remove.htm";
        	else
        		frm.action="show.htm";
        	//submit request
        	frm.submit();
        }
    
    </script> 
     
    
