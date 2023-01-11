<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <title><fmt:message key="title.user.page" bundle="${rb}"/></title>
</head>
<body>
<div class="container" >
    <div class="col-lg-8">
        <p><fmt:message key="userpage.hello" bundle="${rb}"/></p>
        <p><fmt:message key="userpage.first_name" bundle="${rb}"/>: <c:out
                value="${sessionScope.currentUser.firstName}"/></p>
        <p><fmt:message key="userpage.last_name" bundle="${rb}"/>: <c:out
                value="${sessionScope.currentUser.lastName}"/></p>
        <p><fmt:message key="userpage.email" bundle="${rb}"/>: <c:out value="${sessionScope.currentUser.email}"/></p>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <c:if test="${requestScope.ifNeedComment}">
                <p><fmt:message key="userpage.please.write.about.master" bundle="${rb}"/> ${requestScope.master.firstName}
                        ${requestScope.master.lastName}. <fmt:message key="userpage.whom.you.visited.on" bundle="${rb}"/> ${requestScope.record.date}</p>
                <form action="/MainController" method="post">
                    <textarea class="form-control" rows="3" name="comment"></textarea>
                    <input type="hidden" name="masterId" value="${requestScope.master.masterId}">
                    <input type="hidden" name="recordId" value="${requestScope.record.recordId}">
                    <button type="submit" class="btn btn-primary" name="command" value="ADD_COMMENT"><fmt:message key="userpage.add.comment" bundle="${rb}"/>
                    </button>
                </form>
            </c:if>
        </div>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
