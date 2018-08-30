
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<br/><br/><br/>
<div class="row" style="padding-left: 50px;
                        padding-right: 50px;">
            <div class="col-lg-12">
                <h1 class="page-header">Lista restorana
                    <small></small>
                </h1>
                
            </div>
        </div>
<c:forEach items="${restorani}" var="restoran">
    <div style="padding-left: 50px;
                padding-right: 50px;" class="row">
            <div class="col-md-7">
                <img src="<c:url value="/images/${restoran.idRestorana}.jpg"/>">
            </div>
            <div class="col-md-5">
                <h2>${restoran.nazivRestorana}</h2>
                <h4>Radno vreme: </h4><h4>${restoran.radnoVreme}</h4>
                <p>Vrste kuhunja koje možete naći u ovom restoranu su: ${restoran.vrsteKuhunja}</p>
                <p>Lokacija restorana: ${restoran.lokacijaRestorana}</p>
                <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                    <button class="btn btn-primary" type="submit"/>
                        <a style="color: white;" href="<spring:url value="/deleteRestoran/${restoran.idRestorana}" />">
                            Obisi restoran
                        </a>
                    </button>
                </c:if>
            </div>
        </div>
</c:forEach>

<%@include file="footer.jsp"%>