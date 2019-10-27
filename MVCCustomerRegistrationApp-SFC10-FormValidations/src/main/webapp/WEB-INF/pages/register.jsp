<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
   <style>
      span{
  color: red;
  font-size:10px;
  font-family:Verdana
}
</style>
    <h1 style="color:red;text-align:center"> Customer Registration using  SFC</h1>
    <script   type="text/javascript"  src="validation.js">
    
    </script>
    <form:form method="POST" commandName="custCmd"   onsubmit="return validate(this)">
       <%-- <p style="color:red">
           <form:errors path="*"/>
           </p> --%>
      Customer name ::: <form:input path="cname"/><form:errors path="cname"/> <span id="nameErr"></span><br>
      Customer Address ::: <form:input path="cadd"/><form:errors path="cadd"/> <span id="addrsErr"></span><br>
      Customer Mobile Number ::: <form:input path="mobileNo"/><form:errors path="mobileNo"/><span id="mobileErr"></span> <br>
      Customer Bill Amount ::<form:input path="billAmt"/><form:errors path="billAmt"/> <span id="amtErr"></span><br>
        <form:hidden path="vflag" />
      <input type="submit"  value="Register"/>
    </form:form>
    