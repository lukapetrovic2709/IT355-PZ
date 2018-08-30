

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<br/> <br/> <br/> 

<h1 align="center">DODAVANJE RESTORANA</h1>

<br/> <br/>
    <div class="form" align="center" >

        <form:form modelAttribute="restoran" method="POST">
                           
                                <% String success = (String) request.getAttribute("successMsg");%>
                                <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
                          
                            <div class="form-group">
                                <label>
                                    Naziv restorana
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="nazivRestorana" id="nazivRestorana" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>
                                    Radno vreme restorana
                                </label>
                                <form:textarea class="form-control" style="text-align: center;" type="text" path="radnoVreme" id="radnoVreme" required="required"/>
                            </div>

                            <div class="form-group">
                                <label>
                                    Vrste kuhunja
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="vrsteKuhunja" id="vrsteKuhunja" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                <label>
                                    Lokacija restorana
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="lokacijaRestorana" id="lokacijaRestorana" required="required"/>
                            </div>
                                                        
                            <button class="btn btn-primary" style="width: 500px;" type="submit"/>Dodaj</button>
                        </form:form>

                </div>
    
<%@include file="footer.jsp"%>

