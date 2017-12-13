<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FisioPro - Seleccion Tipo Consulta</title>

</head>
<body>
<%@ include file="/WEB-INF/Cabecera.jsp" %>

<div class="container">
<h1 align="center">Alta Consulta</h1>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<table class="table table-hover thead-light" border="1px">
				<form action="SvConsulta" method="POST">
				
					<input type="hidden" name="cliente" value="${cliente}"/>
					<tr>
						<td><input type="radio" id="nueva" name="oper" value="nueva">Nueva Consulta</td>
					</tr>
					<tr>
						<td><input type="radio" id="vieja" name="oper" value="seguimiento">Seguimiento de otra consulta</td>						
					</tr>
			</table>	

				<div class="col-md-4 col-md-offset-4">
					<button id="continuar" type="submit" name="oper" value="nueva" class="btn btn-success">Continuar</button>
				</div>
		</div>
		</form>
	</div>
</div>
</body>

<script type="text/javascript">
$( "#continuar" ).click(function() {
	  console.log($("#nueva").val());
	  console.log($("#vieja").val());

	});

</script>

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