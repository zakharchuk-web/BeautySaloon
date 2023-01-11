<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/18/2018
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"></c:import>
    <c:import url="/resources/components/navigation.jsp"/>
    <title><fmt:message key="title.login" bundle="${rb}"/></title>
</head>
<body>
<div class="container" style="height: 100%">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 "
             style="border: 1px solid #0deaff;background-color: #edf0f4;border-radius: 5px; margin-top: 10%;">
            <div class="row text-center">
                <h3 style="margin:20px auto"><fmt:message key="login.main" bundle="${rb}"/></h3>
            </div>
            <hr style="border: 2px solid #eeeeee; margin: 10px"/>
            <div class="row">
                <div class="col-sm-12 col-lg-12" data-effect="slide-right">
                    <form class="form-horizontal" action="/MainController" method="POST">
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label"><fmt:message key="email"
                                                                                                bundle="${rb}"/></label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                                       placeholder="<fmt:message key="email"
                                                                                                   bundle="${rb}"/>" name="e_mail">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key="password"
                                                                                                   bundle="${rb}"/></label>
                            <div class="col-lg-10">
                                <input type="password" class="form-control" id="inputPassword" placeholder="<fmt:message key="password"
                                                                                                   bundle="${rb}"/>"
                                       name="password">
                            </div>
                        </div>
                        <c:if test="${requestScope.isError}">
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <p style="color: red">${requestScope.errorMessage}</p>
                                </div>
                            </div>
                        </c:if>
                        <div class="col-lg-offset-2 col-lg-10">
                            <label>
                                <p><fmt:message key="login.dont_have_account_question" bundle="${rb}"/>
                                    <a href="registration.jsp"><fmt:message key="login.create_account"
                                                                            bundle="${rb}"/></a>
                                </p>
                            </label>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <input type="hidden" name="command" value="AUTHORIZATION">
                                <button type="submit" class="btn btn-default"><fmt:message key="sign_in"
                                                                                           bundle="${rb}"/></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
