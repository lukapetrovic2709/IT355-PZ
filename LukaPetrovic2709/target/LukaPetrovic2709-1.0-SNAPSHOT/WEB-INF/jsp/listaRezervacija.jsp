

<%@ include file="header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
 
    <script>
         $(document).ready(function(){
    $('#table').DataTable();
}); 
    </script>
    <br/><br/><br/><br/>
    <div class="row" style="padding-left: 50px;
                        padding-right: 50px;">
            <div class="col-lg-12">
                <h1 class="page-header">Lista rezervacija
                    <small></small>
                </h1>
                
            </div>
        </div>
    <br/><br/>
    <div align="center" class="form" width="75%" height="75%">
        <c:if test="${!empty rezervacija}">
        
        <table id="table" class="table table-striped">
        <thead style="background-color: #a70532;
                      color: white;" >
        <tr>
            <th>ID</th> 
            <th>Datum</th> 
            <th>vreme</th>
            <th>ime</th>
            <th>prezime</th>
            <th>username</th>
            <th>Restoran</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rez}" var="r">
        
        <tr>
            <td>${r.idRezervacije}</td>
            <td>${r.datumRezervacije}</td>
            <td>${r.vremeRezervacije}</td> 
            <td>${r.imeKorisnika}</td>
            <td>${r.prezimeKorisnika}</td> 
            <td>${r.usernameKorisnika}</td> 
            <td>${r.restoran}</td> 
            <td><a href="<c:url value='/deleteRezervaciju/${r.idRezervacije}'/>">Obriši rezervaciju</a></td>
        </tr>
            
        </c:forEach> 
        </tbody>
       </table>
        
    </c:if> 
    </div>   
    <%@ include file="footer.jsp" %>
