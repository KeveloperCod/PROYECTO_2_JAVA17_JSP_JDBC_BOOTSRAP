<%@page import="model.Docente"%> 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Docentes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
	    <div class="row">
	        <div class="col-12">
	            <h2 class="text-center mb-4">Listado de Docentes</h2>
	            <div class="d-flex justify-content-end mb-3">
	                <a href="${pageContext.request.contextPath}/docenteServlet?opcion=nue" class="btn btn-primary">Nuevo Docente</a>
	            </div>
	            <table class="table table-hover table-bordered">
	                <thead class="table-dark">
	                    <tr>
	                        <th>Id</th>
	                        <th>Nombre</th>
	                        <th>Apellido Paterno</th>
	                        <th>Apellido Materno</th>
	                        <th>Email</th>
	                        <th>Celular</th>
	                        <th>Id Profesión</th>
	                        <th>Acciones</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <% 
	                        List<Docente> lstDocentes = (List<Docente>) request.getAttribute("lstDocentes");
	                        if (lstDocentes != null) {
	                            for (Docente doce : lstDocentes) {
	                    %>
	                    <tr>
	                        <td><%= doce.getCodigo() %></td>
	                        <td><%= doce.getNombre() %></td>
	                        <td><%= doce.getApePaterno() %></td>
	                        <td><%= doce.getApeMaterno() %></td>
	                        <td><%= doce.getEmail() %></td>
	                        <td><%= doce.getCelular() %></td>
	                        <td><%= doce.getIdProfesion() %></td>
	                        <td>
	                            <a href="${pageContext.request.contextPath}/docenteServlet?opcion=bus&cod=<%= doce.getCodigo() %>" class="btn btn-sm btn-warning">Actualizar</a>
	                            <a href="${pageContext.request.contextPath}/docenteServlet?opcion=eli&cod=<%= doce.getCodigo() %>" class="btn btn-sm btn-danger">Eliminar</a>
	                        </td>
	                    </tr>
	                    <% 
	                            }
	                        } 
	                    %>
	                </tbody>
	            </table>
	            <% 
	                String mensaje = (String) request.getAttribute("mensaje");
	                if (mensaje != null && !mensaje.isEmpty()) { 
	            %>
	            <div class="alert alert-info mt-3" role="alert">
	                <%= mensaje %>
	            </div>
	            <% } %>
	        </div>
	    </div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-wEmeIV1mKuiNpWW6H3g6NtGELKjBZQ6btp3a1wZec4I0UrsDBnepq/x67VS3DOKA" crossorigin="anonymous"></script>
</body>
</html>
