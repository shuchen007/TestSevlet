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
    <title>${initParam.param0}</title>
  </head>
  <body>
  <%--获取application上下文，context-param参数。--%>
  ${initParam.param0}<br>
  <%=application.getInitParameter("param0") %><br/>
  <%out.println("-----------");%>

  <%--获取application对象--%>
  ${applicationScope.app1}<br>
  <%=application.getAttribute("app2") %><br/>
  <%out.println("-----------");%>

  <%--获取session对象--%>
  ${sessionScope.ses1}<br>
  <%=session.getAttribute("ses2") %><br/>
  <%out.println("-----------");%>

  <%--获取并设置request--%>
  <% request.setAttribute("req1","REQ1");%><br/>

  <%
    int x= 1+3;
    System.out.println("do000000"+x);
  %>;
</n>
  $END$
  <a href = "dd">get</a>
  </n>
  <form method="post" action="./dd">
    <input type="submit" value="提交1">
  </form>


  </body>
</html>
