<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Inventario</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<h1 style="text-align: center;">Lista de Productos</h1>
	<table>
		<tr>
			<td><a class="btn btn-primary" href="adminInventario?action=index" >Regresar</a> </td>
                        <td align="center"><a style="text-align: center;" class="btn btn-success" href="adminInventario?action=nuevo">Nuevo Producto</a></td>
		</tr>
	</table>
	<br>
	<table class="table table-striped" border="0" width="90%">
            <thead>
                <tr>
		 <td style="text-align: center;" scope="col">ID</td>
		 <td style="text-align: center;" scope="col">CODIGO</td>
		 <td style="text-align: center;" scope="col">NOMBRE</td>
		 <td style="text-align: center;" scope="col">DESCRPICION</td>
		 <td style="text-align: center;" scope="col">EXISTENCIA</td>
		 <td style="text-align: center;" scope="col">PRECIO</td>
		 <td style="text-align: center;" colspan=2>ACCIONES</td>
		</tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${lista}">
			<tr>
				<td style="text-align: center;" scope="row"><c:out value="${producto.id}"/></td>
				<td style="text-align: center;" scope="row"><c:out value="${producto.codigo}"/></td>
				<td style="text-align: center;" scope="row"><c:out value="${producto.nombre}"/></td>
				<td style="text-align: center;" scope="row"><c:out value="${producto.descripcion}"/></td>
				<td style="text-align: center;" scope="row"><c:out value="${producto.existencia}"/></td>
				<td style="text-align: center;" scope="row"><c:out value="${producto.precio}"/></td>
				<td style="text-align: center;" scope="row"><a class="btn btn-warning" style="text-align: center;" href="adminInventario?action=showedit&id=<c:out value="${producto.id}" />">Editar</a></td>
				<td style="text-align: center;" scope="row"><a class="btn btn-danger" style="text-align: center;" href="adminInventario?action=eliminar&id=<c:out value="${producto.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
            </tbody>
	</table>
	
</body>
</html>