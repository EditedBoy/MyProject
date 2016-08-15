<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Taras</title>

        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>


        <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>


        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

        <link href="http://fonts.googleapis.com/css?family=Raleway:400,600,900" rel="stylesheet" type="text/css">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="resources/template/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="resources/template/css/style.css">

        <link rel="stylesheet" type="text/css" href="resources/default/css/button-styles.css">

        <script src="http://code.angularjs.org/1.0.5/angular.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>

    </head>

    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="resources/template/js/index.js"></script>
    </body>
</html>

