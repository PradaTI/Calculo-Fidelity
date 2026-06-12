<%-- 
    Document   : login
    Created on : Oct 29, 2019, 9:17:56 AM
    Author     : Joan D. Pineda
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <%@include file="../jspf/common/head.jspf" %>
        <%@include file="../jspf/common/common-js-pre-body.jspf" %>
        <%@include file="../jspf/common/common-css.jspf" %>
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <img src="img/logo.png" width="250" height="200" alt=""/>
            </div>
            <div class="login-box-body">
                <h4 class="login-box-msg"><b>Portal Administrativo</b></h4>
                <form:form method="post" action="">
                    <div class="form-group has-feedback">
                        <input type="text" name="username" id="username" class="form-control form-control-lg" placeholder="Email" autofocus required/>
                        <span class="glyphicon gliphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" name="password" id="password" class="form-control form-control-lg" placeholder="Contraseña" required/>
                        <span class="glyphicon gliphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <button type="submit" class="btn btn-secondary btn-block btn-lg">Iniciar sesión</button>
                    </div>
                    <c:if test="${error!=null}">
                        <div class="alert alert-danger" role="alert" style="text-align: center">
                            ${error}
                        </div>
                    </c:if>
                    <c:if test="${logout!=null}">
                        <div class="alert alert-primary" role="alert" style="text-align: center">
                            ${logout}
                        </div>
                    </c:if>
                </form:form>
            </div>
        </div>
        <script>

        </script>
    </body>
</html>
