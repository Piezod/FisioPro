<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Consultas</title>

<%@ include file="/WEB-INF/Cabecera.jsp" %>
</head>
<body>

<div class="container">

<h1 align="center">Ver Consultas EN PROCESO</h1>
<div class="row">
		<div class="col-md-4 col-md-offset-4">
		<table>
			<form method="post" action="SvVerConsultas">
				<tr>
					<th>Seleccione un cliente:</th>
					<td>
						<select name="oid_cliente">
							<c:forEach var="item"  items="${listacliente}" varStatus="loop">
									<option  value="${item.oid}">
										<c:out value="${item.oid}"></c:out>
										<c:out value="${item.nombre}"></c:out>
										<c:out value="${item.apellido1}"></c:out>
										<c:out value="${item.apellido2}"></c:out>							
									</option>							
							</c:forEach>
						</select>
					</td>
				</tr>		
				<tr>	
					<td>					
						<button class="btn btn-primary" type="submit" id="enviar" name="enviar"> Buscar</button>						
					</td>
				</tr>
				<input type="hidden" name="oper" value="detalleconsulta"/>
			</form>
		</table>
	</div>
</div>

</body>

</html>