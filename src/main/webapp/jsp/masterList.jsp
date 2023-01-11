<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/22/2018
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title><fmt:message key="title.master.list" bundle="${rb}"/></title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
</head>
<body>
<div class="container">
    <c:forEach items="${requestScope.masters}" var="master">
        <div class="col-lg-4 col-sm-4 ">
            <div class="thumbnail">
                <img src="/resources/images/master.jpg" alt="">
                <div class="caption">
                    <h3><fmt:message key="master.list.master_info" bundle="${rb}"/></h3>
                    <p><fmt:message key="master.list.master_name"
                                    bundle="${rb}"/>: ${master.firstName} ${master.lastName}</p>
                    <p><fmt:message key="master.list.level" bundle="${rb}"/>: ${master.level}</p>
                    <p><fmt:message key="master.list.phone_number" bundle="${rb}"/>: ${master.phoneNumber}</p>
                    <p style="height: 40px">${master.description}</p>
                    <p>
                    <form action="/MainController" method="GET">
                        <input type="hidden" name="masterEmail" value="${master.email}">
                        <c:if test="${sessionScope.currentUser!=null}">
                            <button type="submit" class="btn btn-primary" name="command"
                                    value="REDIRECT_TO_RECORD_COMMAND">
                                <fmt:message key="master.list.enroll" bundle="${rb}"/>

                            </button>
                        </c:if>
                    </form>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
    <%-- <div class="container">
         <div class="row">
             <div class='col-sm-6'>
                 <div class="form-group">
                     <div class='input-group date' id='datetimepicker1'>
                         <input type='text' class="form-control"/>
                         <span class="input-group-addon">
                         <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                     </div>
                 </div>
             </div>
             <script type="text/javascript">
                 $(function () {
                     $('#datetimepicker1').datetimepicker();
                 });
             </script>
         </div>
     </div>--%>
</div>
<c:import url="/resources/components/footer.jsp"></c:import>
</body>
</html>
