<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Alta Citas</title>
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
      <div class="panel-heading"><h1 align="center">Alta Cita</h1></div>
      	<div class="panel-body">
   			<table class="table table-hover thead-light" border="0px">   
   			
				<tr align="center"><td><input type="date" name="fecha" min="${fechahoy}" value="${fechahoy}" id="fecha"/>
						<button class="btn btn-info" value="verhorarios" id="verhorarios" >Horarios Disponibles</button></td>
						<td><div align="right" id="cbhorario"></div></td>					
				</tr>
				<tr align="center" id="segundopaso">
				
						<td><p>Seleccionar cliente</p>
							<div id="clientes"></div>
						</td>
						<td align="left">
								<input class="form-control" type="text" id="nombrecliente" name="nombrecliente" placeholder="Nombre de cliente.."></input>
								<button class="btn btn-info" id="buscarcliente" >Buscar</button>						
						</td>
				
				</tr>
			</table>
				<div class="col-md-4 col-md-offset-4">
					<button class="btn btn-success" id="altacita" name="altacita">Alta Cita</button>
				</div>
				
			</div>
			 </div>
		</div>
	</div>
</div>
<!-- Funcion para ver los horarios -->
<script type="text/javascript">
	$("#verhorarios").click(function(){
		console.log($("#fecha").val());
		
		verhorarios($("#fecha").val());
	});

</script>

<!-- VER HORARIOS ES Llamada ajax para sacar los horarios disponibles -->
<script type="text/javascript">

function verhorarios(fecha){
	$("#cbhorario").show();
	var parametros = {
            "oper" : "verhorariodisponibles",
            "fecha" : fecha
    }    
	console.log(parametros.oper);
	console.log(parametros.fecha)
    $.ajax({
            data:  parametros,
            url:   'SvCita',
            type:  'POST',
            beforeSend: function () {
            	$("#cbhorario").replaceWith('<div id="cbhorario"><p>Recargando horarios ...<img src="IMAGENES/ajaxtriangulos.gif" width="50px" height="50px" alt="imagenloading...."/></p></div>');
            },
            success:  function (response) {
            	            	
	            	// Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
	                var combo = $('<select class="form-control" name="cbhorario" id="cbhorario">');
	             // Iterate over the JSON array.
	                $.each(response, function(index, item) { 
	                	 // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
	                    $('<option>').attr('value',item.oid_horario).text(item.des_horario).appendTo(combo);    
	                	 console.log("Descripcion horario"+item.des_horario);
	                	 console.log("Id horario "+item.oid_horario);
	                	 console.log(index);
	                });
	            	console.log(response);
	           	//Reemplazo el anterior contenido por el nuevo, asi no se concatena
	           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
	           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
	            	$("#cbhorario").replaceWith(combo);  
	            	$("#segundopaso").show();
	            	}
            
    });
};

</script>

<!-- VER Clieentes ES Llamada ajax para sacar los horarios disponibles -->
<script type="text/javascript">

$("#buscarcliente").click(function(){
	console.log($("#nombrecliente").val());
	buscarclientes($("#nombrecliente").val());
});

