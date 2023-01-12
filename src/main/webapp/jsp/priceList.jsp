<%@ taglib prefix="a" uri="auth" %>
<%--
   To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title><fmt:message key="title.price.list" bundle="${rb}"/></title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
</head>
<body>
<div class="container" style="height: 100%">
    <div class="row">
        <div class="col-lg-offset-2 col-lg-6 ">
            <table class="table table-bordered" data-effect="fade">
                <thead>
                <tr>
                    <th style="text-align: center"><fmt:message key="price.list.service" bundle="${rb}"/></th>
                    <th style="text-align: center"><fmt:message key="price.list.price" bundle="${rb}"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.prices}" var="price">
                    <tr class="text-center">
                        <td>${price.serviceName}</td>
                        <td>${price.servicePrice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <a:if-user role="admin">
            <div class="col-lg-4 " data-effect="slide-right">
                <form class="form-horizontal" action="/MainController" method="get">
                    <div class="form-group">
                        <input type="text" placeholder="Service name" name="serviceName"/>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Service price" name="servicePrice"/>
                    </div>
                    <button type="submit" class="btn btn-primary" name="command" value="ADD_SERVICE_PRICE">
                        <fmt:message key="price.list.add.price" bundle="${rb}"/>
                    </button>
                </form>
            </div>
        </a:if-user>

    </div>
</div>
<c:import url="/resources/components/footer.jsp"/>
</body>
</html>
