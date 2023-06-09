<%--
  Created by IntelliJ IDEA.
  User: lipin
  Date: 09/06/2023
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        Nom : ${game.getName()}
    </div>
    <div>
        Développeur : ${game.getDeveloper()}
    </div>
    <div>
        Genres : ${game.getGenres()}
    </div>
    <div>
        Date de sortie : ${game.getReleaseDate()}
    </div>
    <div>
        Description : ${game.getDescription()}
    </div>
</body>
</html>
