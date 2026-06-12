<%-- 
    Document   : Dashboard <Master>
    Created on : Nov 11, 2019, 10:57:16 AM
    Author     : Joan D. Pineda <TWC>
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

    <head>
        <%@include file="../../jspf/common/head.jspf" %>
        <%@include file="../../jspf/common/common-js-pre-body.jspf" %>
        <%@include file="../../jspf/common/common-css.jspf" %>
    </head>
    <body class="hold-transition sidebar-mini layout-navbar-fixed">

        <!-- Site wrapper -->
        <div class="wrapper">

            <jsp:include page="../../jspf/template-based/main-header.jspf" flush="false">
                <jsp:param name="dateF" value="${dateF}"/>
            </jsp:include>
            <!-- ./main-header -->
            <!-- =============================================== -->
            <jsp:include page="../../jspf/template-based/main-sidebar-admin.jspf" flush="false">
                <jsp:param name="user" value="${administrador}"/>
                <jsp:param name="url" value="${url}"/>
            </jsp:include>
            <!-- ./main-sidebar -->
            <!-- =============================================== -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">

                <!-- PARTICULAR CONTENT BY PAGE ********************* -->

                <!-- Content Header (Page header) -->

                <jsp:include page="../../jspf/template-based/content-header.jspf" flush="false">
                    <jsp:param name="title" value="Dashboard"/>
                    <jsp:param name="subtitle" value="Estadisticas"/>
                </jsp:include>
                <!-- /.content-header -->

                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <!-- Small boxes (Stat box) -->
<!--                        <div class="row">
                            <div class="col-lg-3 col-6">
                                 small box 
                                <div class="small-box bg-info">
                                    <div class="inner">
                                        <h3>${numeroAdministradores}</h3>

                                        <p>Administradores</p>
                                    </div>
                                    <div class="icon">
                                        <i class="fas fa-users-cog"></i>
                                    </div>
                                    <a href="admin/administradores/lista" class="small-box-footer">Más información <i class="fas fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                             ./col 
                            <div class="col-lg-3 col-6">
                                 small box 
                                <div class="small-box bg-success">
                                    <div class="inner">
                                        <h3>${usuariosAndroid}</h3>

                                        <p>Usuarios Android</p>
                                    </div>
                                    <div class="icon">
                                        <i class="fab fa-android"></i>
                                    </div>
                                    <a href="admin/usuarios/lista?device=android" class="small-box-footer">Más información <i class="fas fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                             ./col 
                            <div class="col-lg-3 col-6">
                                 small box 
                                <div class="small-box bg-secondary">
                                    <div class="inner">
                                        <h3>${usuariosIos}</h3>

                                        <p>Usuarios iOS</p>
                                    </div>
                                    <div class="icon">
                                        <i class="fab fa-apple"></i>
                                    </div>
                                    <a href="admin/usuarios/lista?device=ios" class="small-box-footer">Más información <i class="fas fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                             ./col 
                            <div class="col-lg-3 col-6">
                                 small box 
                                <div class="small-box bg-primary">
                                    <div class="inner">
                                        <h3>${usuariosAndroidIos}</h3>

                                        <p>Usuarios iOS y Android</p>
                                    </div>
                                    <div class="icon">
                                        <i class="fas fa-mobile-alt"></i>
                                    </div>
                                    <a href="admin/usuarios/lista?device=android_ios" class="small-box-footer">Más información <i class="fas fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                             ./col 
                        </div>-->
                        <!-- /.row -->
                    </div>
                </section>
                <!-- /.content -->
                <!-- /.END PARTICULAR CONTENT BY PAGE ********************* -->
            </div>
            <!-- /.content-wrapper -->
            <!-- =============================================== -->
            <%@include file="../../jspf/template-based/main-footer.jspf" %>
            <!-- /.main-footer -->
        </div>
        <!-- ./wrapper -->
        <%@include file="../../jspf/common/common-js-post-body.jspf" %>
        <!-- put below here specific JS code required by this page -->
    </body>

</html>