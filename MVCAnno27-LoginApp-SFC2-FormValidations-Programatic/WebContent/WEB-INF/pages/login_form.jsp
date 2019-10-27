<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

 <h1 style="color:red;text-align:center"> Login Form  </h1>

<form:form modelAttribute="userCmd"  >
    Login username ::: <form:input path="user"/> <form:errors  cssStyle="color:red" path="user"/> <br>
    Login Password :::<form:input path="pwd"/><form:errors  cssStyle="color:red" path="pwd"/> <br>
    age  :: <form:input path="age"/><form:errors  cssStyle="color:red" path="age"/>  <br> 
    <input type="submit"  value="Login">    
</form:form>    
 <br><br>
   <c:if test="${!empty resultMsg }">
       Status  ::  ${resultMsg }
  </c:if>