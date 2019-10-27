<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>

<form:form commandName="regCmd"> 
 <p style="color:red">
     <form:errors path="*"/>
 </p>
   <br>
     name:: <form:input path="name"/> <br>
     address:: <form:input path="addrs"/> <br>
     Gender :: <form:radiobuttons path="gender" items="${gendersList }"  /> <br>
      Country:: <form:select path="country"  >
                             <form:options  items="${countriesList}"  />
                          </form:select>  <br>
    Courses:: <form:select path="courses"  multiple="true" >
                             <form:options  items="${coursesList}"/>
                          </form:select>  <br>
    Hobies:: <form:checkboxes items="${hobiesList }" path="hobies"/>     <br>
    
    <input type="submit"  value="register"/>                      
                                
                          
     
</form:form>

    
    
      
    
