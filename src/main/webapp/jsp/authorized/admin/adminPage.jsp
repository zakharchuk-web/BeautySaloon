<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title><fmt:message key="title.admin.page" bundle="${rb}"/></title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
</head>
<body>
<div class="container" style="height: 100%">
    <div class="col-lg-8">
        <p class="h3"><fmt:message key="admin.page.hello" bundle="${rb}"/>, <c:out
                value="${sessionScope.currentUser.firstName}"/>
            <c:out value="${sessionScope.currentUser.lastName}"/></p>
        <p class="h3"><fmt:message key="email" bundle="${rb}"/>: <c:out value="${sessionScope.currentUser.email}"/></p>
        <p class="h3"><fmt:message key="admin.page.role" bundle="${rb}"/>: <c:out
                value="${sessionScope.currentUser.role}"/></p>
    </div>
    <div class="col-lg-8">
        <a class="h3" href="/jsp/authorized/admin/masterCreation.jsp"><fmt:message key="admin.page.create.master"
                                                                                   bundle="${rb}"/></a>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
