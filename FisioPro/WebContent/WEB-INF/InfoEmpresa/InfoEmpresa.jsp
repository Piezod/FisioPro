<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/Cabecera.jsp" %>
  <head>
  <title>FisioPro - Contacto </title>
    <style>
      #map {
        height: 250px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <div class="container" style="margin-top: 2%;">
    	   <div class="col-md-5">
			 <div class="panel panel-info">
				<div class="panel-heading">Sobre nosotros</div>
				    <div class="panel-body">
				    	<table>
				    		<tr><th>Nombre:</th><td>FisioPro</td></tr>
				    		<tr><th>info:</th><td>Mas informacion</td></tr>
				    		<tr><th>Telefono:</th><td>923111222</td></tr>
				    	</table>				    
				    </div>
				  </div>
			</div>
		    <div class="col-md-5">
			 <div class="panel panel-success">
			 	<div class="panel-heading">Donde estamos</div>
				    <div class="panel-body"><div id="map"></div></div>
			</div>
			</div>
	</div>
  
    <script>
      function initMap() {
    	  
        var uluru = {lat: 41.82544811386328, lng: -5.960874259471893};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPoOgWUyHiygD8b1QgiTjz4ULOxXm3DOs&callback=initMap">
    </script>
  </body>
</html>