<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Persona</title>
</head>
<body>
<form action="controlador"Method="POST">
id:
<input type="text" name="txtid" value="${datos.getId()}"><br>
Nombre:
<input type="text" name="txtnom" value ="${datos.getNom()}"><br>
Correo
<input type="text" name="correo" value="${datos.getCorreo()}"><br>

Telefono
<input type="text" name="telefono" value="${datos.getCorreo()}"><br>
<input type="submit" name="accion" value="guardar">
</form>



</form>
</body>
</html>