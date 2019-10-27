<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
   
    <html>  
    <head>  
    <title><tiles:insertAttribute name="title" ignore="true" /> </title>  
    </head>  
    <body>  
        <table bgcolor="white" border="1" cellspacing="2" align="center" width="100%" height="100%">  
            <tr align="justify">  
                <td height="30" colspan="3">
                   <tiles:insertAttribute name="header" />  
                </td>  
            </tr>  
            <tr>  
                <td height="250" width="70">
                  <p style="text-align: center"> <tiles:insertAttribute name="menu" /></p>
                </td>  
                <td  hight="50" width="500">
                    <tiles:insertAttribute name="body" />
                </td>  
                <td height="250" width="70">
                  <p style="text-align: justify"> <tiles:insertAttribute name="menu2" /></p>
                </td>  
            </tr>  
            <tr>  
                <td align="center"  height="30" colspan="3"><!-- colspan="2" -->
                   <tiles:insertAttribute name="footer" />  
                </td>  
            </tr>  
        </table>
        <p align="center">		
        <a href="http://www.facebook.com" class="fa fa-facebook"></a>
		<a href="http://www.twitter.com" class="fa fa-twitter"></a>
		<a href="http://www.google.com" class="fa fa-google"></a>
		</p>  
    </body>  
    </html>  