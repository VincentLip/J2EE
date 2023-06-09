package com.example.tprevision.services;

import com.example.tprevision.entity.Game;
import com.example.tprevision.interfaces.Repository;

import org.hibernate.query.Query;
import java.util.List;

public class GameService extends BaseService implements Repository<Game> {

    public GameService(){
        super();
    }
    @Override
    public boolean create(Game o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Game o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Game o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Game findById(int id) {
        Game game = null;
        session = sessionFactory.openSession();
        game = (Game) session.get(Game.class, id);
        session.close();
        return game;
    }

    @Override
    public List<Game> findAll() {
        List<Game> gameList = null;
        session = sessionFactory.openSession();
        Query<Game> gameQuery = session.createQuery("from Game");
        gameList = gameQuery.list();
        session.close();
        return gameList;
    }
}
