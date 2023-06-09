package com.example.tprevision.controller;


import com.example.tprevision.entity.Game;
import com.example.tprevision.services.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "updates", value = "/updates")
public class UpdateGameServlet extends HelloServlet{
    private GameService gameService;

    public void init() {
        gameService = new GameService();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        if(request.getParameter("name") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findById(id);
            String name = request.getParameter("name");
            String developer = request.getParameter("developer");
            String genres = request.getParameter("genres");
            String description = request.getParameter("description");
            LocalDate releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
            game.setDescription(description);
            game.setName(name);
            game.setDeveloper(developer);
            game.setGenres(genres);
            game.setReleaseDate(Date.from(releaseDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            if(gameService.update(game)) {
                response.sendRedirect("games");
            }
        }else {

        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Game game = gameService.findById(id);
            request.setAttribute("game", game);
            try {
                request.getRequestDispatcher("/WEB-INF/views/updates.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        else {

        }

    }

    public void destroy() {

    }

}
