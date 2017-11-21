<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">

<%@ include file="/WEB-INF/Cabecera.jsp" %>
<head>
<script >
$(document).ready(function(){
    console.log( "ready!" );
    $('#modalexito').modal('show');    
});
</script>

</head>
<body>
<c:if test="${exito > 0 }">
<%@ include file="/WEB-INF/Modales/modalexito.jsp" %>
</c:if>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides imagenes tamaño 1200 x 400 -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="IMAGENES/manodoctorslider.jpg"alt="Image"/>
        <div class="carousel-caption">
          <h3>Sell $</h3>
          <p>Money Money.</p>
        </div>      
      </div>

      <div class="item">
        <img src="IMAGENES/manodoctorslider.jpg"/>
        <div class="carousel-caption">
          <h3>Profesionales</h3>
          <p>Que se preocupan por tu bien estar</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<div class="container text-center">    

  <h3>What We Do</h3><br>
  <div class="row">
    <div class="col-sm-4">
    <!-- Imagenes 150x80 -->
      <img src="" class="img-responsive" style="width:100%" alt="Image">
      <p>Current Project</p>
    </div>
    <div class="col-sm-4"> 
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Project 2</p>    
    </div>
    <div class="col-sm-4">
      <div class="well">
       <p>Some text..</p>
      </div>
      <div class="well">
       <p>Some text..</p>
      </div>
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center">
  <p>FisioPro Aplicación realizada por JuanKar 2017 </p>
</footer>
</body>
</html>
