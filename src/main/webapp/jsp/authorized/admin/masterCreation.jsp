<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/scripts.jsp"/>
    <title><fmt:message key="title.master.creation" bundle="${rb}"/></title>
</head>
<body>
<div class="container">
    <div class="col-lg-8"
         style="border: 1px solid #0deaff;background-color: #edf0f4;border-radius: 5px; margin: 10% auto;">
        <div class="row">
            <h3 style="margin:20px auto"><fmt:message key="registration.main" bundle="${rb}"/></h3>
        </div>
        <hr style="border: 2px solid #eeeeee; margin: 10px"/>
        <div class="row">
            <div class="col-sm-12 col-lg-12" data-effect="slide-right">
                <form class="form-horizontal" action="/MainController" method="POST">
                    <div class="form-group">
                        <label for="firstName" class="col-lg-2 control-label"> <fmt:message key="registration.first_name" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="firstName" placeholder="<fmt:message key="registration.first_name" bundle="${rb}"/>"
                                   name="firstname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-lg-2 control-label"><fmt:message key="registration.last_name" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="lastName" placeholder="<fmt:message key="registration.last_name" bundle="${rb}"/>"
                                   name="lastname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="chooseLevel" class="col-lg-2 control-label"><fmt:message key="registration.level" bundle="${rb}"/></label>
                        <div class="col-lg-6">
                            <select class="form-control" id="chooseLevel" name="level">
                                <option value="beginner"><fmt:message key="level.beginner" bundle="${rb}"/></option>
                                <option value="middle"><fmt:message key="level.middle" bundle="${rb}"/></option>
                                <option value="master"><fmt:message key="level.master" bundle="${rb}"/></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber" class="col-lg-2 control-label"><fmt:message key="registration.phone" bundle="${rb}"/></label>
                        <div class="col-lg-6">
                            <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="<fmt:message key="registration.phone.pattern" bundle="${rb}"/>"
                                   required>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label"><fmt:message key="email" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                                   placeholder="<fmt:message key="email" bundle="${rb}"/>" name="e_mail" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key="password" bundle="${rb}"/></label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="inputPassword" placeholder="<fmt:message key="password" bundle="${rb}"/>"
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
                            <input type="hidden" name="command" value="CREATE_MASTER">
                            <button type="submit" class="btn btn-default"><fmt:message key="create.master" bundle="${rb}"/></button>
                            <a href="/index.jsp" style="float: right"><fmt:message key="to.home" bundle="${rb}"/></a>
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
