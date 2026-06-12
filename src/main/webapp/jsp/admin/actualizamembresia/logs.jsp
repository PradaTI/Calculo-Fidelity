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
                    <jsp:param name="title" value="Logs de Archivo ${file.id}.- ${file.originalName}"/>
                    <jsp:param name="subtitle" value="Lista logs"/>
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
<!--                                        <a class="btn btn-block btn-secondary" href="admin/actualizamembresia/add">Nuevo Archivo</a>-->
                                    </h3>
                                </div>
                                <div class="card-body ">
                                    <c:if test="${aviso!=null}">
                                        <div class="alert alert-${alert} alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h5><i class="icon fas fa-${icon}"></i>${aviso}</h5>
                                        </div>
                                    </c:if>
                                    <table id="logsTable" class="table table-bordered table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID LOG</th>
                                                <th>Archivo</th>
                                                <th>Fecha Log</th>
                                                <th>Log</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${logsList}" var="log">
                                                <tr>
                                                    <td>${log.id}</td>
                                                    <td>${file.id}.- ${file.originalName}</td>
                                                    <td>
                                                        ${log.date}
                                                    </td>
                                                    <td>
                                                        ${log.log}
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>ID LOG</th>
                                                <th>Archivo</th>
                                                <th>Fecha Log</th>
                                                <th>Log</th>
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
                    <div id="loading-ajax" style="display:none"></div>
                    <div class="modal fade" id="modal-import">
                        <div class="modal-dialog">
                            <div class="modal-content bg-primary">
                                <div class="modal-header">
                                    <h4 class="modal-title">Importar archivo</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h4><span id="import-record-text"></span></h4>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-xs btn-outline-light" data-dismiss="modal">Cancelar</button>
                                    <a id="action-import" href="#" class="btn-del btn btn-xs btn-outline-light">Si, importar</a>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
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
        <script>

            $(function () {
                $('#fileTelefonoTable').DataTable({
                    'paging': true,
                    'lengthChange': true,
                    'searching': true,
                    'ordering': true,
                    'info': true,
                    'autoWidth': true,
                    'processing': true
                });

                $('#modal-import').on('show.bs.modal', function (event) {
                    var button = $(event.relatedTarget); // Button that triggered the modal
                    var recordId = button.data('record-id'); // Extract info from data-* attributes
                    var recordName = button.data('record-name');
                    var modal = $(this);
                    modal.find('#import-record-text').text("Estas seguro de querer importar el archivo con el id: " + recordId + " y el nombre: " + recordName);
                    modal.find('#action-import').attr('href', 'admin/actualizarnumerostelefono/import/' + recordId);
                });

                $('[data-toggle="tooltip"]').tooltip()
            });
        </script>
    </body>
</html>