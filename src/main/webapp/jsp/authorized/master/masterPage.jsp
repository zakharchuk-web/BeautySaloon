<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title><fmt:message key="title.master.page" bundle="${rb}"/></title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-sm-4 ">
            <a href="#" class="thumbnail">
                <img src="/resources/images/image-placeholder.png" alt="">
            </a>
        </div>
        <div class=" col-lg-4">
            <p><fmt:message key="masterpage.first.name" bundle="${rb}"/>: <c:out
                    value="${sessionScope.currentUser.firstName}"/></p>
            <p><fmt:message key="masterpage.last.name" bundle="${rb}"/>: <c:out
                    value="${sessionScope.currentUser.lastName}"/></p>
            <p><fmt:message key="masterpage.level" bundle="${rb}"/>: <c:out
                    value="${sessionScope.currentUser.level}"/></p>
            <p><fmt:message key="masterpage.phone" bundle="${rb}"/>: <c:out
                    value="${sessionScope.currentUser.phoneNumber}"/></p>
            <p><fmt:message key="masterpage.email" bundle="${rb}"/>: <c:out
                    value="${sessionScope.currentUser.email}"/></p>
        </div>

        <div class="row">
            <div class='col-sm-6'>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker2'>
                        <input type='text' class="form-control"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker2').datetimepicker({
                        locale: 'ru'
                    });
                });
            </script>
        </div>


    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
