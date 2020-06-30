<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h3>Personas</h3>
<!--  Controlador Principal -->
<!-- Según la accion me redirecciona el listar trae la vista el agregar, redireciona desde
el servlet a la vista agregar -->
<form action="controlador" method="post">
<input type ="submit" name="accion" value="listar">
<input type ="submit" name="accion" value="Agregar">
</form>


<table border="1">

<thead> 
<tr>
<th>ID</th>
<th>NOMBRES</th>
<th>CORREO</th>
<th>TELEFONO</th>
<th>ACCIONES</th>

</tr>
</thead>
<tbody>

<c:forEach var="datos" items="${datos}">
<tr>
<td>${datos.getId()}</td>
<td>${datos.getNom()} </td>
<td>${datos.getCorreo()}</td>
<td>${datos.getTele()}</td>
<td>
<!--  CAPTURAMOS EL ID LO ESCONDEMOS Y POR EL METODO POST LO PASAMOS AL CONTROLADOR  -->
<form action="controlador" method="post">
<input type ="hidden" name="id" value="${datos.getId()}">
<input type ="submit" name="accion" value="Editar">
<input type ="submit" name="accion" value="eliminar">
</form>
</td>
</tr>

</c:forEach>



</tbody>
</table>




</div>
</body>
</html>