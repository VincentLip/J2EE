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

@WebServlet(name = "games", value = "/games")
public class GameServlet extends HelloServlet{

    private GameService gameService;

    public void init() {
        gameService = new GameService();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        if(request.getParameter("name") != null) {
            String name = request.getParameter("name");
            String developer = request.getParameter("developer");
            String genres = request.getParameter("genres");
            String description = request.getParameter("description");
            LocalDate dateAchat = LocalDate.parse(request.getParameter("releaseDate"));
            Game game = new Game(name, developer,genres, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), description);
            if(gameService.create(game)) {
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
                request.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            request.setAttribute("games", gameService.findAll());
            try {
                request.getRequestDispatcher("/WEB-INF/views/games.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void destroy() {

    }

}
