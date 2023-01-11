<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="a" uri="auth" %>

<div class="col-sm-12 col-lg-12">
    <nav class="navbar navbar-default" style="margin-bottom: 0px" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">
                <img src="/resources/images/scissor.png" width="30" height="30" alt="">
            </a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/index.jsp"><fmt:message key="nav.home" bundle="${rb}"/> <span
                            class="sr-only">(current)</span></a>
                </li>
                <li>
                    <a href="/MainController?command=MASTER_LIST"><fmt:message key="nav.masters" bundle="${rb}"/></a>
                </li>
                <li>
                    <a href="/MainController?command=GET_PRICE_LIST"><fmt:message key="nav.price.list" bundle="${rb}"/></a>
                </li>
                <a:if-user role="admin">
                    <li>
                        <a href="/MainController?command=GET_ALL_COMMENTS"><fmt:message key="nav.comment_list"
                                                                                        bundle="${rb}"/></a>
                    </li>
                </a:if-user>
                <li class="nav-item dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="nav.choose_language"
                                                                                            bundle="${rb}"/>
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/MainController?command=LOCALIZATION&language=English"
                               onclick="history.back()"><fmt:message key="nav.language.english" bundle="${rb}"/></a>
                        </li>
                        <li><a href="/MainController?command=LOCALIZATION&language=Ukrainian"><fmt:message
                                key="nav.language.ukrainian" bundle="${rb}"/></a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <a:if-user role="none">
                    <li>
                        <a href="/jsp/login.jsp"><fmt:message key="sign_in" bundle="${rb}"/></a>
                    </li>
                    <li>
                        <a href="/jsp/registration.jsp"><fmt:message key="sign_up" bundle="${rb}"/></a>
                    </li>
                </a:if-user>
                <a:if-user role="user">
                    <li class="nav-item dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="nav.hello"
                                                                                                bundle="${rb}"/>,
                            <c:out value="${sessionScope.currentUser.firstName}"/>
                            <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/MainController?command=USER_PAGE_INFO"><fmt:message key="nav.user_page"
                                                                                              bundle="${rb}"/></a></li>
                            <li class="divider"></li>
                            <li><a href="/MainController?command=LOG_OUT"><fmt:message key="nav.logout"
                                                                                       bundle="${rb}"/></a></li>
                        </ul>
                    </li>
                </a:if-user>
                <a:if-user role="admin">
                    <li class="nav-item dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="nav.hello"
                                                                                                bundle="${rb}"/>,
                            <c:out value="${sessionScope.currentUser.firstName}"/>
                            <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/jsp/authorized/admin/adminPage.jsp"><fmt:message key="nav.admin_page"
                                                                                           bundle="${rb}"/></a></li>
                            <li class="divider"></li>
                            <li><a href="/MainController?command=LOG_OUT"><fmt:message key="nav.logout"
                                                                                       bundle="${rb}"/></a></li>
                        </ul>
                    </li>
                </a:if-user>
                <a:if-user role="master">
                    <li class="nav-item dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="nav.hello"
                                                                                                bundle="${rb}"/>,
                            <c:out value="${sessionScope.currentUser.firstName}"/>
                            <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/jsp/authorized/master/masterPage.jsp"><fmt:message key="nav.master_page"
                                                                                             bundle="${rb}"/></a></li>
                            <li class="divider"></li>
                            <li><a href="/MainController?command=LOG_OUT"><fmt:message key="nav.logout"
                                                                                       bundle="${rb}"/></a></li>
                        </ul>
                    </li>
                </a:if-user>
            </ul>
        </div>
    </nav>
</div>


<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <ul class="navbar-nav mr-auto">
        <a class="navbar-brand" href="/index.jsp">
            <img src="/resources/images/scissor.png" width="30" height="30" alt="">
        </a>

        <li class="nav-item">
            <a class="nav-link" href="/index.jsp"><fmt:message key="nav.home" bundle="${rb}"/> <span
                    class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#"><fmt:message key="nav.masters" bundle="${rb}"/></a>
        </li>
        <a:if-user role="admin">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/admin/commentList.jsp">Comments list</a>
            </li>
        </a:if-user>
        <li class="nav-item dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown</a>
            <ul class="dropdown-menu">
                <li><a href="/MainController?command=LOCALIZATION&language=English" onclick="history.back()">English</a>
                </li>
                <li><a href="/MainController?command=LOCALIZATION&language=Ukrainian">Ukrainian</a></li>
            </ul>
        </li>
        &lt;%&ndash;<c:if test="${sessionScope.currentUser.role }">
            <a class="nav-link" href="#">Role test</a>
        </c:if>&ndash;%&gt;

    </ul>
    <ul class="nav navbar-nav navbar-right">
        <a:if-user role="none">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/login.jsp">Sign in</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/registration.jsp">Sign up</a>
            </li>
        </a:if-user>
        <a:if-user role="user">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/user/userPage.jsp">User page</a>
            </li>
            <li class="nav-item ">
                <div class="btn-group">
                    <button class="btn dropdown-toggle btn-default" data-toggle="dropdown">Hello <c:out
                            value="${sessionScope.currentUser.firstName}"/></button>
                    <ul class="dropdown-menu">
                        <li><a href="/jsp/user/userPage.jsp">User page</a></li>
                        <li><a href="/MainController?command=LOG_OUT">Log out</a></li>
                        <li class="divider"></li>
                    </ul>
                </div>
            </li>
        </a:if-user>
        <a:if-user role="admin">
            <li class="nav-item ">
                <a class="nav-link" href="/jsp/admin/adminPage.jsp">Admin page</a>
            </li>
        </a:if-user>
    </ul>

</nav>--%>
