<%--
  Created by IntelliJ IDEA.
  User: lipin
  Date: 09/06/2023
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Liste des jeux</h1>

<div>
    <form action="games" method="post" >
        <div><label>Nom</label><input type="text" name="name" /></div>
        <div><label>Développeur</label><input type="text" name="developer" /></div>
        <div><label>Genres </label><input type="text" name="genres" /></div>
        <div><label>Date de sortie</label><input type="text" name="releaseDate" /></div>
        <div><label>Description</label><input type="text" name="description" /></div>
        <div><button type="submit" >Valider</button></div>
    </form>
</div>
<c:if test="${games != null}">
    <c:forEach items="${games}" var="game">
        <div>
            Nom : ${game.getName()}
            Développeur : ${game.getDeveloper()}
            <a href="games?id=${game.getId()}">Detail</a>
            <a href="updates?id=${game.getId()}">Modifier</a>
            <a href="deletes?id=${game.getId()}">Supprimer</a>
        </div>
    </c:forEach>
</c:if>

</body>
</html>
