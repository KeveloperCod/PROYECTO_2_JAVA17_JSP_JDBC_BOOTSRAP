<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Actualizar Docente</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
	    <div class="row">
	        <div class="col-md-10 offset-md-3">   
				    <form id="frmActualizarDocente" action="docenteServlet" method="post" >
				        <h2 class="mb-4">Actualizar Docente</h2>
				        <div class="row">
				            <div class="col-md-6">
				                <div class="form-group">
				                    <label for="txtCodigo">Código</label>
				                    <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" readonly="readonly" value="${docente.codigo}">
				                </div>
				                
				                <br>
				                <div class="form-group">
				                    <label for="txtNombres">Nombres</label>
				                    <input type="text" class="form-control" id="txtNombres" name="txtNombres" value="${docente.nombre}">
				                </div>
				                 <br>
				                <div class="form-group">
				                    <label for="txtApePat">Apellido Paterno</label>
				                    <input type="text" class="form-control" id="txtApePat" name="txtApePat" value="${docente.apePaterno}">
				                </div>
				                 <br>
				                <div class="form-group">
				                    <label for="txtApeMat">Apellido Materno</label>
				                    <input type="text" class="form-control" id="txtApeMat" name="txtApeMat" value="${docente.apeMaterno}">
				                </div>
				                
				                <br>
				                <div class="form-group">
				                    <label for="txtEmail">Email</label>
				                    <input type="email" class="form-control" id="txtEmail" name="txtEmail" value="${docente.email}">
				                </div>
				                
				                <br>
				                <div class="form-group">
				                    <label for="txtNumCel">Núm. Celular</label>
				                    <input type="text" class="form-control" id="txtNumCel" name="txtNumCel" value="${docente.celular}">
				                </div>
				                
				              	<br>
				                <div class="form-group">
				                    <label for="cboProfesion">Profesión</label>
				                    <select class="form-control" id="cboProfesion" name="cboProfesion">
				                        <option value="1" ${docente.idProfesion == 1 ? 'selected' : ''}>Ingeniero(a) de Sistemas</option>
				                        <option value="2" ${docente.idProfesion == 2 ? 'selected' : ''}>Ingeniero(a) de Datos</option>
				                        <option value="3" ${docente.idProfesion == 3 ? 'selected' : ''}>Ingeniero(a) de Software</option>
				                        <option value="4" ${docente.idProfesion == 4 ? 'selected' : ''}>Diseñador(a) Gráfico(a)</option>
				                        <option value="5" ${docente.idProfesion == 5 ? 'selected' : ''}>Licenciado(a) en Marketing</option>
				                    </select>
				                </div>
				                  <br>
				                <div class="form-group"> 
						        	<button type="submit" name="opcion" value="act" class="btn btn-primary">Actualizar</button>
						        </div>	
						        
						        <% 
				                    String mensaje = (String)request.getAttribute("mensaje");
				                    if (mensaje == null) mensaje = "";	
				                %>  
								<div class="mt-3">
								   <span class="text-success"><%=mensaje%></span>  
								</div>   	  

				            </div>
				        </div>		        		        
				    </form>
	        </div>
	    </div>
	</div>
	
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
        	$.validator.addMethod("numericOnly", function(value, element) {
        	    return this.optional(element) || /^[0-9]+$/.test(value);
        	}, "Ingrese solo números.");
        	 
            $("#frmActualizarDocente").validate({
                rules: {
                	txtCodigo: "required",
                	txtNombres: "required",
                	txtApePat: "required",
                	txtApeMat: "required",
                	txtEmail: {
                        required: true,
                        email: true
                    },
                	txtNumCel: {
                        required: true,
                        numericOnly: true 
                    },
                	cboProfesion: "required"
                },
                messages: {
                	txtCodigo: "Ingrese el código del docente",
                    txtNombres: "Ingrese el nombre del docente",
                    txtApePat: "Ingrese el apellido paterno",
                    txtApeMat: "Ingrese el apellido materno", 
                    txtEmail: {
                        required: "Ingrese el correo del docente",
                        email: "Ingrese una dirección válida"
                    },
                    txtNumCel: {
                        required: "Ingrese el número celular del docente",
                        numericOnly: "Ingrese solo números"
                    },
                    cboProfesion: "Seleccione una profesión"
                },
                errorElement: "span",
                errorPlacement: function(error, element) {
                    error.addClass("invalid-feedback");
                    element.closest(".form-group").append(error);
                },
                highlight: function(element, errorClass, validClass) {
                    $(element).addClass("is-invalid").removeClass("is-valid");
                },
                unhighlight: function(element, errorClass, validClass) {
                    $(element).removeClass("is-invalid").addClass("is-valid");
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
        });
    </script>
</body>
</html>
