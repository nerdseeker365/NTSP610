<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
    
    <h1 style="color:red;text-align:center">JobSeeker Registration </h1>
    
 <form:form  method="POST" modelAttribute="uplCmd" enctype="multipart/form-data">
     <table align='center'>
         <tr>
            <td>JobSeeker name :</td>
            <td><form:input path="jsName"/></td>
         </tr>
         <tr>
            <td>JobSeeker Desg :</td>
            <td><form:input path="jsDesg"/></td>
         </tr>
         <tr>
            <td>JobSeeker Resume :</td>
            <td><input type="file" name="resumeFile"/> </td>
         </tr>
         <tr>
            <td>JobSeeker Photo :</td>
            <td><input type="file" name="photoFile"/> </td>
         </tr>
         <tr>
            <td><input type="submit"  value="upload"/></td>
             <td><input type="reset"  value="cancel"/></td>
         </tr>
     </table>
 </form:form>    
