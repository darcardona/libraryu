<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>books</title>
</head>
<body>
  <div>
    <h1>Books</h1>
    <p class="lead">Registered books.</p>
  </div>

  <div class="row">
    <div class="table-responsive">

      <table class="table table-hover">
        <thead>
          <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Category</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${books}" var="book">
            <tr>
              <td><a
                href="<c:url value="/books/edit/${book.isbn}"/>">${book.isbn}</a></td>
              <td>${book.title}</td>
              <td>${book.author}</td>
              <td>${book.edition}</td>
              <td>${book.category.name}</td>
              <td><a
                href="<c:url value="/books/delete/${book.isbn}"/>"><span
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
        <a href="<c:url value="/books/add"/>">Create Book</a>
      </div>
    </div>

  </div>
  <!-- /.row -->

</body>
</html>