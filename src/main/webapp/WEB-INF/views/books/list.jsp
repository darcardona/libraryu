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

  <div class="row-fluid">
    <div class="span8">

      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>ISBN</th>
              <th>Title</th>
              <th>Author</th>
              <th>Edition</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${books}" var="book">
              <tr>
                <td><a
                  href="<c:url value="/books/edit/${book.isbn}"/>">${book.isbn}</a></td>
                <td>${book.title}</td>
                <td>${book.autor}</td>
                <td>${book.edition}</td>
                <td><a class="icon-remove"
                  href="<c:url value="/books/delete/${book.isbn}"/>"></a>&nbsp;</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="spacer">&nbsp;</div>

      <div class="control-group">
        <div class="btn btn-default">
          <a href="<c:url value="/books/add"/>">Create Book</a>
        </div>
      </div>

    </div>
  </div>

</body>
</html>