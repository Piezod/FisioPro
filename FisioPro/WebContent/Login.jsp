<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Login JC Pruebas</title>
<link rel="stylesheet" href="css/login.css" type="text/css"/>
<script type="text/javascript">
$(document).ready(function () {
    $('.forgot-pass').click(function(event) {
      $(".pr-wrap").toggleClass("show-pass-reset");
    }); 
    
    $('.pass-reset-submit').click(function(event) {
      $(".pr-wrap").removeClass("show-pass-reset");
    }); 
});
</script>
</head>
<body>



<div class="container">
    <div class="row" style="margin-top: 200px">
        <div class="col-md-12">
            <div class="pr-wrap">
                <div class="pass-reset">
                    <label>
                        Enter the email you signed up with</label>
                    <input type="email" placeholder="Email" />
                    <input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm" />
                </div>
            </div>
            <div class="wrap">
                <p class="form-title">Login </p>
                <form class="login" method="post" action="SvInicio">
                <input type="text" placeholder="Usuario" name="usuario" />
                <input type="password" placeholder="Password" name="pass" />
                <input type="hidden" name="operacion" value="login"/>
                <input type="submit" name="entrar" value="Log in" class="pass-reset-submit btn btn-success btn-sm"/>
                <div class="remember-forgot">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" />
                                    Recordarme
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 forgot-pass-content">
                            <a href="javascription:void(0)" id="forgot-pass" class="forgot-pass">Recordar password</a>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>

</div>
<!-- 

<table>
<tr>
<form >
</form>
	<th> Usuario  </th> <td> <input type="text"	name="usuario" placeholder="Usuario..." ></td>
</tr>
<tr>
	<th> Pass  </th> <td> <input type="password"	name="pass" placeholder=" Pass ..." ></td>
</tr>
<tr>
	<td><input type="submit" name="entrar" value="Log in"/></td> 
	<td><input type="submit" name="registrar" value="Alta nueva"/></td>
</tr>
</table>
 -->
</body>
</html>