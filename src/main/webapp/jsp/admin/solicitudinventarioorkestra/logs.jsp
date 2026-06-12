<%-- 
    Document   : Dashboard <Master>
    Created on : Diciembre 01, 2019, 10:57:16 AM
    Author     : Fabian Fonseca Sandoval <TWC>
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <%@include file="../../../jspf/common/head.jspf" %>
        <%@include file="../../../jspf/common/common-js-pre-body.jspf" %>
        <%@include file="../../../jspf/common/common-css.jspf" %>

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
                    <jsp:param name="title" value="Logs solicitud: ${idSolicitud}"/>
                    <jsp:param name="subtitle" value="Lista"/>
                </jsp:include>
                <!-- /.content-header -->
                <!-- Main content -->
                <section class="content">
                    <!-- row -->
                    <div class="row">
                        <!-- col -->
                        <div class="col-12">

                            <!-- Card-->

                            <div class="card">

                                <div class="card-header " >
                                    <h3 class="card-title float-right" >
                                        <button type="button" class="btn btn-sm btn-success" onclick="window.history.go(-1); return false;">
                                            <i class="fas fa-arrow-circle-left"></i>
                                        </button>
                                    </h3>
                                </div>
                                <div class="card-body table-responsive">
                                    <table id="logsTable" class="table table-bordered table-striped table-hover" style="width:100%">
                                        <thead>
                                            <tr class="text-center">
                                                <th>Log</th>
                                                <th>Descripcion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${logsList}" var="log">
                                                <tr class="text-sm">
                                                    <td class="text-center">
                                                        <b>Pagina:</b> ${log.pagina}<br>
                                                        <b>Padre:</b> ${log.padre}<br>
                                                        <b>Hijo:</b> ${log.hijo}<br>
                                                        <b>Fecha:</b> ${seguridad.getFormatedDateTimeWhitFormat(log.fecha, "dd/MM/YYYY HH:mm:ss")}
                                                    </td>
                                                    <td>
                                                        ${log.descripcionError}
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr class="text-center">
                                                <th>Log</th>
                                                <th>Descripcion</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.Card -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
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
        <script>

            $(function () {
                $('#logsTable').DataTable({
                    'paging': true,
                    'lengthChange': true,
                    'searching': true,
                    'ordering': false,
                    'info': true,
                    'autoWidth': true,
                    'processing': true
                });
            });
        </script>
    </body>
</html>