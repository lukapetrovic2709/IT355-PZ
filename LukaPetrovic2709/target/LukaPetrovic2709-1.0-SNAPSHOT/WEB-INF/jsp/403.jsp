

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp" %>
<h1 align="center">Nije ti dozvoljeno da vidis ovu stranu</h1>
 
 <c:choose>
 <c:when test="${empty username}">
 <h2 align="center">Uloguj se</h2>
 </c:when>
 <c:otherwise>
 <h2 align="center">Korisnice ${username} <br/>nije ti dozvoljeno da vidis ovu stranu!</h2>
 </c:otherwise>
 </c:choose>
 
 <%@include file="footer.jsp" %>
