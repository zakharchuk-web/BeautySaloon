<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/20/2018
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <title><fmt:message key="title.registration" bundle="${rb}"/></title>
</head>
<body>
<div class="container" style="height: 100%">
    <div class="col-lg-8 col-lg-offset-2"
         style="border: 1px solid #0deaff;background-color: #edf0f4;border-radius: 5px; margin-top: 10%;">
        <div class="row text-center">
            <h3 style="margin:20px auto"><fmt:message key="registration.main" bundle="${rb}"/></h3>
        </div>
        <hr style="border: 2px solid #eeeeee; margin: 10px"/>
        <div class="row">
            <div class="col-sm-12 col-lg-12" data-effect="slide-right">
                <form class="form-horizontal" action="/MainController" method="GET">
                    <div class="form-group">
                        <label for="firstName" class="col-lg-2 control-label"><fmt:message key="registration.first_name" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="firstName" placeholder="<fmt:message key="registration.first_name"
                                                                                                   bundle="${rb}"/>"
                                   name="firstname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-lg-2 control-label"><fmt:message key="registration.last_name" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="lastName" placeholder="<fmt:message key="registration.last_name"
                                                                                                   bundle="${rb}"/>"
                                   name="lastname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label"><fmt:message key="email" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                                   placeholder="<fmt:message key="email"
                                                                                                   bundle="${rb}"/>" name="e_mail" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key="password" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="<fmt:message key="password"
                                                                                                   bundle="${rb}"/>"
                                   name="password" required>
                        </div>
                    </div>
                    <c:if test="${requestScope.isError}">
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <p style="color: red">${requestScope.errorMessage}</p>
                            </div>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="hidden" name="command" value="REGISTRATION">
                            <button type="submit" class="btn btn-default"><fmt:message key="sign_up" bundle="${rb}"/></button>
                            <a href="/index.jsp" style="float: right"><fmt:message key="registration.go_home" bundle="${rb}"/></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
