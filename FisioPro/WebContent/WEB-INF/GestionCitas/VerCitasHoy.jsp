<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ include file="/WEB-INF/Cabecera.jsp" %>
</head>
<body>

<div class="container">

<h1 align="center">Ver Consultas</h1>
<c:if test="${!mostrarconsulta}">
<div class="row">
		<div class="col-md-4 col-md-offset-4">
		<table>
			<form method="post" action="SvConsultaCliente">
				<tr>
					<th>Seleccione un cliente:</th>
					<td>
						<select>
							<c:forEach var="item"  items="${listacliente}" varStatus="loop">
									<option value="${item.oid}">
										<c:out value="${item.nombre}"></c:out>
										<c:out value="${item.apellido1}"></c:out>
										<c:out value="${item.apellido2}"></c:out>							
									</option>							
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr><td><input type="text" name="name" id="name" placeholder="Introduzca nombre"></td></tr>
				<input type="hidden" name="oper" value="consulta">
				<tr>
					<td>					
						<button class="btn btn-primary" type="submit" id="enviar" name="enviar"> Buscar</button>						
					</td>
				</tr>
			</form>
		</table>
	</div>
</div>
</c:if>

<div class="col-md-4 col-md-offset-4">
					  <table class="table table-hover">
		  	<tr>
		  		<th></th>
		  		<th> Nombre</th>
		  		<th> Apellido1 </th>
		  		<th> Apellido2</th>
		  		<th> Edad </th>
		  		<th> Telefono </th>
		  	</tr>
<c:forEach var="item"  items="${listacliente}" varStatus="loop">

			<tr onClick="$(this).MessageBox('${item.oid}');"> 
				
				<td><a href="SvConsultaCliente?oper=perfil&oid=${item.oid}">
					<span class="glyphicon glyphicon-eye-open"></span>
				</a></td>
				<td><c:out value = "${item.nombre}"/></td>
				<td><c:out value = "${item.apellido1}"/></td>
				<td><c:out value = "${item.apellido2}"/></td>
				<td><c:out value = "${item.edad}"/></td>
				<td><c:out value = "${item.telefono}"/></td>
			</tr>
</c:forEach>
</table>

<p>Se han encontrado ${NumeroMaximoRegistros} coincidencias.</p> 


<ul class="pagination">

<li><a href="SvConsultaCliente?oper=consulta&name=${name}&NumeroPulsado=0">Primera</a></li>
<c:forEach begin="0" end="${NumeroPaginaciones}" varStatus="loop">
		  <li><a href="SvConsultaCliente?oper=consulta&name=${name}&NumeroPulsado=${loop.index}">${loop.index}</a></li>
</c:forEach>
<li><a href="SvConsultaCliente?oper=consulta&name=${name}&NumeroPulsado=${NumeroPaginaciones}">Ultima</a></li>
</ul>
</body>

</html>