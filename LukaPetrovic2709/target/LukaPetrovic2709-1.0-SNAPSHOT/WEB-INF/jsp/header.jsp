

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
    <head>
        <title>MetRestorani</title>
        
        <meta charset="UTF-8"/>
        <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>

    </head>
    <body>
        
        
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
 
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
        
        <header class="header navbar-fixed-top">
  <div class="container-fluid">
      <!-- Navbar -->
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
       <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> 
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span>
	   </button>
          <a href="<c:url value="/" /> " class="navbar-brand"><font size="30"><b><i>MetRestorani</i></b></font></a> 
      </div>
      
 
      <div id="main-nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav pull-left">
            <li><a href="<c:url value="/pocetna" /> ">Pocetna</a></li>
            <li><a href="<c:url value="/jelovnik" /> " >Jelovnik</a></li>
            <li><a href="<c:url value="/listaRestorana" /> " >Restorani</a></li>
            
            <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
            <li><a href="<c:url value="/rezervisanje" /> " >Kreiraj rezervaciju</a></li>
            </c:if>
            
            <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
            <li><a href="<c:url value="/listaRezervacija" /> ">Lista Rezervacija</a></li>
            <li><a href="<c:url value="/listaKorisnika" />">Lista Korisnika</a></li>
            <li><a href="<c:url value="/dodajJelo" />">Dodaj jelo</a></li>
            <li><a href="<c:url value="/dodajRestoran" />">Dodaj restoran</a></li>
            </c:if>
            
        </ul>
            
        <ul class="nav navbar-nav pull-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li><a href="<c:url value="/login" /> ">Login</a></li>
            <li><a href="<c:url value="/registracija" /> ">Registracija</a></li>
            </c:if>
            
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a href="javascript:formSubmit()"> Logout</a></li>
            </c:if>
        </ul>
      </div>
      
    </nav>
  </div>
</header>
<br>  