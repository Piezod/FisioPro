<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

$(document).ready( function() {
	   
	 $.fn.MessageBox = function(msg) {
	        url = "SvConsultaCliente?oper=perfil&oid="+msg;
		      $(location).attr("href", url);
	    };

});
<tr onClick="$(this).MessageBox('${item.oid}');"> 

body {
    background-image: url("IMAGENES/fondo001.jpg");
    background-repeat: no-repeat;
}
<!-- para cambiar el color del mouse over de una tabla -->
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  background-color: #6495ED;
}


    
    
    CODIGO AJAX PARA RECORRER UNA LISTA
    // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$(document).on("click", "#relista", function() { 
	// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
    $.post("PruebaAjax", function(responseJson) { 
    	 // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        var $ul = $("<ul>").appendTo($("#listado"));
     // Iterate over the JSON array.
        $.each(responseJson, function(index, item) { 
        	 // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
            $("<li>").text(item).appendTo($ul);     
        });
    });
});


CODIGO AJAX PARAR ECARGAR Y CREAR UAN TABLA

// When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$(document).on("click", "#vertabla", function() { 
	alert("recarga de tabla");
	// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
    $.post("PruebaAjax", function(responseJson) { 
    	console.log(responseJson);
    	// Create HTML <table> element and append it to HTML DOM element with ID "somediv".
       var $tablec = $("<table>").appendTo($("#tablaconsultas")); 
     // Iterate over the JSON array.
        $.each(responseJson, function(index, item) { 
        	console.log("Indice "+index +"Item "+item);
            // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
        	$("<tr>").appendTo($tablec)   
                // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
        	  .append($("<td>").text(item.oid_consulta))     
                 // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
              .append($("<td>").text(item.oid_cliente))
                // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
              .append($("<td>").text(item.oid_anamnesis));  
      });    
        });
    });