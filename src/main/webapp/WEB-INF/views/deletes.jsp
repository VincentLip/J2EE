<%--
  Created by IntelliJ IDEA.
  User: lipin
  Date: 09/06/2023
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supprimer le jeu</title>
</head>
<body>
<form action="deletes" method="post" >
    <div><input type="hidden" name="id" value="${game.getId()}"/></div>
    <div><button type="submit" >Valider</button></div>
</form>


</body>
</html>
