<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Detalle Consulta</title>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<style>
td 
{
    text-align:center;
    vertical-align:middle;
}
</style>
</head>
<body>
<h1 align="center"> Lista de Consultas 
</h1>


<div class="col-md-8 col-md-offset-2">
	  <table class="table table-hover">
		  	<tr>
		  		<th> Fecha </th>
		  		<th> Nombre</th>
		  		<th> Apellido</th>
		  		<th> Que le sucedia </th>
		  		<th> Tratamiento prescrito</th>
		  		<th> Anamnesis/N. Dolor</th>
		  		<th> Exploracion </th>
		  		<th> Tratamiento </th>
		  		
		  	</tr>
				<c:forEach var="item"  items="${detalleconsulta}" varStatus="loop">
								<td><c:out value = "${item.fecha}"/></td>
								<td><c:out value = "${item.nombrecliente}"/></td>
								<td><c:out value = "${item.apellido1}"/></td>
								<td><c:out value = "${item.quelepasa}"/></td>
								<td><c:out value = "${item.tratamiento}"/></td>						
								<td> <a href="#" class="btn btn-primary btn-md" onClick="abriranamnesis('${item.oid_anamnesis}');">
    									<span class="glyphicon glyphicon-folder-open"></span> 
 									 </a>
 								</td>		
 								<td> <a href="#" class="btn btn-info btn-md" onClick="AbrirExploracion('${item.oid_exploración}');">
    									<span class="glyphicon glyphicon-folder-open"></span> 
 									 </a>
 								</td>	
 								 <td> <a href="#" class="btn btn-success btn-md" onClick="AbrirTratamiento('${item.oid_tratamiento}');">
    									<span class="glyphicon glyphicon-folder-open"></span> 
 									 </a>
 								</td>						
							</tr>
				</c:forEach>
</table>
</body>
<!-- Modal -->
<div id="infoformulario" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <div id="infotabla">        	
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<!-- Evento Frm Anamnesis -->
<script type="text/javascript">
	function abriranamnesis(oid_anamnesis){
		var parametros = {
	            "oper" : "abriranamnesis",
	            "oid_anamnesis" : oid_anamnesis
	    }    
		console.log(parametros.oper);
	    $.ajax({
	            data:  parametros,
	            url:   'SvVerConsultas',
	            type:  'POST',
	            beforeSend: function () {
	            	$("#respuesta").html('<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>');
	            	$('#modalnotificacion').modal('show');
	            },
	            success:  function (response) {
	            	console.log("respuesta"+response.quelepasa +"desde cuando "+response.desdecuando);
	            	
	            	
	            	// create table
	            	var table = $('<table id="infotabla" class="table table-striped"></table>');           
	            	var row = $("<tr></tr>");
	            	  row.append($("<th> Que le pasa</th>"));
	            	  row.append($("<th> desdecuando</th>"));
	            	  row.append($("<th> aqueloatribuye</th>"));
	            	  table.append(row);
	            	  var row1 = $("<tr></tr>");
	            	  row1.append($("<td></td>").html(response.quelepasa));
	            	  row1.append($("<td></td>").html(response.desdecuando));
	            	  row1.append($("<td></td>").html(response.aqueloatribuye));
	            	  table.append(row1);
					console.log(table);
	           	//Reemplazo el anterior contenido por el nuevo, ais no se concatena
	           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
	           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
	            	$("#infotabla").replaceWith(table);
	            	$('#infoformulario').modal('show');
	            	
	            }
	    });
	};

</script>
<!-- Evento Exploración -->
<script type="text/javascript">

function AbrirExploracion(oid_exploracion){
	var parametros = {
            "oper" : "abrirexploracion",
            "oid_exploracion" : oid_exploracion
    }    
	console.log(parametros.oper);
	console.log(parametros.oid_exploracion)
    $.ajax({
            data:  parametros,
            url:   'SvVerConsultas',
            type:  'POST',
            beforeSend: function () {
            	$("#respuesta").html('<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>');
            	$('#modalnotificacion').modal('show');
            },
            success:  function (response) {
            	console.log(response);
            	console.log("respuesta"+response.InspeccionVisual+"Palpacion"+response.Palpación+"TestDeMovilidad"+response.TestOrtopedico);            	            	
            	// create table
            	var table = $('<table id="infotabla" class="table table-striped"></table>');           
            	var row = $("<tr></tr>");
            	  row.append($("<th> Inspeccion Visual</th>"));
            	  row.append($("<th> Palpación </th>"));
            	  row.append($("<th> Test de Movilidad</th>"));
            	  row.append($("<th> Test Ortopedico</th>"));
            	  table.append(row);
            	  var row1 = $("<tr></tr>");
            	  row1.append($("<td></td>").html(response.InspeccionVisual));
            	  row1.append($("<td></td>").html(response.Palpación));
            	  row1.append($("<td></td>").html(response.TestDeMovilidad));
            	  row1.append($("<td></td>").html(response.TestOrtopedico));
            	  table.append(row1);
				console.log(table);
           	//Reemplazo el anterior contenido por el nuevo, ais no se concatena
           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
            	$("#infotabla").replaceWith(table);
            	$('#infoformulario').modal('show');
            	
            }
    });
};


</script>
<!-- Evento para abrir Tratamiento -->
<script type="text/javascript">

function AbrirTratamiento(oid_tratamiento){
	var parametros = {
            "oper" : "abrirtratamiento",
            "oid_tratamiento" : oid_tratamiento
    }    
	console.log(parametros.oper);
	console.log(parametros.oid_tratamiento)
    $.ajax({
            data:  parametros,
            url:   'SvVerConsultas',
            type:  'POST',
            beforeSend: function () {
            	$("#respuesta").html('<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>');
            	$('#modalnotificacion').modal('show');
            },
            success:  function (response) {
            	console.log(response);
            	console.log("respuesta"+response.tratamiento);            	            	
            	// create table
            	var table = $('<table id="infotabla" class="table table-striped"></table>');           
            	var row = $("<tr></tr>");
            	  row.append($("<th> Tratamiento</th>"));
            	  table.append(row);
            	  var row1 = $("<tr></tr>");
            	  row1.append($("<td></td>").html(response.tratamiento));
            	  table.append(row1);
				console.log(table);
           	//Reemplazo el anterior contenido por el nuevo, ais no se concatena
           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
            	$("#infotabla").replaceWith(table);
            	$('#infoformulario').modal('show');
            	
            }
    });
};


</script>

</html>