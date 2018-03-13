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
    <title>$param0$${initParam0}</title>
  </head>
  <body>
<%=session.getAttribute("Title")%><br>
<%=application.getAttribute("param0") %><br/>
<%=application.getAttribute("param1") %><br/>
<%=application.getAttribute("bool") %><br/>
<%=application.getAttribute("pig2") %><br/>
<%=application.getAttribute("pig3") %><br/>
</n>
  $END$
  <a href = "HelloWorldServlet">get</a>
  </n>
  <form method="post" action="./HelloWorldServlet">
    <input type="submit" value="提交1">
  </form>


  </body>
</html>
