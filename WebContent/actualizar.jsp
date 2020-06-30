<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="controlador"Method="POST">
id:
<input type="text" name="txtid" value="${persona.getId()}"><br>
Nombre:
<input type="text" name="txtnom" value="${persona.getNom()}"><br>
Correo
<input type="text" name="correo"  value="${persona.getCorreo()}"><br>

Telefono
<input type="text" name="telefono" value="${persona.getTele()}"><br>

<input type="submit" name="accion" value="Actualizar">
</form>





</body>
</html>