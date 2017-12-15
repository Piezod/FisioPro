<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<%@ include file="/WEB-INF/Cabecera.jsp" %>
<head>
<title>FisioPro - Inicio</title>
<style type="text/css">
body {
    background-image: url("IMAGENES/Fondos/10.jpg");
    background-repeat: no-repeat;
}

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
<style>

<!-- Esto me centra el modal -->


@media screen and (min-width: 768px) { 
  #modalespera:before {
    vertical-align: middle;
    content: " ";
    height: 100%;
  }
}

#modalespera {
  text-align: center;
  vertical-align: middle;
  margin-top: 15%;
  margin-left: 15%;
}
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
<link href="css/tabla.css"   rel="stylesheet" type="text/css">
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

  <h3>Consultas para el dia de hoy : <fmt:formatDate pattern = "dd-MM-yyyy" value = "${now}" /> 
  
  </h3><br>
  <fmt:formatDate pattern = "dd-MM-yyyy" value = "${now}" />
	  <div class="row">
	    </div>
	    <div class="col-sm-10 col-xs-10">   
	    	
	    	<div id="citashoy">
	    		
	    	</div>
	    </div>
	    <div class="col-sm-1 col-xs-1">
	    <div id="refrescarcitashoy"><span class="glyphicon glyphicon-refresh"></span></div> 
	    </div>
	  </div>
    </div>
    <!-- Modal Espera Ajax -->
<div id="modalespera" class="modal fade" role="dialog" style="margin-top: 30px">
  <img align="middle" src="IMAGENES/ajaxtriangulos.gif" alt="imagenloading...."/>
</div>
</body>
</div>

<script type="text/javascript">
<!-- Evento Recargar Las Citas para Hoy -->
$( document ).ready(function() {
    console.log( "ready!" );
    CitasHoy();
    
    $("#refrescarcitashoy").click(function() {
		console.log("Click recargarhoy");
		CitasHoy();
	});
});

function CitasHoy(){  
	console.log("Buscando  citas para hoy");
	
	var parametros = {
			oper : "citashoy"			
	}
	console.log(parametros.oper);
	
    $.ajax({
            data:  parametros,
            url:   'SvCita',
            type:  'POST',
            beforeSend: function () {
            	$("#citashoy").html('<img src="IMAGENES/ajaxtriangulos.gif" alt="imagenloading...."/>');
            	//$('#modalnotificacion').modal('show');
            },
            success:  function (response) {
            	
            	if (response.length>0)
            		{
            	console.log(response);
            	console.log("fff"+response[0].nombre);
            	// create table
            	var table = $('<table id="citashoy" border="1" class="blueTable" ></table>');      
            	// Iterate over the JSON array.
            	            	var row = $("<thead><tr></tr></thead>");
            	  row.append($("<th> Nombre </th>"));
            	  row.append($("<th> Apellido </th>"));
            	  row.append($("<th> Horario</th>"));            	  
            	  table.append(row);
                $.each(response, function(index, item) { 
                	console.log(index.item);
            	  var row1 = $('<tr onClick="confirmarcancelarcita('+item.oid_cita+","+item.oid_cliente+');"></tr>');
            	  row1.append($("<td></td>").html(item.nombre));
            	  row1.append($("<td></td>").html(item.apellido1));
            	  row1.append($("<td></td>").html(item.des_horario));
            	  table.append(row1);
                });             
				console.log(table);
           	//Reemplazo el anterior contenido por el nuevo, ais no se concatena
           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
            	$("#citashoy").replaceWith(table);
            		}
            	else
            		{
            		var table = $('<table id="citashoy" border="1" class="table table-striped" ></table>');      
                	var row = $("<thead><tr></tr></thead>");
                	  row.append($("<th> No hay citas </th>"));          	  
                	  table.append(row);
    				console.log(table);
                	$("#citashoy").replaceWith(table);
            		}
            }
    });
};

function abrirconsulta(oid_cliente) {
	console.log("abro el perfil para el chatin numero "+oid_cliente);
    url = "SvConsultaCliente?oper=perfil&oid="+oid_cliente;
    $(location).attr("href", url);
}

function confirmarcancelarcita(oid_cita,oid_cliente)
{
	console.log(oid_cita,oid_cliente);
	

	//Ingresamos un mensaje a mostrar
	var mensaje = confirm("¿Quieres crear la consulta de esta cita?");
	//Detectamos si el usuario acepto el mensaje
	if (mensaje) {
	cancelarcita(oid_cita,oid_cliente);
	}
	//Detectamos si el usuario denegó el mensaje
	else {
	alert("Cancelamos seguimos todo igual");
	}
}

function cancelarcita(oid_cita,oid_cliente){  
	console.log("Cancelando cita porque se pasa a consulta");
	
	var parametros = {
			oper : "cancelarcita"		,
			oid_cita : oid_cita
	}
	console.log(parametros.oper);
	
    $.ajax({
            data:  parametros,
            url:   'SvCita',
            type:  'POST',
            beforeSend: function () {
				$("#modalespera").modal('show');
            },
            success:  function (response) {
            	$("#modalespera").modal('hide');
            	if (response.length>0)
            		{
            		 abrirconsulta(oid_cliente);
            		}
            	else
            		{
						console.log("no se pudo hacer la cancelacion cita");
            		}
            }
    });
};
</script>
</html>