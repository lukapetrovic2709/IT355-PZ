

<%@ include file="header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
    
    <script>
        $(document).ready(function(){
            $('#table').DataTable();
        }); 
    </script>
    
    <br/><br/><br/><br/>
    <div class="row" style="padding-left: 50px;
                        padding-right: 50px;">
            <div class="col-lg-12">
                <h1 class="page-header">Lista registrovanih korisnika
                    <small></small>
                </h1>
                
            </div>
        </div>
    <br/><br/>
    <div align="center" class="form" width="75%" height="75%">
        <c:if test="${!empty users}">
        
        <table id="table" class="table table-striped">
        <thead style="background-color: #a70532;
                      color: white;" >
        <tr>
            <th>ID korisnika</th> 
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Telefon</th>
            <th>Ovlašćenje</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${korisnici}" var="korisnik">
        
        <tr>
            <td>${korisnik.idKorisnika}</td>
            <td>${korisnik.username}</td>
            <td>${korisnik.password}</td>
            <td>${korisnik.email}</td> 
            <td>${korisnik.telefon}</td>
            <td>${korisnik.role}</td>
            <td><a href="<c:url value='/deleteKorisnika/${korisnik.idKorisnika}'/>">Obriši nalog</a></td>
        </tr>
            
        </c:forEach> 
        </tbody>
       
        </table>
        
    </c:if> 
    </div>   
    
    <%@ include file="footer.jsp" %>
