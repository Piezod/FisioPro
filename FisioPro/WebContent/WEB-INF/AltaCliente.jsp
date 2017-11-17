<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/Cabecera.jsp" %>




<div class="container">
<h1 align="center">Alta Usuario</h1>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			
			<table class="table table-hover thead-light" border="1px">
				<form action="SvCliente" method="post">
					<tr><th>Nombre</th><td><input type="text" name="nombre" id="nombre"/></td></tr>
					<tr><th>Primer Apellido</th><td><input type="text" name="apellido1" id="apellido1"/></td></tr>
					<tr><th>Segundo Apellido</th><td><input type="text" name="apellido2" id="apellido2"/></td></tr>
					<tr><th>Edad</th><td><input type="text" name="edad" id="edad"/></td></tr>
					<tr><th>Telefono</th><td><input type="text" name="telefono" id="telefono"/></td></tr>
					<input type="hidden" name="operacion" value="alta">
				
			</table>	
				<div class="col-md-4 col-md-offset-4">
					<input class="btn btn-succes" type="submit" value="alta" name="Alta Cliente" id="btnaltausuario">
				</div>	
		</div>
		</form>
	</div>
</div>
</body>
</html>