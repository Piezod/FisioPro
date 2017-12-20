<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Detalle Consulta</title>
<%@ include file="/WEB-INF/Cabecera.jsp" %>
<link href="css/tabladetalle.css"   rel="stylesheet" type="text/css">
<style>
body
{
    background: url('IMAGENES/Fondos/mantipyng.jpg') fixed;
    background-size: cover;

}
td 
{
    text-align:center;
    vertical-align:middle;
    font-size: 30px;
}

th
{
    text-align:center;
    vertical-align:middle;
      font-size: 36px;
}
table
{

    padding: 0;
    margin: 0;
    opacity: 0.8;
    filter: alpha(opacity=50); /* For IE8 and earlier */
}

.modal-dialog {

  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}

.glyphicon :hover
{
cursor:pointer;
background-color:yellow;
}

.modal-body {
-webkit-transform: translateZ(0)
  height: auto;
  min-height: 100%;
  border-radius: 0;
}

h1{
    color: white;
    font-family: verdana;
    background-color:black;
       opacity: 0.8;

}
pre{

padding: 0px;
font-family: verdana;
 background-color:rgba(0, 0, 0, 0);
  font-weight: bold;
  font-size:90%;
 border: 0;
     
}

</style>
</head>
<body>
<div class="col-md-4 col-md-offset-4"><h1 align="center"> Lista de Consultas</div> 
</h1>

<div class="row"></div>
<div class="col-md-12 col-xs-12 ">
	  <table class="tabdetalleconsulta">
		  	<tr>
		  		<th> Fecha </th>
		  		<th> Nombre</th>
		  		<th> Apellido</th>
		  		<th> Que le sucedia </th>
		  		<th> Anamnesis</th>
		  		<th> Exploracion </th>
		  		<th> Tratamiento </th>		  		
		  	</tr>
				<c:forEach var="item"  items="${detalleconsulta}" varStatus="loop">
								<td><c:out value = "${item.fecha}"/></td>
								<td><c:out value = "${item.nombrecliente}"/></td>
								<td><c:out value = "${item.apellido1}"/></td>
								<td><pre><c:out value = "${item.quelepasa}"/></pre></td>				
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
</div>
</body>
<!-- Modal -->
<div id="infoformulario" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Información</h4>
      </div>
      <div class="modal-body">
        <div id="infotabla">        	
        </div>
         
      </div>
    </div>
      <div class="modal-footer" style="background-color:#C0C0C0 ">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
      </div>
  </div>
</div>
<style>
#infoformulario .modal-header {
    padding:9px 15px;
    border-bottom:1px solid #eee;
    background-color: 	#1C6EA4;
    -webkit-border-top-left-radius: 5px;
    -webkit-border-top-right-radius: 5px;
    -moz-border-radius-topleft: 5px;
    -moz-border-radius-topright: 5px;
     border-top-left-radius: 5px;
     border-top-right-radius: 5px;
     font-size: 15px;
 	 font-weight: bold;
     color: #FFFFFF;
  	 text-align: center;
 }
 
#infoformulario td{
 	text-align:left;
 }
 
