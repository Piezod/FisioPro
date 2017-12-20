<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Consultas</title>

<%@ include file="/WEB-INF/Cabecera.jsp" %>
<STYLE>
body
{
    background: url('IMAGENES/Fondos/mantipyng.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
    opacity: 0.95;
    height:100px;
    filter: alpha(opacity=50); /* For IE8 and earlier */
}
</STYLE>
</head>
<body>

<div class="container">
<div style="margin-top: 10%"  class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
  <div class="panel panel-info">
	  <div class="panel-heading">
		<h1 align="center" style="width: 80%;">Ver Consultas , seleccione un cliente</h1>
	  </div>
	   <div class="panel-body">
			<div class="row" >

					<table align="center">
						<form method="post" action="SvVerConsultas">
							<tr>
								<th>Seleccione un cliente:</th>
								<td>
									<select name="oid_cliente" style="width: 80%;">
										<c:forEach var="item"  items="${listacliente}" varStatus="loop">
												<option  value="${item.oid}">										
													<c:out value="${item.nombre}"></c:out>
													<c:out value="${item.apellido1}"></c:out>
													<c:out value="${item.apellido2}"></c:out>							
												</option>							
										</c:forEach>
									</select>
								</td>
							</tr>		
							<tr>	
								<td colspan="2" align="center">					
									<button class="btn btn-primary" type="submit" id="enviar" name="enviar" style="margin-top: 5px;"> Buscar</button>						
								</td>
							</tr>
							<input type="hidden" name="oper" value="detalleconsulta"/>
						</form>
					</table>

			</div>
	  </div>
  </div>
</div>
</body>

</html>