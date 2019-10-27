<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"   %>
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@taglib  uri="http://www.springframework.org/tags"  prefix="spring" %>

  <fmt:setLocale value="${request.locale}"/>
   <fmt:formatDate var="fDate" value= "${sysDate }"  />
    ${fDate} <br>
    
    prize amount::<fmt:formatNumber type="currency" var="fprize"    value="${prizeMoney}"/>
    ${fprize}

    <h1 style="color:red;text-align:center"><spring:message code="reg.title"/> </h1>
    
    <form:form  modelAttribute="empCmd">
        <spring:message code="reg.empName"/> <form:input path="empName"/> <br>
        <spring:message code="reg.empAdds"/> <form:input path="empAddrs"/> <br>
        <spring:message code="reg.empDesg"/> <form:input path="empDesg"/> <br>
        <input type="submit"  value="<spring:message code="reg.btn.cap" />"/>
    </form:form>
    <br><br>
    
    <a href="?lang=en_US">English</a>  &nbsp;&nbsp;&nbsp;
    <a href="?lang=fr_FR">French</a>  &nbsp;&nbsp;&nbsp;
    <a href="?lang=de_DE">German</a>&nbsp;&nbsp;&nbsp;
    <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;&nbsp;
    
    
    