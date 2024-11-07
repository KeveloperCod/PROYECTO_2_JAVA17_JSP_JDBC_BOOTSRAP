<%@page import="model.Curso"%> 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Cursos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">	 	
		
		 <div>
		        <a href="${pageContext.request.contextPath}/cursoServlet?opcion=nue"> Nuevo Curso </a>
		 </div> 
		 
		<table class="table table-hover">
		 <thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Nivel</th>
				<th>modalidad</th>
				<th>creditos</th>
				<th>precio</th>
				<th></th>
				<th></th>
			</tr>
		 </thead>
	      <tbody>
	      <% 
	      		List<Curso> lstCursos = (List<Curso>) request.getAttribute("lstCursos");
	      		if (lstCursos!=null){
	      			for( Curso cur : lstCursos ) {
	      %>
	      
	     	 <tr>
			     	<td><%=cur.getCodigo() %></td>
			      	<td><%=cur.getNombre() %></td>
			      	<td><%=cur.getNivel() %></td>
			      	<td><%=cur.getModalidad() %></td>
			      	<td><%=cur.getCreditos() %></td>
			      	<td><%=cur.getPrecio() %></td>
			      	<td> <a href="${pageContext.request.contextPath}/cursoServlet?opcion=bus&cod=<%=cur.getCodigo() %>"> Actualizar </a></td>
			      	<td> <a href="${pageContext.request.contextPath}/cursoServlet?opcion=eli&cod=<%=cur.getCodigo() %>"> Eliminar </a></td>
			</tr>
			
			<%
	      			}
	      		}			
 			%>
			</tbody>
		</table>
	</div>
	
		
	  <%    String mensaje = (String)request.getAttribute("mensaje");
			if (mensaje==null) mensaje="";	
	  %>  
	  		<%=mensaje%>   
</body>
</html>
