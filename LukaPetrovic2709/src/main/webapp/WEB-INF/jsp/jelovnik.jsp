
<%@include file="header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<br/><br/><br/>

<div class="row" style="padding-left: 50px;
                        padding-right: 50px;">
            <div class="col-lg-12">
                <h1 class="page-header">Jelovnik
                    <small></small>
                </h1>
                
            </div>
        </div>
            <ul class="rig columns-2">
                <c:forEach items="${jela}" var="jelo">
                    <li>
                    <div class="row">
                        <div style="width: 800px;
                                    border: 5px solid #cc0000;
                                    padding: 25px;
                                    margin-left: 20%;
                                    box-shadow: 5px 5px darkslategrey;" 
                            class="form" align="left">
                        <h1 style="text-shadow: 1.5px 1.5px black; text-align: center">${jelo.nazivJela}</h1>
                        <h4 style="color: red">Sastojci:</h4> <p style="font-size: large;">${jelo.sasatojciJela}</p>
                        <h4 style="color: blue">Opis:</h4> <p style="font-size: large;">${jelo.opisJela}</p>
                        <h4 style="color: black">Vreme spremanja:</h4> <p style="font-size: large;">${jelo.vremeSpremanja} minuta</p>
                        <h4 style="color: #00cc00">Cena:</h4> <p style="font-size: large;">${jelo.cenaJela} dinara</p>
                        <div align="right">
                            <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                <button class="btn btn-primary" type="submit"/><a style="color: white;" href="<spring:url value="/deleteJelo/${jelo.idJela}" />">Izbaci iz jelovnika</a></button>
                            </c:if>
                        </div>
                    </div>
                    </div>
                    </li>
                </c:forEach>
            </ul>
    
 <%@include file="footer.jsp"%>