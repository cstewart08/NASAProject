<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style type="text/css">
  </style>

  </head>
<body>
<br>
<div style="text-align:center">
  <h2>
    Hello, Welcome to Craig's NASA RSS Feed Reader<br> <br>
  </h2>
  <h3>
    <a href="readFeed.html">Click here to view the NASA Feed</a>
  </h3>

  <form method="get" action="readFeed.html">
      <input type="text" id ="queryString" name="queryString" >
      <button id="button-id" type="submit">Search NASA Feed Title (Case Sensitive)</button>
  </form>
</div>

</body>
</html>

