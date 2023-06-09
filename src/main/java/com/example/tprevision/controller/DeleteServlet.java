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

@WebServlet(name = "deletes", value = "/deletes")
public class DeleteServlet extends HelloServlet {

    private GameService gameService;

    public void init() {
        gameService = new GameService();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        if(request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findById(id);
            if(gameService.delete(game)) {
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
                request.getRequestDispatcher("/WEB-INF/views/deletes.jsp").forward(request,response);
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
