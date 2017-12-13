<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">


<%@ include file="/WEB-INF/Cabecera.jsp" %>
<head>
<title>FisioPro - Inicio</title>
<style type="text/css">
body {
    background-image: url("IMAGENES/Fondos/10.jpg");
    background-repeat: no-repeat;
}
<style>
.modal-header {
    padding:9px 15px;
    border-bottom:1px solid #eee;
    background-color: 	#00BFFF;
    -webkit-border-top-left-radius: 5px;
    -webkit-border-top-right-radius: 5px;
    -moz-border-radius-topleft: 5px;
    -moz-border-radius-topright: 5px;
     border-top-left-radius: 5px;
     border-top-right-radius: 5px;
 }
 .modal-body {
    padding:9px 15px;
    border-bottom:3px solid #eee;
    background-color:  #F5FFFA;
    -webkit-border-top-left-radius: 5px;
    -webkit-border-top-right-radius: 5px;
    -moz-border-radius-topleft: 5px;
    -moz-border-radius-topright: 5px;
     border-top-left-radius: 5px;
     border-top-right-radius: 5px;
 }
 
 

</style>
</style>
<script >
$(document).ready(function(){
    console.log( "ready!" );
    $('#modalexito').modal('show');    
    
});




function verconsultas(){
	
	var oper="listaconsultas";
	
    var parametros = {
            "oper" : oper
    }    
    alert(oper);
    
    $.ajax({
            data:  parametros,
            url:   'PruebaAjax',
            type:  'POST',
            beforeSend: function () {
            	$("#respuesta").html('<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>');
            	$('#modalnotificacion').modal('show');
            },
            success:  function (response) {
            	alert("respuesta"+response);
            }
    });
}


</script>

</head>
<body>
<c:if test="${exito > 0 }">
<%@ include file="/WEB-INF/Modales/modalexito.jsp" %>
</c:if>
<c:if test="${exito == 0 }">
<%@ include file="/WEB-INF/Modales/modalfallo.jsp" %>
</c:if>

<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 250px; margin: 0 auto">
    <!-- Indicators -->
    <ol class="carousel-indicators" style="color: red;">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides imagenes tamaño 1200 x 400 -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="IMAGENES/manodoctorslider.jpg"alt="Image" style="height: 250px; margin: 0 auto"/>
        <div class="carousel-caption">
          <h3 style="color: black">Te ayudamos en todo momento</h3>
        </div>      
      </div>

      <div class="item">
        <img src="IMAGENES/manomasaje.jpg" style="height: 250px; margin: 0 auto"/>
        <div class="carousel-caption">
          <h3>Profesionales</h3>
          <p>Que se preocupan por tu bien estar</p>
        </div>      
      </div>
      
      <div class="item">
        <img src="IMAGENES/electroestimulacion250.png"alt="Image" style="height: 250px; margin: 0 auto"/>
        <div class="carousel-caption">
          <h3>Las mejores tecnicas</h3>
          <p>Electroestimulacion,moxa,ventosas y muchas cosas mas</p>
        </div>      
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Siguiente</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Anterior</span>
    </a>
</div>

<div class="container text-center">    

  <h3>Consultas para el dia de hoy : <fmt:formatDate pattern = "dd-MM-yyyy" value = "${now}" /></h3><br>
  <fmt:formatDate pattern = "dd-MM-yyyy" value = "${now}" />
  <div class="row">
    <div class="col-sm-4">
   	 <div id="c_e073ef80e7f1f458356294ac275c55b3" class="normal">
   	 </div>
   	 
    </div>
    <div class="col-sm-4"> 
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Project 2</p>    
    </div>
    <div class="col-sm-4">

      <div class="well"><span id="vertabla" class="glyphicon glyphicon-refresh"></span>
       <div id="tablaconsultas">
    <table>
        <c:forEach items="${consul}" var="consultas">
            <tr>
                <td>${consul}</td>
            </tr>
        </c:forEach>
    </table>
       </div>
      </div>
      
      <div class="well"><span id="relista" class="glyphicon glyphicon-refresh"></span>
       <div id="listado">
       </div>
      </div>
    </div>
  </div>
</div>
<br>

<footer class="container-fluid text-center">
  <p>FisioPro Aplicación realizada por JuanKar 2017 </p>
  <p id="ajaxstring"> recoger dato de ajax string </p>
  <p id="datoajaxrecogido"></p>
</footer>
</body>
<script type="text/javascript" src="https://www.eltiempo.es/widget/widget_loader/e073ef80e7f1f458356294ac275c55b3"></script>
</html>
