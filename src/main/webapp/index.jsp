<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="resources/components/i18n.jsp" %>
<%@ taglib prefix="a" uri="auth" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"></c:import>
    <c:import url="resources/components/navigation.jsp"></c:import>
    <title>Title</title>
    <style>
        body,
        html {
            height: 100%;
            overflow-x: hidden
        }

        footer {
            border-top: 1px solid #ddd;
            padding: 30px;
            margin-top: 50px;
            flex: 0 0 auto;
        }

        .row > [class*=col-] {
            margin-bottom: 40px
        }

        .navbar-container {
            position: relative;
            min-height: 100px
        }

        .navbar.navbar-fixed-bottom,
        .navbar.navbar-fixed-top {
            position: absolute;
            top: 50px;
            z-index: 0
        }

        .navbar.navbar-fixed-bottom .container,
        .navbar.navbar-fixed-top .container {
            max-width: 90%
        }

        .form-inline input[type=password],
        .form-inline input[type=text],
        .form-inline select {
            width: 180px
        }
    </style>
</head>
<body>
<div class="container" style="height: 100%; margin-top: 100px;">
    <p class="h3"><fmt:message key="basic.description" bundle="${rb}"/></p>
</div>
<c:import url="resources/components/footer.jsp"></c:import>
</body>
</html>
