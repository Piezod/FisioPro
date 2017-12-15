<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Cancelar Cita</title>
<link href="css/tabla.css"   rel="stylesheet" type="text/css">
<link href="css/modal1.css"   rel="stylesheet" type="text/css">
</head>
<style>

#segundopaso,#altacita
{
	display:none;
}
body
{
    background: url('IMAGENES/Fondos/fondocita.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
    opacity: 0.8;
    filter: alpha(opacity=80); /* For IE8 and earlier */
}

</style>

<body style="background-color: transparent;">
<%@ include file="/WEB-INF/Cabecera.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
		    <div class="panel panel-primary" style="margin-top: 5%">
      			<div class="panel-heading"><h1 align="center">Cancelar una Cita</h1></div>
      			<div class="panel-body">
   					<table class="table table-hover thead-light" border="0px">   
						<tr align="center"><td><input type="date" name="fecha" min="${fechahoy}" id="fecha"/>
						</tr>
					</table>	
					<div id="citasfecha"></div>		
				</div>
			 </div>
		</div>
	</div>
</div>

<!-- Ver las citas del dia marcado -->
<script type="text/javascript">
$( document ).ready(function() {
    console.log( "ready!" );
	$("#fecha").change( function()
			{
		console.log("Cambio fecha en datepicker");
		VerCitas($("#fecha").val());
			}); 
});

function VerCitas(fecha){  
	
	console.log("buscando las citas para el dia indicado");
	
	var parametros = {
			oper : "VerCitasFecha",
			fecha : fecha
	}
	console.log(parametros.oper);
	console.log(parametros.fecha);
	
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
            	console.log(response);
            	console.log("fff"+response[0].nombre);
            	// create table
            	var table = $('<table id="citasfecha" border="1" class="blueTable" ></table>');      
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
           	
            	$("#citasfecha").replaceWith(table);
            		}
            	else
            		{
            		var table = $('<table id="citasfecha" border="1" class="table table-striped" ></table>');      
                	var row = $("<thead><tr></tr></thead>");
                	  row.append($("<th> No hay citas </th>"));          	  
                	  table.append(row);
    				console.log(table);
                	$("#citasfecha").replaceWith(table);
            		}
            }
    });
};

function confirmarcancelarcita(oid_cita,oid_cliente)
{
	console.log(oid_cita,oid_cliente);
	

	//Ingresamos un mensaje a mostrar
	var mensaje = confirm("¿Quieres cancelar la cita?");
	//Detectamos si el usuario acepto el mensaje
	if (mensaje) {
	cancelarcita(oid_cita,oid_cliente);
	}
	//Detectamos si el usuario denegó el mensaje
	else {
	alert("No se cancela la cita");
	}
}

function cancelarcita(oid_cita,oid_cliente){  
	console.log("Cancelando cita porque se pasa a consulta");
	
	var parametros = {
			oper : "cancelarcita",
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
            		 $("#modalinfo").modal('show');
            		}
            	else
            		{
						console.log("no se pudo hacer la cancelacion cita");
            		}
            }
    });
};
</script>


<!-- Modal -->
<div id="modalinfo" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Información</h4>
      </div>
      <div class="modal-body">
        <div class="label label-info">
        	Se realizo la <strong> Correctamente !!</strong>
        </div>
      </div>
      <div class="modal-footer">
        <button id="fincitaalta" onclick="VerCitas($('#fecha').val());" type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>

  </div>
</div>

<!-- Modal Espera Ajax -->
<div id="modalespera" class="modal fade" role="dialog" style="margin-top: 30px">
  <img align="middle" src="IMAGENES/ajaxtriangulos.gif" alt="imagenloading...."/>
</div>


</body>

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
</html>