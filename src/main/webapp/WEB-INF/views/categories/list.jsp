<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>category</title>
</head>
<body>
  <div>
    <h1>Categories</h1>
    <p class="lead">Registered categories.</p>
  </div>

  <div class="row">
    <div class="table-responsive">

      <table class="table table-hover">
        <thead>
          <tr>
            <th>Name</th>
            <th>Location</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${categories}" var="category">
            <tr>
              <td><a
                href="<c:url value="/categories/edit/${category.id}"/>">${category.name}</a></td>
              <td>${category.location}</td>
              <td><a
                href="<c:url value="/categories/delete/${category.id}"/>"><span
                  class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- /.table-responsive -->

    <div class="control-group">
      <div class="btn btn-default">
        <a href="<c:url value="/categories/add"/>">Create Category</a>
      </div>
    </div>

  </div>
  <!-- /.row -->

</body>
</html>