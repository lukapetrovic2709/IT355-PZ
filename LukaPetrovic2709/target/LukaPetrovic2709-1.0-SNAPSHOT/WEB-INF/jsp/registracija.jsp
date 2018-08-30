

<%@taglib prefix="sec"
 uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<br/> <br/> <br/> 

<h1 align="center">REGISTRACIJA</h1>

<br/> <br/>
    <div class="form" align="center" >

                        <form:form modelAttribute="korisnik" method="POST" >
                           
                                <% String success = (String) request.getAttribute("successMsg");%>
                                <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
                          
                            <div class="form-group">
                                <label>
                                    Username<span class="req">*</span>
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="username" id="username" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>
                                    Lozinka<span class="req">*</span>
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="password" path="password" id="password" required="required"/>
                            </div>

                            <div class="form-group">
                                <label>
                                    Email<span class="req">*</span>
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="email" id="email" required="required"/>
                            </div>

                            <div class="form-group">
                                <label>
                                    Telefon<span class="req">*</span>
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="telefon" id="telefon" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                <form:input type="hidden" path="enabled" id="enabled" value="1"/>
                            </div>
                            
                            <div class="form-group">
                                <form:input type="hidden" path="role" id="role" value="ROLE_USER"/>
                            </div>

                            
                            <button class="btn btn-primary" style="width: 500px;" type="submit"/>Register</button>
                        </form:form>

                </div>
    
<%@include file="footer.jsp"%>