#infoformulario .modal-body {
    padding:9px 15px;
    border-bottom:3px solid #eee;
    background-color:  #EEEEEE;
    -webkit-border-top-left-radius: 5px;
    -webkit-border-top-right-radius: 5px;
    -moz-border-radius-topleft: 5px;
    -moz-border-radius-topright: 5px;
     border-top-left-radius: 5px;
     border-top-right-radius: 5px;
 }
 </style>
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
	            	var table = $('<table id="infotabla" class="tabdetalleconsulta" border="1"></table>');           
	            	var row = $("<tr></tr>");
	            	  row.append($("<th> Que le pasa</th>"));
	            	  row.append($("<th> Desde Cuando</th>"));
	            	  row.append($("<th> A que lo atribuye</th>"));
	            	  row.append($("<th> Dolor </th>"))
	            	  table.append(row);
	            	  var row1 = $("<tr></tr>");
	            	  row1.append($("<td></td>").html(response.quelepasa));
	            	  row1.append($("<td></td>").html(response.desdecuando));
	            	  row1.append($("<td></td>").html(response.aqueloatribuye));
	            	  row1.append($('<td><p  onclick="verdolor('+response.oid_anamnesis+')";<span class="glyphicon glyphicon-eye-open" style="cursor:pointer;" ></span></p></td>'));
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
	
	function verdolor(oid_anamnesis) {
		
		console.log("Cerrar el modal e ir a ver el dolor");
		//Magia, esto me permite tener un modal despues de otro, es decir abrilr un modal desde otro, pero hay que
		//poner el e.preventdefault
		$('#infoformulario').on('hide',function(e){
			   if(yourConditionNotToCloseMet){
			      e.preventDefault();
			   }
			});
			var parametros = {
		            "oper" : "abrirdolor",
		            "oid_anamnesis" : oid_anamnesis
		    }    
			console.log("Parametros de abrir dolor"+parametros.oper);
		    $.ajax({
		            data:  parametros,
		            url:   'SvVerConsultas',
		            type:  'POST',
		            beforeSend: function () {
		            	$("#respuesta").html('<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>');
		            	$('#modalnotificacion').modal('show');
		            },
		            success:  function (response) {
		            	
		            	console.log("RESPUESTA:" + response);
		            	console.log(response.Localizacion);
		            	console.log(response.Cronologia);
		            	console.log(response.Irradiacion);
		            	console.log(response.Forma);
		            	console.log(response.hora);
		            	console.log(response.Intensidad);
		            	console.log(response.FormaComienzo);
		            	console.log(response.ImpotenciaFuncional);
		            	console.log(response.RelacionTos);
		            	console.log(response.CambiaLugar);
		            	console.log(response.FactoresDesencadenantes);
		            	console.log(response.FactoresAliviadores);
		            	console.log("fin respuesta");
		            	
		            	// create table
		            	var table = $('<table id="infotabla" class="tabdetalleconsulta" border="1"></table>');           

		            	var row = $("<tr></tr>");
		            	  row.append($("<th> Localizacion</th>"));
		            	  row.append($("<th> Cronologia</th>"));
		            	  row.append($("<th> Irradiacion</th>"));
		            	  
		            	  table.append(row);

		            	  
		            	var row1 = $("<tr></tr>");
		            	  row1.append($("<td></td>").html(response.Localizacion));
		            	  row1.append($("<td></td>").html(response.Cronologia));
		            	  row1.append($("<td></td>").html(response.Irradiacion));		  
		            	  
		            	  table.append(row1);		            	  
		            	  
		            	  var ro = $("<tr></tr>");		            	  
		            	  ro.append($("<th> Forma</th>"));
		            	  ro.append($("<th> hora</th>"));		            	  
		            	  ro.append($("<th> Intensidad</th>"));
		            	  
		            	  table.append(ro);
		            	  var ow1 = $("<tr></tr>");
		            	  ow1.append($("<td></td>").html(response.Forma));
		            	  ow1.append($("<td></td>").html(response.hora));
		            	  ow1.append($("<td></td>").html(response.Intensidad));	
		            	  table.append(ow1);
		            	  
		            	var row2 = $("<tr></tr>");
			            	  
		            		row2.append($("<th> FormaComienzo</th>"));
		            		row2.append($("<th> ImpotenciaFuncional</th>"));
		            		row2.append($("<th> R. Tos</th>"));
			            	  
			            	table.append(row2);
			            	
			            	  
					        var row3 = $("<tr></tr>");
					        row3.append($("<td></td>").html(response.FormaComienzo));
					        row3.append($("<td></td>").html(response.ImpotenciaFuncional));
					        row3.append($("<td></td>").html(response.RelacionTos));		  
					        
					          table.append(row3);
			            	
			            var ow2 = $("<tr></tr>");
			            	  
		            		ow2.append($("<th> Cambia de lugar</th>"));
		            		ow2.append($("<th> Factor Desencadenante</th>"));
		            		ow2.append($("<th> Factor Aliviador</th>"));
			            	  
			            	table.append(ow2);
				           	  
				  	        var ow3 = $("<tr></tr>");
  
					        ow3.append($("<td></td>").html(response.CambiaLugar));
					        ow3.append($("<td></td>").html(response.FactoresDesencadenantes));
					        ow3.append($("<td></td>").html(response.FactoresAliviadores));	
					        
					           	  table.append(ow3);
				            	  
						console.log(table);
		           	//Reemplazo el anterior contenido por el nuevo, ais no se concatena
		           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
		           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
		            	$("#infotabla").replaceWith(table);
		            	$('#infoformulario').modal('show');		            	
		            }
		    });
		
	}

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
            	var table = $('<table id="infotabla" class="tabdetalleconsulta"></table>');           
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
            	var table = $('<table id="infotabla" class="tabdetalleconsulta"></table>');           
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