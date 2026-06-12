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
                    <jsp:param name="title" value="Log de clientes"/>
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
                                    <h3 class="card-title float-left" >
                                        Filtros
                                    </h3>
                                </div>
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Clave cliente:</label>
                                                <div class="col-sm-9">
                                                    <input id="claveClienteBusqueda" type="text" class="form-control" placeholder="Clave cliente"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="form-group row">
                                                <button id="botonBuscar" class="btn btn-primary col-sm-12">Buscar</button>
                                            </div>
                                            <div class="form-group row">
                                                <button id="botonLimpiar" class="btn btn-default col-sm-12">Limpiar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
<!--                                <div class="card-footer">
                                    <div class="form-group row">
                                        <label id="textoRespuesta" class="col-sm-12 col-form-label" style="text-align: center; color: #ac145a">

                                        </label>
                                    </div>
                                </div>-->
                            </div>
                            <!-- /.Card -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                    <!-- row -->
                    <div class="row">
                        <!-- col -->
                        <div class="col-12">
                            <!-- Card-->
                            <div class="card">
                                <div class="card-header " >
                                    <h3 class="card-title">
                                        Resultados Encontrados
                                    </h3>
                                </div>
                                <div class="card-body ">
                                    <table id="LogClientTable" class="table table-bordered table-striped responsive display" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID_LOG</th>
                                                <th>ID CLIENTE</th>
                                                <th>EMAIL</th>
                                                <th>TELEFONO</th>
                                                <th>CLIENTE</th>
                                                <th>NIVEL</th>
                                                <th>GENERO</th>
                                                <th>APP FIDELITY</th>
                                                <th>FECHA DESCARGA APP</th>
                                                <th>FECHA MODIFICACIÓN</th>
                                            </tr>
                                        </thead>
                                        <tbody id="contenedorDataTable">

                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>ID_LOG</th>
                                                <th>ID CLIENTE</th>
                                                <th>EMAIL</th>
                                                <th>TELEFONO</th>
                                                <th>CLIENTE</th>
                                                <th>NIVEL</th>
                                                <th>GENERO</th>
                                                <th>APP FIDELITY</th>
                                                <th>FECHA DESCARGA APP</th>
                                                <th>FECHA MODIFICACIÓN</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                                <!--                                <div class="card-footer">
                                                                    <button type="button" class="btn btn-primary float-right" >
                                                                        <i class="fas fa-not-equal" ></i> Comparar
                                                                    </button>
                                                                </div>-->
                                <!-- /.card-footer -->
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

            $("#botonBuscar").click(function () {
                clave = $("#claveClienteBusqueda").val();
                if (clave) {
                    $("#contenedorDataTable").html("");
                    ajaxResult = null;
                    $.ajax({
                        url: "api/buscarlogscliente?clave=" + clave,
                        type: 'POST',
                        async: false,
                        success: function (data, textStatus, jqXHR) {
                            ajaxResult = data;
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.log(errorThrown);
                            ajaxResult = null;
                        }
                    });
                    if (ajaxResult !== null) {
                        if (ajaxResult.length > 0) {
                            innerHtml2 = '';
                            for (i = 0; i < ajaxResult.length; i++) {
                                innerHtml2 += '<tr>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].id + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli01 + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli05 + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli04 + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli02 + ' ' + ajaxResult[i].cli03 + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli06 + '</td>';
                                innerHtml2 += '                    <td>' + ajaxResult[i].cli07 + '</td>';
                                if(ajaxResult[i].cli45 == 1) {//DESCARGO APP
                                    innerHtml2 += '                    <td>SI</td>';
                                    innerHtml2 += '                    <td>' + convertTZ(ajaxResult[i].cli46, "America/Mexico_City") + '</td>';
                                } else { //NO DESCARGO APP
                                    innerHtml2 += '                    <td>NO</td>';
                                    innerHtml2 += '                    <td> --- </td>';
                                }
                                innerHtml2 += '                    <td>' + convertTZ(ajaxResult[i].fechaModificacion, "America/Mexico_City") + '</td>';
                                innerHtml2 += '                </tr>';
                            }
                            $("#contenedorDataTable").html(innerHtml2);
                        } else {
                            Swal.fire({
                            title: 'Sin resultados',
                            text: 'No se encontraron resultados para la clave' + clave,
                            icon: 'error'
                        });
                        }
                    } else {
                        Swal.fire({
                            title: 'Error al buscar logs',
                            text: 'Ocurrio un error al tratar de consultar los logs del cliente',
                            icon: 'error'
                        });
                        return false;
                    }
                } else {
                    Swal.fire({
                        title: 'Sin datos para buscar',
                        text: 'Favor de escribir una clave de ciente para poder realizar la busqueda',
                        icon: 'error'
                    });
//                    Swal.fire({
//                        title: 'Please Wait !',
//                        html: 'data uploading', // add html attribute if you want or remove
//                        allowOutsideClick: false,
//                        onBeforeOpen: () => {
//                            Swal.showLoading();
//                        }
//                    });
                }
            });
            
            $("#botonLimpiar").click(function () {
                $("#claveClienteBusqueda").val("");
                $("#contenedorDataTable").html("");
            });

            function convertTZ(date, tzString) {
                return new Date((typeof date === "string" ? new Date(date) : date).toLocaleString("en-US", {timeZone: tzString}));
            }

        </script>
    </body>
</html>