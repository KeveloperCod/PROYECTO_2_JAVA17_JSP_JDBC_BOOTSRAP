<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registrar Docente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header bg-primary text-white text-center">
                        <h4>Registrar Docente</h4>
                    </div>
                    <div class="card-body">
                        <form id="frmRegistroDocente" action="docenteServlet" method="post">
                            <div class="mb-3">
                                <label for="txtNombres" class="form-label">Nombres</label>
                                <input type="text" class="form-control" id="txtNombres" name="txtNombres">
                            </div>
                            <div class="mb-3">
                                <label for="txtApePat" class="form-label">Apellido Paterno</label>
                                <input type="text" class="form-control" id="txtApePat" name="txtApePat">
                            </div>
                            <div class="mb-3">
                                <label for="txtApeMat" class="form-label">Apellido Materno</label>
                                <input type="text" class="form-control" id="txtApeMat" name="txtApeMat">
                            </div>
                            <div class="mb-3">
                                <label for="txtEmail" class="form-label">Email</label>
                                <input type="email" class="form-control" id="txtEmail" name="txtEmail">
                            </div>
                            <div class="mb-3">
                                <label for="txtNumCel" class="form-label">Núm. Celular</label>
                                <input type="text" class="form-control" id="txtNumCel" name="txtNumCel">
                            </div>
                            <div class="mb-3">
                                <label for="cboProfesion" class="form-label">Profesión</label>
                                <select class="form-select" id="cboProfesion" name="cboProfesion">
                                    <option value="" selected>Seleccione una profesión</option>
                                    <option value="1">Ingeniero(a) de Sistemas</option>
                                    <option value="2">Ingeniero(a) de Datos</option>
                                    <option value="3">Ingeniero(a) de Software</option>
                                    <option value="4">Diseñador(a) Gráfico(a)</option>
                                    <option value="5">Licenciado(a) en Marketing</option>
                                </select>
                            </div>
                            <div class="text-center">
                                <button type="submit" name="opcion" value="reg" class="btn btn-primary">Registrar</button>
                            </div>
                            <% 
                                String mensaje = (String) request.getAttribute("mensaje");
                                if (mensaje != null && !mensaje.isEmpty()) { 
                            %>
                                <div class="alert alert-info mt-3" role="alert">
                                    <%= mensaje %>
                                </div>
                            <% } %>
                        </form>
                    </div>
                </div>
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

            $("#frmRegistroDocente").validate({
                rules: {
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
                    txtNombres: "Ingrese los nombres del docente.",
                    txtApePat: "Ingrese el apellido paterno.",
                    txtApeMat: "Ingrese el apellido materno.",
                    txtEmail: {
                        required: "Ingrese el correo electrónico.",
                        email: "Ingrese un correo válido."
                    },
                    txtNumCel: {
                        required: "Ingrese el número de celular.",
                        numericOnly: "Ingrese solo números."
                    },
                    cboProfesion: "Seleccione una profesión."
                },
                errorElement: "span",
                errorPlacement: function(error, element) {
                    error.addClass("invalid-feedback");
                    element.closest(".form-group").append(error);
                },
                highlight: function(element) {
                    $(element).addClass("is-invalid").removeClass("is-valid");
                },
                unhighlight: function(element) {
                    $(element).removeClass("is-invalid").addClass("is-valid");
                }
            });
        });
    </script>
</body>
</html>
