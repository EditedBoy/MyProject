<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Taras</title>
        <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

        <link href='http://fonts.googleapis.com/css?family=Raleway:400,600,900' rel='stylesheet' type='text/css'>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <link rel="stylesheet" href="resources/template/css/normalize.css">
        <link rel="stylesheet" href="resources/template/css/style.css">

        <link rel="stylesheet" href="resources/default/css/button-styles.css">
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