function buscarclientes(nombre){
	var parametros = {
            "oper" : "buscarcliente",
            "nombre" : nombre
    }    
	console.log(parametros.oper);
	console.log(parametros.nombre)
    $.ajax({
            data:  parametros,
            url:   'SvCita',
            type:  'POST',
            beforeSend: function () {
            	$("#clientes").replaceWith('<div id="clientes"><p>Buscando clientes...<img src="IMAGENES/ajaxtriangulos.gif"  width="50px" height="50px"  alt="imagenloading...."/></p></div>');
            },
            success:  function (response) {
            	
            	// Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
                var combo = $('<select name="clientes" id="clientes" class="form-control">');
             // Iterate over the JSON array.
             if (response.length>0)
				{            	
                $.each(response, function(index, item) { 
                	 // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
                    $('<option>').attr('value',item.oid_cliente).text(item.nombre+" "+item.Apellido1).appendTo(combo);    
                	 console.log("Nombre + Apellidos cliente"+item.nombre+item.Apellido1);
                	 console.log("Id cliente "+item.oid_cliente);
                	 console.log(index);
                });
            	console.log(response);
           	//Reemplazo el anterior contenido por el nuevo, asi no se concatena
           	//Importante que claro lo pongo en infotabla, con lo que mi tabla nueva tiene que tener la misma id
           	//Si no, no lo pongo en ningun lado y dejaria de funcionar.
            	$("#clientes").replaceWith(combo);
            	$("#altacita").show();     
				}
             else
            	 {
            	 console.log("no hay clientes con ese nombre");
            	 $("#clientes").replaceWith('<div id="clientes"><p><span class="label label-danger">No hay clientes para esa busqueda</span></p><br><button class="btn btn-primary" id="altacliente" name="altacliente" onclick="crearcliente();" >Crear Cliente</button></div>');
            	 $("#altacita").hide(); 
            	 }
            }
    });
};

</script>

<!-- Crear clientes en caso de que no encuentre ninguno, evento click + llamada ajax -->
<script type="text/javascript">

$("#altacliente").click(function(){
	console.log("Crear cliente");
});

function crearcliente(){
	var parametros = {
            "oper" : "alta"
    }    
	console.log(parametros.oper);
    $.ajax({
            data:  parametros,
            url:   'SvMenu',
            type:  'POST',
            beforeSend: function () {
            	$("#clientes").replaceWith('<div id="clientes"><p>Buscando clientes...<img src="IMAGENES/ajaxtriangulos.gif"  width="50px" height="50px"  alt="imagenloading...."/></p></div>');
            },
            success:  function (response) {
            	
            	 url = "SvMenu?oper=alta";
     		      $(location).attr("href", url);
            }
    });
};

</script>


<!-- Crear la cita, se recogen los parametros y se invoca por ajax -->
<script type="text/javascript">

$("#altacita").click(function(){
	console.log("altacita");
	altacita($("#fecha").val(),$("#cbhorario").val(),$("#clientes").val())
});

function altacita(fecha,horario,oid_cliente){
	var parametros = {
            "oper" : "crearcita",
            "fecha" : fecha,
            "horario" : horario,
            "oid_cliente" : oid_cliente
            
    }    
	console.log("oper"+parametros.oper);
	console.log("fecha"+parametros.fecha);
	console.log("horario"+parametros.horario);
	console.log("oid_cliente"+parametros.oid_cliente);
    $.ajax({
            data:  parametros,
            url:   'SvCita',
            type:  'POST',
            beforeSend: function () {
            	$("#segundopaso").hide();
            	$("#altacita").hide(); 
            	$("#cbhorario").hide();
            	$("#modalespera").modal('show');
            },
            success:  function (response) {
            	
            	$("#modalespera").modal('hide');
            	console.log("Si ha sido exito pone un 1"+response);
            	if(response==1)
            		{
            		$("#resultadomodal").replaceWith('<div id="resultadomodal" class="alert alert-success"><strong>Exito! </strong>Se dio de alta la cita correctamente</div>');		
            		}
            	else
            		{
            		$("#resultadomodal").replaceWith('<div id="resultadomodal"  class="alert alert-danger"><strong>Fallo!</strong>Algo ha ido mal, no se dio de alta, si el error continua pongase en contacto con el administrador</div>');
            		}
            	$("#modalinfo").modal('show');  
            }
    });
};


$('#modalinfo').on('hidden.bs.modal', function (e) {
	console.log("Se cerro el modal");
	alert("bla");
	})
function irapaginainicio()
{
	 url = "SvInicio?operacion=inicio";
      $(location).attr("href", url);
	
	}
</script>


<!-- Modal -->
<div id="modalinfo" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <div class="label label-default"></div>
        	<div id="resultadomodal"></div>
      </div>
      <div class="modal-footer">
        <button id="fincitaalta" type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
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