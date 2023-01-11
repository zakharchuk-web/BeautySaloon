<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title><fmt:message key="title.comment.list" bundle="${rb}"/></title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <style>
        .comments-list .media{
            border-bottom: 1px dotted #ccc;
        }
    </style>
</head>
<body>
<div class="container" style="height: 100%">
    <div class="row">
        <div class="col-md-8">
            <div class="page-header">
                <h1><small class="pull-right">${comments.size()} <fmt:message key="comment.list.comments.small" bundle="${rb}"/>
                </small> <fmt:message key="comment.list.comments.big" bundle="${rb}"/> </h1>
            </div>
            <c:forEach items="${requestScope.comments}" var="comment">
            <div class="comments-list">
                <div class="media">
                    <div class="media-body">
                        <h4 class="media-heading user_name">${comment.user.firstName} ${comment.user.lastName}
                            <fmt:message key="comment.list.about" bundle="${rb}"/>
                                ${comment.master.firstName} ${comment.master.lastName}</h4>
                        ${comment.comment}
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
