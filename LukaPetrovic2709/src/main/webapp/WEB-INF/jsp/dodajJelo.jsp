

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<br/> <br/> <br/> 

<h1 align="center">DODAVANJE JELA</h1>

<br/> <br/>
    <div class="form" align="center" >

        <form:form modelAttribute="jelo" method="POST">
                           
                                <% String success = (String) request.getAttribute("successMsg");%>
                                <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
                          
                            <div class="form-group">
                                <label>
                                    Naziv jela
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="nazivJela" id="nazivJela" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>
                                    Opis jela
                                </label>
                                <form:textarea class="form-control" style="text-align: center;" type="text" path="opisJela" id="opisJela" required="required"/>
                            </div>

                            <div class="form-group">
                                <label>
                                    Cena
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="cenaJela" id="cenaJela" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                <label>
                                    Sastojci
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="sasatojciJela" id="sasatojciJela" required="required"/>
                            </div>
                            
                            <div class="form-group">
                                <label>
                                    Vreme spremanja (u minutima)
                                </label>
                                <form:input class="form-control" style="text-align: center;" type="text" path="vremeSpremanja" id="vremeSpremanja" required="required"/>
                            </div>

                            
                            <button class="btn btn-primary" style="width: 500px;" type="submit"/>Dodaj</button>
                        </form:form>

                </div>
    
<%@include file="footer.jsp"%>
