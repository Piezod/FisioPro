<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Naturaleza del Dolor</title>
<style type="text/css">
body {
    background-image: url("IMAGENES/Fondos/10.jpg");
    background-repeat: no-repeat;
}
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  background-color: #E6E6FA;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<div class="container">
<form action="SvConsulta" method="post">
<div class="row">
<br>
		<div class="col-md-5 col-md-offset-1">
		<!-- Los textArea por un lado -->
		<p>${oid_anamnesis}</p>
		<table class="table table-hover thead-light" border="1px">
			<tr><th>Localización</th><td><input class="form-control" type="text" value=" " name="localizacion" id="localizacion"/></td></tr>
			<tr><th>Irradiacion</th><td><input class="form-control" type="text" value=" "  name="irradiacion" id="irradiacion"/></td></tr>
			<tr><th>Cambia de lugar</th><td><input class="form-control" type="text"  value=" " name="cambialugar" id="cambialugar"/></td></tr>
			<tr><th>Relacion con tos</th><td><input class="form-control" type="text"  value=" " name="rbtos" id="rbtos"/></td>					
		</table>
		</div>
		<!-- Los Select por otro lado -->
		<div class="col-md-5 col-md-offset-1">
			<table class="table table-hover thead-light" border="1px">
			<tr><th>Cronologia</th>
				<td><select class="form-control" name="cronologia" id="cronologia">
						<option value="vacio"></option>
						<option value="dias">Dias</option>
						<option value="semanamas">Mas de una semana</option>
						<option value="menosmes">Menos de un mes</option>
						<option value="masmes">Mas de un mes</option>
						<option value="mas6meses">Mas de 6 meses</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>Forma</th>
				<td>
					<select class="form-control" name="forma" id="forma">
						<option value="vacio"></option>
						<option value="Constante">Constante</option>
						<option value="Intermitente">Intermitente</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>Forma de Comienzo</th>
				<td>
					<select class="form-control" name="comienzo" id="comienzo">
						<option value="vacio"></option>
						<option value="Agudo">Agudo</option>
						<option value="Insidioso">Insidioso</option>
					</select>
				</td>
			</tr>
			<tr><th>Impot. Func.</th>
				<td>
					<select class="form-control"  name="impotencia" id="impotencia">
						<option value="vacio"></option>
						<option value="pequeña">Pequeña</option>
						<option value="media">Media</option>
						<option value="grande">Grande</option>
					</select>
				</td>
			</tr>
		</table>
		</div>
</div>
	<!-- Listas -->
<div class="row">
		<div class="col-md-11 col-md-offset-1">
		<table class="table table-hover thead-light" border="0px">
			<tr><th>Hora</th>
				<td><select class="form-control" name="hora" id="hora" multiple>
						<option value="vacio"></option>
						<option value="mañana">Mañana</option>
						<option value="largodia">A lo largo del dia</option>
						<option value="fintarde">Final de la tarde</option>
						<option value="noche">Por la noche</option>
						<option value="noche">Noche</option>
					</select>
				</td>
			</tr>
			<tr><th>Intensidad</th>
				<td>
					<select class="form-control" name="inten" id="inten" multiple>
						<option value="leve">Leve</option>
						<option value="moderado">Moderado</option>
						<option value="punzante">Punzante</option>
						<option value="sordo">Sordo</option>
						<option value="continuo">Continuo</option>
						<option value="intermitente">Intermitente</option>
						<option value="cansancio">Acentua con el cansancio</option>
					</select>
				</td>
			</tr>
			<tr><th>Factor desencadenate</th>
				<td><select class="form-control" name="desencadenante" id="desencadenante" multiple>
						<option value="reposo">Reposo</option>
						<option value="frio">Frio</option>
						<option value="calor">Calor</option>
						<option value="presion">Presion</option>
						<option value="estres">Estrés</option>
					</select>
				</td>
			</tr>
			<tr>
					<th>FactorAliviadores</th>
					<td>
						<select class="form-control" name="aliviadores" id="aliviadores" multiple>
							<option value="reposo">Reposo</option>
							<option value="frio">Frio</option>
							<option value="calor">Calor</option>
							<option value="presion">Presion</option>
							<option value="estres">Estrés</option>
						</select>
					</td>
			</tr>
				<div class="col-md-4 col-md-offset-4">
				<tr align="center">
					<td>
				<button class="btn btn-primary" type="submit" id="exploracion" name="oper" value="exploracion">Siguiente</button>
					</td>
					<td>
				<button class="btn btn-warning" type="submit" id="5elementos" name="oper" value="5elementos">5 elementos</button>
					</td>
				</tr>
	</div>
		</table>
		</div>
</div>

	<input type="hidden" name="oid_anamnesis" value="${oid_anamnesis}">
	<input type="hidden" name="cliente" value="${cliente}"/>

	
</form>
</div>
</body>
<script>
$(document).ready(function() {
	  $(window).keydown(function(event){
	    if( (event.keyCode == 13)) {
	      event.preventDefault();
	      return false;
	    }
	  });
	});
</script>

</html>