<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
	<title>Category Saved Successfully</title>
</head>
<body>
<h3>
	Category Saved Successfully
</h3>

<strong>Category Name:${category.name}</strong><br>
<strong>Category Location:${category.location}</strong><br>

</body>
</html>
