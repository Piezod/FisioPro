<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Error 500 Fisio Pro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
   $(document).ready( function() {
	   
	   $( "#404" ).click(function() {
		   url = "Login.jsp";
		      $(location).attr("href", url);
		 });
   });
</script>
</head>
<body>
  <img id="404" class="img-responsive" src="IMAGENES/error500.gif" alt="Error 404" width="100%" height="100%"/> 
<p> asdf
<%@ page errorPage="true" %>
<% 
	Exception exception=new Exception();
    exception.printStackTrace(response.getWriter()); %>
</p>
</body>
</html>