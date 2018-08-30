

 <%@ include file="header.jsp" %>
    <%@ page language="java" pageEncoding="UTF-8"%>
    <%@taglib prefix="sec"
              uri="http://www.springframework.org/security/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
 <c:url value="/j_spring_security_logout" var="logoutUrl" />
 
    <form action="${logoutUrl}" 
       method="post" 
       id="logoutForm">
        
     <br/><br/>
    <h1 align="center">Podaci o rezervaciji</h1>
    <br/><br/><br/><br/>
       <table width="200px" align="center">
        
        <tr>
            <td height="50px" >Datum</td>
            <td height="50px">${datum}</td> 
        </tr>
        <tr>
            <td height="50px">Ime</td>
            <td height="50px">${ime}</td> 
        </tr>
        <tr>
            <td height="50px">Prezime</td>
            <td height="50px">${prezime}</td> 
        </tr>
        <tr>
            <td height="50px">Restoran</td>
            <td height="50px">${restoran}</td> 
        </tr>
        <tr>
            <td height="50px">Vreme</td>
            <td height="50px">${vreme}</td> 
        </tr>
    </table>  
        
        <input type="hidden" name="${_csrf.parameterName}"
        value="${_csrf.token}" />
        
        <form/>
    </sec:authorize>
    <%@ include file="footer.jsp" %>
