<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/Cabecera.jsp" %>
<title>Exploracion</title>
</head>
<body>
<form action="SvConsulta" method="post">
	<div class="row">
	<br>
		<div class="col-md-4 col-md-offset-4">
		<table class="table table-hover thead-light" border="1px">
			<tr>
				<th>Inspeccion visual</th>
				<td><textarea class="form-control" cols="50" rows="4" type="text" name="visual" id="visual"></textarea></td>
			</tr>
			<tr>
				<th>Palpacion</th>
				<td><textarea class="form-control" cols="50" rows="4" type="text" name="palpacion" id="palpacion"></textarea></td>
			</tr>
			<tr>
				<th>Test de movilidad</th>
				<td><textarea class="form-control" cols="50" rows="4" type="text" name="movilidad" id="movilidad"></textarea></td>
			</tr>
			<tr>
				<th>Test Ortopedico</th>
				<td><textarea class="form-control" cols="50" rows="4" type="text" name="ortopedico" id="ortopedico"></textarea></td>
			</tr>		
			<div class="col-md-4 col-md-offset-4">
				<tr align="center"><td colspan="2"><button class="btn btn-success" type="submit" id="altaexploracion" name="oper" value="tratamiento">Siguiente</button></td></tr>
			</div>	
		</table>
		</div>
	</div>
</form>

</body>
</html>