<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 1/21/2018
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/components/i18n.jsp" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/resources/components/dependencies.jsp"/>
    <c:import url="/resources/components/navigation.jsp"/>
    <style>
        .comments-list .media{
            border-bottom: 1px dotted #ccc;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="page-header">
                <h1><small class="pull-right">45 comments</small> Comments </h1>
            </div>
            <div class="comments-list">
                <div class="media">
                    <div class="media-body">
                        <h4 class="media-heading user_name">Baltej Singh about Master Jin</h4>

                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias amet, aspernatur autem beatae
                        deleniti, error fuga, illo impedit magnam mollitia natus nesciunt perferendis quis quos
                        reiciendis? Alias dolorum ea similique.
                        <p><small><a href="">Delete comment</a></small></p>
                    </div>
                </div>
                <div class="media">
                    <div class="media-body">

                        <h4 class="media-heading user_name">Baltej Singh about Master Liya</h4>
                        Wow! this is really great.


                    </div>
                </div>
                <div class="media">
                    <div class="media-body">

                        <h4 class="media-heading user_name">Baltej Singh about Master Rick</h4>
                        Wow! this is really great.

                        <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                    </div>
                </div>
                <div class="media">
                    <div class="media-body">

                        <h4 class="media-heading user_name">Baltej Singh about Master Nick</h4>
                        Wow! this is really great.

                        <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                    </div>
                </div>
            </div>



        </div>
    </div>
</div>

</body>
</html>
