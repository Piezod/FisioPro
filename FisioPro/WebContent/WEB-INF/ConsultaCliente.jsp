<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

</script>


</head>
<body>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<div class="container">
<h1 align="center">Consulta Clientes</h1>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			
			<table class="table table-hover thead-light" border="1px">
				<form action="SvCliente" method="post">
					<tr><th>Enfermedades Graves</th><td><input type="text" name="eg" id="eg"/></td></tr>
					<tr><th>Operaciones Quirúrgicas</th><td><input type="text" name="oq" id="oq"/></td></tr>
					<tr><th>Tratamiento médico actual</th><td><input type="text" name="tma" id="tma"/></td></tr>
					<tr><th>Lesiones Antiguas</th><td><input type="text" name="la" id="la"/></td></tr>
					<input type="hidden" id="operacion" name="oper" value="antecedentespersonales">
					<input type="hidden" id="oid_cliente" name="oid_cliente" value="${idcliente}"/>
			</table>	
				<div class="col-md-4 col-md-offset-4">
					<input type="submit" id="altaantecedentes" value="Alta Antecedentes" name="Alta Antecedentes"></input>
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

<img src="IMAGENES/ajaxloader.gif" alt="imagenloading...."/>
<div id="respuesta">asdf</div>


</html>