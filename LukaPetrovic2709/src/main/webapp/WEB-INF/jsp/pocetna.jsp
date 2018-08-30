

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/modern-business.css"/>

<%@ include file="header.jsp" %>

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/images/prva.jpg" />" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Dobrodosli u najvecu bazu restorana</h1>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/images/druga.jpg" />" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Raspolazemo sa najkvalitetnijim jelima</h1>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image " src="<c:url value="/images/treca.jpg" />" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Nasi restorani su najluksuzniji u regionu</h1>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Prethodni</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Sledeci</span>
    </a>
</div><!-- /.carousel -->


<div class="container">

    <!-- Three columns of text below the carousel -->
            <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Ciljevi kojima težimo
                </h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> Bootstrap v3.3.7</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-gift"></i> Free &amp; Open Source</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-compass"></i> Easy to Use</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
        </div>

    <div class="row">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Specijaliteti kuće</h2>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num1.jpg"/>" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num2.jpg"/>" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num3.jpg"/>" alt="">
                </a>
            </div>
        </div>
                <br/>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num4.jpg"/>" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num5.jpg"/>" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="<c:url value="/jelovnik" />">
                    <img src="<c:url value="/images/num6.jpg"/>" alt="">
                </a>
            </div>
        </div>
        </div>
</div>
 <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    });
    </script>
 <%@ include file="footer.jsp" %>
