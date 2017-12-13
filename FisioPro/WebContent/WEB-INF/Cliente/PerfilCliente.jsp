<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/Perfil.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#guardarpefil
{
	display:none;
}
</style>
<title>FisioPro - Perfil Cliente</title>

<%@ include file="/WEB-INF/Cabecera.jsp" %>

</head>
<body>
<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
      
      <!-- 
      <!-- <jsp:useBean id="now" class="java.util.Date" /> -->
     
<p class=" text-info">La fecha de hoy es : <fmt:formatDate pattern = "dd-MM-yyyy" 
         value = "${now}" /></p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Datos del Cliente</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                <img alt="User Pic" src="IMAGENES/cliente.png" class="img-circle img-responsive">
                 </div>
              
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr><th>Datos Personales</th></tr>
                      <tr>
                        <td>Nombre:</td>
                        <td><input class="form-control" type="text" value="${cliente.nombre}" name="nombre" id="nombre" readonly/></td>
                      </tr>
                      <tr>
                        <td>1º Apellido :</td>
                        <td><input class="form-control" type="text" value="${cliente.apellido1}" name="apellido1" id="apellido1" readonly/></td>
                      </tr>
                      <tr>
                        <td>2º Apellido :</td>
                        <td><input class="form-control" type="text" value="${cliente.apellido2}" name="apellido2" id="apellido2" readonly/></td>
                      </tr>
                      <tr>
                        <td>Edad :</td>
                        <td><input class="form-control" type="text" value="${cliente.edad}" name="edad" id="edad" readonly /></td>
                      </tr>
                        <tr>
                        <td>Telefono :</td>
                        <td><input class="form-control" type="text" value="${cliente.telefono}" name="telefono" id="telefono" readonly /></td>
                      </tr>
                      <tr>
                        <th>Antecedentes Personales</th>
                      </tr>
                      <tr>
                        <td>Enfermedades Graves</td>
                        <td><input class="form-control" type="text" value="${antecedentes.enfermedadesGraves}" name="eg" id="eg" readonly /></td>
                      </tr>
                      <tr>
                        <td>Operaciones Quirurjicas</td>
                       	<td> <input class="form-control" type="text" value="${antecedentes.operacionesQuirurjicas}" name="oq" id="oq" readonly /></td>
                       </tr>
                       <tr>
                        <td>Tratamiento Medico</td>
                       	<td><input class="form-control" type="text" value=" ${antecedentes.tratamientoMedicoActual}" name="tm" id="tm" readonly /></td>
                       </tr>
                       <tr>
                        <td>Lesiones Antiguas</td>
                        <td><input class="form-control" type="text" value="${antecedentes.lesionesAntiguas}" name="la" id="la" readonly /></td>                    
                       </tr>
                    </tbody>
                 
                  <form method="post" action="SvConsulta">
                  <input type="hidden" value="${cliente.oid}" id="oid_cliente" name="cliente"/>
                  <tr><td><button type="submit" value="alta" name="oper" class="btn btn-primary">Alta Consulta</button></td>                  
                  </form>
                  <td><a href="SvVerConsultas?oper=detalleconsulta&oid_cliente=${cliente.oid}" value="VerConsultas" name="oper" class="btn btn-primary">Ver Consultas</a></td></tr>
               	 </table>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a id="editarperfil" data-original-title="Editar cliente" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a id="guardarpefil" data-original-title="Editar cliente" data-toggle="tooltip" type="button" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-save"></i></a>	
                            <a id="eliminarcliente" data-original-title="Eliminar Usuario" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>                    
          </div>
        </div>
      </div>
    </div>
</body>
<!-- Evento para editar el perfil, se quitara el atributo de readonly, y el boton de modificar sera de guardar
	cuando se le de a guardar se volvera a poner el atributo y se hara una llamada ajax para guardar los datos nuevos
 -->
<script type="text/javascript">
$(document).ready(function(){
	console.log("Listo!");
    $("#editarperfil").click(function(){
        console.log("quitar remove only");
    	$("input").removeAttr("readonly");
    	$("input").css('background-color','#FC0');
    	$("#editarperfil").hide();
    	$("#guardarpefil").show();
    });
    $("#guardarpefil").click(function() {
		console.log("Guardar datos");
		modificarcliente($("#oid_cliente").val(),$("#nombre").val(),$("#apellido1").val(),$("#apellido2").val(),$("#edad").val(),$("#telefono").val(),$("#eg").val(),$("#oq").val(),$("#tm").val(),$("#la").val());
	 	$("#editarperfil").show();
    	$("#guardarpefil").hide();
		
	});
    
    $("#eliminarcliente").click(function(){
        console.log("eliminarcliente");
        $("#confirmarbaja").modal('show');
    });
    
    
    function modificarcliente(oid_cliente,nombre,apellido1,apellido2,edad,telefono,eg,oq,tm,la){
    	var parametros = {
                "oper" : "modificarcliente",
                "oid_cliente" : oid_cliente,
                "nombre" : nombre,
                "apellido1" : apellido1,
                "apellido2" : apellido2,
                "edad" : edad,
                "telefono" : telefono,
                "eg" : eg,
                "oq" : oq,
                "tm" : tm,
                "la" : la
        }    
    	console.log(parametros.oper);
    	console.log(parametros.oid_cliente);
    	console.log(parametros.nombre)
    	console.log(parametros.apellido1);
    	console.log(parametros.apellido2);
    	console.log(parametros.edad);
    	console.log(parametros.telefono);
    	console.log(parametros.eg);
    	console.log(parametros.oq);
    	console.log(parametros.tm);
    	console.log(parametros.la);
    	
    	
        $.ajax({
                data:  parametros,
                url:   'SvCliente',
                type:  'POST',
                beforeSend: function () {
                	
                	$("#ajaxmodal").modal('show');
                },
                success:  function (response) {
                	$("#ajaxmodal").modal('hide');
                	console.log(response);
                    console.log("poner el readonly");
                	$('input').prop('readonly', true);
                	$("input").css('background-color','#F0FFFF');
                }
        });
    };
});

</script>


<!-- Modal -->
<div id="ajaxmodal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <div class="label label-default"></div><p>Realizando la actualizacion...</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<!-- Modal Confirmar baja-->
<div id="confirmarbaja" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Eliminar cliente</h4>
      </div>
      <div class="modal-body">

        <table align="center">
        	<tr align="center">
        		<td style="padding: 20px">
        			<form method="POST" action="SvCliente">
        				<button type="submit" class="btn btn-danger" name="oper" value="baja">Confirmar</button>      
        				  <input type="hidden" value="${cliente.oid}" id="oid_cliente" name="cliente"/> 				
        			</form>
        		</td>
        		<td style="padding: 20px">
        			 <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>	
        		</td>
        	</tr>
        </table>
      </div>

    </div>

  </div>
</div>

</html>