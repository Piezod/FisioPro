<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function altacliente(nombre,ape1,ape2,edad,tlfn,oper){
	
	
        var parametros = {
                "nombre" : nombre,
                "ape1" : ape1,
                "ape2" : ape2,
                "edad" : edad,
                "tlfn" : tlfn,
                "oper" : oper
        }
        
        
        alert(nombre + ape1 + ape2 + edad + tlfn + oper);
        
        $.ajax({
                data:  parametros,
                url:   'SvCliente',
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
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<div class="container">
<h1 align="center">Alta Cliente</h1>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<table class="table table-hover thead-light" border="1px">
				<form action="SvCliente" method="POST">
					<tr><th>Nombre</th><td><input type="text" name="nombre" id="nombre"/></td></tr>
					<tr><th>Primer Apellido</th><td><input type="text" name="apellido1" id="apellido1"/></td></tr>
					<tr><th>Segundo Apellido</th><td><input type="text" name="apellido2" id="apellido2"/></td></tr>
					<tr><th>Edad</th><td><input type="text" name="edad" id="edad"/></td></tr>
					<tr><th>Telefono</th><td><input type="text" name="telefono" id="telefono"/></td></tr>
					<input type="hidden" id="oper" name="oper" value="alta">
			</table>	
				<!--  <div class="col-md-4 col-md-offset-4">
					<button class="btn btn-succes"
					 value="alta" name="Alta Cliente" 
					 onclick="altacliente($('#nombre').val(), $('#apellido1').val(), $('#apellido2').val(), $('#edad').val(), $('#telefono').val(),$('#oper').val());return false;"
					 id="btnaltausuario">Alta</button>
				</div>	 -->
				<div class="col-md-4 col-md-offset-4">
					<input type="submit" id="altacliente" name="Alta cliente"></input>
				</div>
		</div>
		</form>
	</div>
</div>
</body>

<!-- Modal -->
<div id="modalnotificacion" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"><div id="modalheader"></div></h4>
      </div>
      <div class="modal-body">
        <div id="cuerpomodal"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</html>