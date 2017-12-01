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
		<table>
			<form method="post" action="SvConsultaCliente">
				<tr><th>Nombre de cliente</th></tr>
				<tr><td><input type="text" name="name" id="name" placeholder="Introduzca nombre"></td></tr>
				<input type="hidden" name="oper" value="consulta">
				<tr><td><div class="btn btn-primary"><input type="submit" id="enviar" name="enviar"></div></td></tr>
			</form>
		</table>
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