<%@ taglib prefix="a" uri="auth" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/22/2018
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <title><fmt:message key="title.make.record" bundle="${rb}"/></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-sm-4 ">
            <a href="#" class="thumbnail">
                <img src="/resources/images/master.jpg" alt="">
            </a>
            <h3><fmt:message key="master.list.master_info" bundle="${rb}"/></h3>
            <p><fmt:message key="master.list.master_name"
                            bundle="${rb}"/>: ${requestScope.master.firstName} ${requestScope.master.lastName}</p>
            <p><fmt:message key="master.list.level" bundle="${rb}"/>: ${requestScope.master.level}</p>
            <p><fmt:message key="master.list.phone_number" bundle="${rb}"/>: ${requestScope.master.phoneNumber}</p>
        </div>
        <form action="/MainController" method="get">
            <div class="col-lg-2">
                <div class="form-group">

                    <input type="hidden" name="masterEmail" value="${requestScope.master.email}">
                    <input class="form-control" type="date" name="chosenDate" value="${date}" id="example-date-input"
                           min="${today}">
                    <input type="hidden" name="masterEmail"
                           value="${requestScope.master.email}"/>
                    <button type="submit" class="btn btn-primary" name="command" value="GET_RECORDS_FOR_DATE">
                        <fmt:message key="make.record.choose.date" bundle="${rb}"/>
                    </button>

                </div>
            </div>
            <c:if test="${requestScope.records!=null}">
                <div class="col-sm-6 col-lg-6">
                    <p class="lead text-muted"><fmt:message key="make.record.schedule" bundle="${rb}"/></p>
                    <table class="table table-bordered text-center" data-effect="fade">
                        <thead>
                        <tr>
                            <th style="text-align: center"><fmt:message key="make.record.time" bundle="${rb}"/></th>
                            <th style="text-align: center"><fmt:message key="make.record.place" bundle="${rb}"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <input type="hidden" name="timeFrom" value="${i+9}:00" id="myHiddenTime"/>
                        <c:forEach var="i" begin="0" end="9" varStatus="loop">
                            <tr>
                                <td>${i+9}:00</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${requestScope.records[i]!=null}">
                                            <a:if-user role="admin">
                                                <a class="btn btn-block disabled btn-default"
                                                   href="#"><fmt:message key="make.record.occupied.by"
                                                                         bundle="${rb}"/> ${requestScope.records[i].user.firstName} ${requestScope.records[i].user.lastName }</a>
                                            </a:if-user>
                                            <a:if-user role="master">
                                                <a class="btn btn-block disabled btn-default"
                                                   href="#"><fmt:message key="make.record.occupied.by"
                                                                         bundle="${rb}"/> ${requestScope.records[i].user.firstName} ${requestScope.records[i].user.lastName }</a>
                                            </a:if-user>
                                            <a:if-user role="user">
                                                <a class="btn btn-block disabled btn-default"
                                                   href="#"><fmt:message key="make.record.busy" bundle="${rb}"/></a>
                                            </a:if-user>
                                        </c:when>
                                        <c:when test="${requestScope.records[i]==null}">
                                            <%--<input type="hidden" name="timeFrom" value="${i+9}:00"/>--%>

                                            <button type="submit" class="btn btn-block  btn-default" name="command"
                                                    value="CREATE_RECORD"
                                                    onclick="document.getElementById('myHiddenTime').setAttribute('value','${i+9}:00')">
                                                <fmt:message key="make.record.free" bundle="${rb}"/>
                                            </button>
                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </form>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
