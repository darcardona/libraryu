<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
  prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="libraryu desc">

<title>LibraryU <dec:title default="" /></title>

<link rel="stylesheet" type="text/css"
  href='<c:url value="/resources/css/bootstrap.min.css"/>' />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>

<link rel="stylesheet" type="text/css"
  href='<c:url value="/resources/css/bootstrap-responsive.min.css"/>' />
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
<!-- Fav and touch icons 
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png">
		<link rel="shortcut icon" href="resources/ico/favicon.png">
		-->
<dec:head />
</head>

<body>
  <script src="http://code.jquery.com/jquery-latest.min.js"
    type="text/javascript"></script>
  <script type='text/javascript'
    src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>
  <%@include file="navbar.jsp"%>

  <div class="container-fluid">
    <div class="row-fluid">

      <div class="span3">
        <%@include file="menu.jsp"%>
      </div>

      <div class="span9">
        <%@include file="message.jsp"%>
        <dec:body />
      </div>

    </div>

    <hr>
    <footer>
      <p>&copy; darcardona</p>
    </footer>

  </div>

</body>
</html>