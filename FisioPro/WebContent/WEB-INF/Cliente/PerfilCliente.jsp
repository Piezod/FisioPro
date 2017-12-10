<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/Perfil.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<%@ include file="/WEB-INF/Cabecera.jsp" %>

</head>
<body>
<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
<jsp:useBean id="now" class="java.util.Date" />
     
<p class=" text-info">La fecha de hoy es : <fmt:formatDate pattern = "dd-MM-yyyy" 
         value = "${now}" /></p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Datos del Cliente</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                <img alt="User Pic" src="IMAGENES/vegeta_perfil.jpg" class="img-circle img-responsive">
                 </div>
              
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Nombre:</td>
                        <td>${cliente.nombre}</td>
                      </tr>
                      <tr>
                        <td>1º Apellido :</td>
                        <td>${cliente.apellido1}</td>
                      </tr>
                      <tr>
                        <td>2º Apellido :</td>
                        <td>${cliente.apellido2}</td>
                      </tr>
                      <tr>
                        <td>Edad :</td>
                        <td>${cliente.edad}</td>
                      </tr>
                        <tr>
                        <td>Telefono :</td>
                        <td>${cliente.telefono}</td>
                      </tr>
                        <td>Antecedentes Personales</td>
                        <td>
                        <br><br>
                        ${antecedentes.enfermedadesGraves}
                        <br><br>
                        ${antecedentes.operacionesQuirurjicas}
                        <br><br>
                         ${antecedentes.tratamientoMedicoActual}
                        <br><br>
                         ${antecedentes.lesionesAntiguas}
                        <br><br>
                        </td>
                           
                      </tr>
                     
                    </tbody>
                  </table>
                  <form method="post" action="SvConsulta">
                  <input type="hidden" value="${cliente.oid}" name="cliente"/>
                  <button type="submit" value="alta" name="oper" class="btn btn-primary">Alta Consulta</button>                  
                  </form>
                  <a href="SvVerConsultas?oper=detalleconsulta&oid_cliente=${cliente.oid}" value="VerConsultas" name="oper" class="btn btn-primary">Ver Consultas</a>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="SvCliente.html" data-original-title="Editar cliente" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Eliminar Usuario" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>