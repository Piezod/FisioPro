<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Detalle Consulta</title>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<script type="text/javascript">

$(document).ready( function() {
	   
	 $.fn.AbrirFormularioAnamnesis = function(oid_anamnesis) {
		 
		 alert(oid_anamnesis);
	        url = "SvVerConsultas?oper=abriranamnesis&oid_anamnesis="+oid_anamnesis;
	        
		      $(location).attr("href", url);
	    };

});
</script>
</head>
<body>
<h1> Detalle de la consulta, mostrar el cliente y 4 sitios de anamnesis y demas y con el front al pulsar mostrar los datos
pero ls datos ya deben estar cargados, con onclick y display none y block mostrar
</h1>


<div class="col-md-4 col-md-offset-4">
					  <table class="table table-hover">
		  	<tr>
		  		<th> Fecha </th>
		  		<th> Nombre</th>
		  		<th> Apellido</th>
		  		<th> Que le sucedia </th>
		  		<th> Tratamiento prescrito</th>
		  		<th> Anamnesis/N. Dolor</th>
		  		<th> Exploracion </th>
		  		<th> Tratamiento </th>
		  		
		  	</tr>
		<c:forEach var="item"  items="${detalleconsulta}" varStatus="loop">
						<td><c:out value = "${item.fecha}"/></td>
						<td><c:out value = "${item.nombrecliente}"/></td>
						<td><c:out value = "${item.apellido1}"/></td>
						<td><c:out value = "${item.quelepasa}"/></td>
						<td><c:out value = "${item.tratamiento}"/></td>						
						<td onClick="$(this).AbrirFormularioAnamnesis('${item.oid_anamnesis}');"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span> </td>
						<td>${item.oid_exploración}</td>
						<td>${item.oid_tratamiento}</td>
					</tr>
		</c:forEach>
</table>
</body>
</html>