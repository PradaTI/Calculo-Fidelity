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
                    <jsp:param name="title" value="Clientes de Integración"/>
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
                                        <a class="btn btn-block btn-secondary" href="admin/cliente_integracion/add">Agregar Cliente Integración</a>
                                    </h3>
                                </div>
                                <div class="card-body ">
                                    <c:if test="${aviso!=null}">
                                        <div class="alert alert-${alert} alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h5><i class="icon fas fa-${icon}"></i>${aviso}</h5>
                                        </div>
                                    </c:if>
                                    <table id="clientIntegrationTable" class="table table-bordered table-striped responsive display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Cliente</th>
                                                <th>Documentos</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${clienteIntegracionList}" var="client">
                                                <tr>
                                                    <td>${client.id}</td>
                                                    <td>${client.cliente}</td>
                                                    <td>
                                                        <c:forEach items="${client.documentosPorClienteIntegracionList}" var="doc">
                                                            <h5>
                                                                <span class="badge badge-success">
                                                                    ${doc.id}.- ${doc.documento}
                                                                </span>
                                                            </h5>
                                                        </c:forEach>
                                                    </td>
                                                    <td>
                                                        <center>
                                                            <div class="btn-group">
                                                                <a href="admin/cliente_integracion/edit/${client.id}" class="btn btn-info btn-sm">
                                                                    <i class="fas fa-edit" data-toggle="tooltip" data-placement="bottom" title="Ver o editar Cliente Integración"></i>
                                                                </a>
                                                            </div>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Cliente</th>
                                                <th>Documentos</th>
                                                <th>Acciones</th>
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
                    <div class="modal fade" id="modal-delete">
                        <div class="modal-dialog">
                            <div class="modal-content bg-danger">
                                <div class="modal-header">
                                    <h4 class="modal-title">Eliminar administrador!</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <span id="delete-record-text"></span>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-xs btn-outline-light" data-dismiss="modal">No</button>
                                    <a id="action-delete" href="#" class="btn-del btn btn-xs btn-outline-light">Eliminar</a>
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
                $('#clientIntegrationTable').DataTable({
                    'paging': true,
                    'lengthChange': true,
                    'searching': true,
                    'ordering': true,
                    'info': true,
                    'autoWidth': true,
                    'processing': true
                });

                $('#modal-delete').on('show.bs.modal', function (event) {
                    var button = $(event.relatedTarget); // Button that triggered the modal
                    var recordId = button.data('record-id'); // Extract info from data-* attributes
                    var recordName = button.data('record-name');
                    var modal = $(this);
                    modal.find('#delete-record-text').text("Estas seguro de querer eliminar al administrador: " + recordName);
                    modal.find('#action-delete').attr('href', 'admin/administradores/delete/' + recordId);
                });

                $('[data-toggle="tooltip"]').tooltip()
            });
        </script>
    </body>
</html>