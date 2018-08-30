


    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page language="java" pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ include file="header.jsp" %>
    
    <br/><br/>
    <h1 align="center">Unesite informacije o rezervaciji</h1>
    <br/><br/><br/>
    <div class="form" align="center" >

        <form:form modelAttribute="rezervacija" method="POST">
                           
                                <% String success = (String) request.getAttribute("successMsg");%>
                                <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
                          
                            <div class="form-group">
                                <label>
                                    Datum rezervacije
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="datumRezervacije" id="datumRezervacije" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>
                                    Vreme rezervacije
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="vremeRezervacije" id="vremeRezervacije" required="required"/>
                            </div>

                            <div class="form-group">
                                <label>
                                    Ime
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="imeKorisnika" id="imeKorisnika" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                <label>
                                    Prezime
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="prezimeKorisnika" id="prezimeKorisnika" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                
                                <form:input class="form-control" type="hidden" path="usernameKorisnika" id="usernameKorisnika"/>
                                <form:input class="form-control" type="hidden" value="<%= request.getUserPrincipal().getName() %>" path="usernameKorisnika" id="usernameKorisnika"/>
                            </div>
                            <div class="form-group">
                            <form:label for="restoran" path="restoran">Restoran</form:label>
                                <form:select id="restoran"  class="form-control" path="restoran">

                                <form:options items="${restorani}" itemValue="idRestorana" itemLabel="nazivRestorana" />
                            </form:select>
                            </div>
                            <button class="btn btn-primary" style="width: 500px;" type="submit"/>Dodaj</button>
                        </form:form>

                </div>
    <%@ include file="footer.jsp" %>
