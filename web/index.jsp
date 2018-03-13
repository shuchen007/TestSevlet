<%--
  Created by IntelliJ IDEA.
  User: sunhao
  Date: 2018/3/12
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$context/param$</title>
  </head>
  <body>
<%=request.getSession().getAttribute("Title")%>
</n>
<br/>
<%=application.getAttribute("bool") %><br/>
</n>
  $END$
  <a href = "HelloWorldServlet">get</a>
  </n>
  <form method="post" action="./HelloWorldServlet">
    <input type="submit" value="提交1">
  </form>


  </body>
</html>
