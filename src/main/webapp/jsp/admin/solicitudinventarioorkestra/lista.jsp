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
                    <jsp:param name="title" value="Solicitudes de inventario orkestra"/>
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
                                        <a class="btn btn-sm btn-success" href="admin/solicitudinventarioorkestra/lista">
                                            <i class="fas fa-sync-alt"></i>
                                        </a>
                                        <a class="btn btn-sm btn-success" href="admin/solicitudinventarioorkestra/agregar">
                                            <i class="far fa-plus-square"></i>
                                        </a>
                                    </h3>
                                </div>
                                <div class="card-body table-responsive">
                                    <c:if test="${aviso!=null}">
                                        <div class="alert alert-${alert} alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h5><i class="icon fas fa-${icon}"></i>${aviso}</h5>
                                        </div>
                                    </c:if>
                                    <table id="solicitudesTable" class="table table-bordered table-striped table-hover" style="width:100%">
                                        <thead>
                                            <tr class="text-center">
                                                <th>Solicitud</th>
                                                <th>Filtros</th>
                                                <th>Resumen</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody class="text-center">
                                            <c:forEach items="${solicitudesList}" var="solicitud">
                                                <tr class="text-sm">
                                                    <td>
                                                        <b>Usuario:</b> ${solicitud.administrador.nombre} ${solicitud.administrador.apellidos}<br>
                                                        <b>Fecha:</b> ${seguridad.getFormatedDateTimeWhitFormat(solicitud.fechaSolicitud, "dd/MM/YYYY HH:mm:ss")}<br>
                                                        <b>Orkestra:</b> ${solicitud.orkestra == 1 ? "Boutiques" : solicitud.orkestra == 2 ? "Outlets" : "---"}<br>
                                                        <b>Estatus:</b> ${solicitud.estatus == 1 ? "Ejecutandoce" : solicitud.estatus == 2 ? "Error" : solicitud.estatus == 3 ? "Finalizado" : ""}
                                                    </td>
                                                    <td>
                                                        <b>Filtro nombre:</b> ${solicitud.filtroNombre != null ? solicitud.filtroNombre : "---"}<br>
                                                        <b>Filtro fecha I:</b> ${solicitud.filtroFechaInicio != null ? seguridad.getFormatedDateTimeWhitFormat(solicitud.filtroFechaInicio, "dd/MM/YYYY HH:mm:ss") : "---"}<br>
                                                        <b>Filtro fecha F:</b> ${solicitud.filtroFechaFin != null ? seguridad.getFormatedDateTimeWhitFormat(solicitud.filtroFechaFin, "dd/MM/YYYY HH:mm:ss") : "---"}
                                                    </td>
                                                    <td>
                                                        <div class="progress progress active">
                                                            <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="${solicitud.porcentajeProcesado}" aria-valuemin="0" aria-valuemax="100" style="width: ${solicitud.porcentajeProcesado}%">
                                                                <span class="sr-only">${solicitud.porcentajeProcesado}% Completado</span>
                                                            </div>
                                                        </div>
                                                        <b>Porcentaje:</b> ${solicitud.porcentajeProcesado}%<br>
                                                        <b>Paginas totales:</b> ${solicitud.paginasTotales != null ? solicitud.paginasTotales : "---"}<br>
                                                        <b>Paginas procesadas:</b> ${solicitud.paginasProcesadas != null ? solicitud.paginasProcesadas : "---"}<br>
                                                        <b>Padres totales:</b> ${solicitud.padresTotales != null ? solicitud.padresTotales : "---"}<br>
                                                        <b>Padres procesados:</b> ${solicitud.padresProcesados != null ? solicitud.padresProcesados : "---"}<br>
                                                    </td>
                                                    <td class="text-center">
                                                        <div class="btn-group justify-content-md-center">
                                                            <c:if test="${solicitud.archivoGenerado != null && solicitud.estatus == 3}">
                                                                <a type="button" class="btn btn-success" href="admin/solicitudinventarioorkestra/descargar?idSolicitud=${solicitud.id}">
                                                                    <i class="fas fa-file-download"></i>
                                                                </a>
                                                            </c:if>
                                                            <c:if test="${solicitud.logsSolicitudDescargaInventarioOrkestraList != null && solicitud.logsSolicitudDescargaInventarioOrkestraList.size() > 0 && solicitud.estatus == 2}">
                                                                <a type="button" class="btn btn-success" href="admin/solicitudinventarioorkestra/logs?idSolicitud=${solicitud.id}">
                                                                    <i class="fas fa-list-ul"></i>
                                                                </a>
                                                            </c:if>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr class="text-center">
                                                <th>Solicitud</th>
                                                <th>Filtros</th>
                                                <th>Resumen</th>
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
                $('#solicitudesTable').DataTable({
                    'paging': true,
                    'lengthChange': true,
                    'searching': true,
                    'ordering': false,
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
                    modal.find('#action-import').attr('href', 'admin/actualizamembresia/import/' + recordId);
                });

                $('[data-toggle="tooltip"]').tooltip()
            });
        </script>
    </body>
</html>