<%-- 
    Document   : Dashboard <Master>
    Created on : Diciembre 01, 2019, 10:57:16 AM
    Author     : Fabian Fonseca Sandoval <TWC>
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <%@include file="../../../jspf/common/head.jspf" %>
        <%@include file="../../../jspf/common/common-js-pre-body.jspf" %>
        <%@include file="../../../jspf/common/common-css.jspf" %>
        <link rel="stylesheet" href="webjars/summernote/summernote-bs4.css">
    </head>
    <body class="hold-transition sidebar-mini layout-navbar-fixed">

        <!-- Site wrapper -->
        <div class="wrapper">
            <!--Main Header-->
            <jsp:include page="../../../jspf/template-based/main-header.jspf" flush="false">
                <jsp:param name="dateF" value="${dateF}"/>
            </jsp:include>
            <!-- ./main-header -->

            <!--Main-Sidebar-admin-->
            <jsp:include page="../../../jspf/template-based/main-sidebar-admin.jspf" flush="false">
                <jsp:param name="user" value="${administrador}"/>
                <jsp:param name="url" value="${url}"/>
            </jsp:include>
            <!-- ./Main-sidebar-admin-->

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <jsp:include page="../../../jspf/template-based/content-header.jspf" flush="false">
                    <jsp:param name="title" value="Nueva solicitud de descarga de inventario"/>
                    <jsp:param name="subtitle" value="Formulario"/>
                </jsp:include>
                <!-- /.content-header -->
                <!-- Main content -->
                <section class="content">
                    <!-- general form elements disabled -->
                    <div class="row justify-content-center">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header bg-primary">
                                    <h3 class="card-title">Nueva solicitud de descarga de inventario de orkestra</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form:form method="post" modelAttribute="solicitud" class="form-horizontal">
                                    <div class="card-body">
                                        <form:hidden path="id"/>
                                        <form:hidden path="administrador"/>
                                        <form:hidden path="fechaSolicitud"/>
                                        <form:hidden path="estatus"/>
                                        <form:hidden path="paginasTotales"/>
                                        <form:hidden path="paginasProcesadas"/>
                                        <form:hidden path="padresTotales"/>
                                        <form:hidden path="padresProcesados"/>
                                        <form:hidden path="porcentajeProcesado"/>
                                        <form:hidden path="archivoGenerado"/>

                                        <div class="form-group row">
                                            <label for="orkestra" class="col-sm-4 col-form-label text-gray">Orkestra</label>
                                            <div class="col-sm-8">
                                                <form:select path="orkestra" class="form-control" >
                                                    <form:option value="0" label="Selecciona un orkestra"/>
                                                    <form:option value="1" label="Boutiques"/>
                                                    <form:option value="2" label="Outlets"/>
                                                </form:select>
                                            </div>
                                            <div class="col-sm-8 offset-sm-4 float-right"><form:errors path="orkestra" class="text-danger"/></div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="filtroNombre" class="col-sm-4 col-form-label text-gray">Filtro estilo</label>
                                            <div class="col-sm-8">
                                                <form:input path="filtroNombre" type="text" class="form-control" placeholder="Ejemplo: 600012 24CB4AMA"/>
                                            </div>
                                            <div class="col-sm-8 offset-sm-4 float-right"><form:errors path="filtroNombre" class="text-danger"/></div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="filtroFechaInicio" class="col-sm-4 col-form-label text-gray">Filtro fecha inicio</label>
                                            <div class="col-sm-8">
                                                <form:input path="filtroFechaInicio" type="date" class="form-control"/>
                                            </div>
                                            <div class="col-sm-8 offset-sm-4 float-right"><form:errors path="filtroFechaInicio" class="text-danger"/></div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <label for="filtroFechaFin" class="col-sm-4 col-form-label text-gray">Filtro fecha fin</label>
                                            <div class="col-sm-8">
                                                <form:input path="filtroFechaFin" type="date" class="form-control"/>
                                            </div>
                                            <div class="col-sm-8 offset-sm-4 float-right"><form:errors path="filtroFechaFin" class="text-danger"/></div>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="button" class="btn btn-default" onclick="window.history.go(-1); return false;">
                                            Cancelar
                                        </button>
                                        <button type="submit" class="btn btn-primary float-right" >
                                            <i class="far fa-save" ></i> Guardar
                                        </button>
                                    </div>
                                    <!-- /.card-footer -->
                                </form:form>
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <!-- main-footer -->
            <%@include file="../../../jspf/template-based/main-footer.jspf" %>
            <!-- /.main-footer -->
        </div>
        <!-- ./wrapper -->
        <%@include file="../../../jspf/common/common-js-post-body.jspf" %>
        <!-- put below here specific JS code required by this page -->
        <!--        <script src="webjars/bs-custom-file-input/dist/bs-custom-file-input.min.js"></script>
                <script src="webjars/summernote/summernote-bs4.min.js"></script>
                <script src="webjars/momentjs/min/moment.min.js"></script>
                <script src="webjars/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
                <script src="webjars/moment-timezone/moment-timezone-with-data.js"></script>
                <script>
                    
                </script>-->
    </body>
</html>