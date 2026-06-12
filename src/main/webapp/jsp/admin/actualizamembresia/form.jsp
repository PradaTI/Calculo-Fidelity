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
                    <jsp:param name="title" value="Archivo membresias"/>
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
                                    <h3 class="card-title">${edit == false ? 'Nuevo Archivo de membresias':'Editar Archivo de membresias'}</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <form method="post" action="admin/actualizamembresia/upload" class="form-horizontal" enctype="multipart/form-data" >
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Archivo</label>
                                            <div class="col-sm-9">
                                                <input type="file" class="form-control" placeholder="Archivo" name="file"/>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="button" class="btn btn-default" onclick="window.history.go(-1); return false;">
                                            Cancelar
                                        </button>
                                        <button type="submit" class="btn btn-primary float-right" >
                                            <i class="fas fa-cloud-upload-alt" ></i> Subir
                                        </button>
                                    </div>
                                    <!-- /.card-footer -->
                                </form>
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