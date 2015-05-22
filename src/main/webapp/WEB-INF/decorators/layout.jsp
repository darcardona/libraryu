<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
  prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>LibraryU <dec:title default="" /></title>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
  rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>"
  rel="stylesheet">
<link href="<c:url value="/resources/css/libraryu.css"/>"
  rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<dec:head />
</head>

<body role="document">
  <script src="http://code.jquery.com/jquery-latest.min.js"
    type="text/javascript"></script>
  <script type='text/javascript'
    src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>

  <%@include file="navbar.jsp"%>

  <div class="container" role="main">

    <div class="col-md-3 hidden-xs hidden-sm ">
      <%@include file="menu.jsp"%>
    </div>

    <div class="col-md-9 ">
      <%@include file="message.jsp"%>
      <dec:body />
    </div>

  </div>
  <!-- /.container -->

  <footer class="footer">
    <p class="text-muted">&copy; darcardona.</p>
  </footer>

</body>
</html>