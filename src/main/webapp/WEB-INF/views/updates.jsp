<%--
  Created by IntelliJ IDEA.
  User: lipin
  Date: 09/06/2023
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier les informations</title>
</head>
<body>
<form action="updates" method="post" >
    <div><input type="hidden" name="id" value="${game.getId()}"/></div>
    <div><label>Nom</label><input type="text" name="name" value="${game.getName()}" /></div>
    <div><label>Développeur</label><input type="text" name="developer" value="${game.getDeveloper()}"/></div>
    <div><label>Genres </label><input type="text" name="genres" value="${game.getGenres()}" /></div>
    <div><label>Date de sortie</label><input type="text" name="releaseDate" value="${game.getReleaseDate()}" /></div>
    <div><label>Description</label><input type="text" name="description" value="${game.getDescription()}" /></div>
    <div><button type="submit" >Valider</button></div>
</form>

</body>
</html>
