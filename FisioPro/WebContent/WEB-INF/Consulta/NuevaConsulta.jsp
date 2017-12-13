<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Anamnesis</title>

</head>
<style type="text/css">
body {
    background-image: url("IMAGENES/Fondos/10.jpg");
    background-repeat: no-repeat;
}
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  background-color: #E6E6FA;
}
</style>
<body>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<div class="container">
<h1 align="center">Nueva Consulta</h1>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h3 align="center">Anamnesis</h3>
			<table class="table table-hover thead-light" border="1px">
				<form action="SvConsulta" method="POST">
					<tr>
						<th>Que Le Sucede</th>
						<td><textarea cols="50" rows="4" type="text" name="qls" id="qls"></textarea></td>
					</tr>
					<tr>
						<th>Desde Cuando</th>
						<td><textarea  cols="50" rows="4"  type="text" name="dc" id="dc"></textarea></td>
					</tr>
					<tr>
						<th>A que lo atribuye</th>
						<td><textarea noresize cols="50" rows="4"  type="text" name="atribuye" id="atribuye"></textarea></td>
					</tr>
					<input type="hidden" id="oper" name="oper" value="naturaleza">
					<input type="hidden" name="cliente" value="${cliente}"/>
						<div class="col-md-4 col-md-offset-4">
							<tr align="center"><td colspan="2"><button class="btn btn-success" type="submit" id="altaanamnesis" name="altaanamnesis">Siguiente</button></td></tr>
						</div>
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