

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@include file="header.jsp"%>
 <h1>
 <title>Login Page</title>
 </h1>
 <br/><br/><br/><br/>
 <body onload='document.loginForm.username.focus();'>
     <div class="form" >
     <div class="tab-content">
        <h1 style="text-shadow: 1.5px 1.5px #cc0000" align="center">Uloguj se</h1><br/><br/>
        <c:if test="${not empty error}">
            <div align="center" class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div align="center" class="msg">${msg}</div>
        </c:if>
 
        <form  name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
            <div style="width: 800px;
                        border: 5px solid #cc0000;
                        padding: 25px;
                        margin-left: 20%;
                        box-shadow: 5px 5px darkslategrey;" 
                class="form" align="center">
                
            <div class="form-group" align="center">
                <label for="username">
                    Username<span class="req">*</span>
                </label>
                <input style="text-align: center;" class="form-control" type="text" required autocomplete="off" name="username"/>
            </div>
            <div class="form-group" align="center">
                <label for="password">
                    Password<span class="req">*</span>
                </label>
                <input style="text-align: center;" type="password" class="form-control" required autocomplete="off" name="password"/>
            </div>
        
            <button style="width:200px; font-size: 20px;" align="center" class="btn btn-primary" type="submit">Prijavi se</button>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </div>
        </form>

    </div>
</div>    
            <br/><br/><br/><br/>
 <%@include file="footer.jsp"%>
