package com.SportsClasses.dao;

import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.User.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 26.10.2014.
 */
@Repository
public class TrainerDaoImpl implements TrainerDao {

    SessionFactory sessionFactory;


    @Autowired

    public TrainerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void insertData(Trainer trainer) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trainer);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();}

    }

    @Override
    public List<Trainer> getTrainerList() {
        List trainerList;

        Session session = getSessionFactory().openSession();
        //session.beginTransaction();


        trainerList = session.createCriteria(Trainer.class).list();
        if (session.isOpen()) {
            session.close();
        }

        List<Trainer> list = new ArrayList<>();
        for (Object o :trainerList) {
            if(!list.contains((Trainer)o)){
                list.add((Trainer)o);
            }
        }

        return list;
    }

    @Override
    public void updateData(Trainer trainer) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(trainer);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void deleteData(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Trainer trainer = getTrainer(id);
        session.delete(trainer);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public Trainer getTrainer(int id) {
        Session session= getSessionFactory().openSession();
        Trainer us = (Trainer)session.get(Trainer.class,id);

        if (session.isOpen()) {
            session.close();
        }
        return us;
    }

    public Trainer getTrainer(String name) {
        Session session= getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from trainers where NAME_TR like :name").addEntity(Trainer.class);
        List result = query.setString("name", name).list();
        Trainer tr;
        if (result.size()>0){
        tr = (Trainer)result.get(0);}
        else
        tr=null;

       /* Query query1 = session.createSQLQuery("select * from user where NAME_TR like :name");
        List users = query1.setString("name",name).list();
        List<User> usr = new ArrayList<>();*/


        /*for (Object user : users) {
            Object[] obj = (Object[]) user;
            System.out.println();// usr.add();
        }*/

        /*tr.setUsers(usr);*/

        if (session.isOpen()) {
            session.close();
        }

        return tr;
    }

    @Override
    public List<Trainer> getTrainersByParam(SearchForm searchForm) {
        Session session= getSessionFactory().openSession();
        Query query;
        if (searchForm.getParameter().equals("salary") || searchForm.getParameter().equals("rank")){
            try {
                query  = session.createSQLQuery("select * from trainers where " + searchForm.getParameter()+" = "+Integer.parseInt(searchForm.getWord())).addEntity(Trainer.class);
            } catch (NumberFormatException e) {
                return new ArrayList<>();
            }
        }else {
           if (searchForm.getParameter().equals("client")){
               List<User> user;
               String[] f = searchForm.getWord().split(" ");
               String querySt = "select * from user where first_name like \""+f[0]+"\"";
               if (f.length>1){
                   query = session.createSQLQuery( querySt+"AND last_name LIKE \""+f[1]+"\"").addEntity(User.class);
                user = query.list();
               } else{
                   query = session.createSQLQuery(querySt).addEntity(User.class);
                user = query.list();
                   if (user.size()==0){
                       query = session.createSQLQuery("select * from user where last_name like \""+f[0]+"\"").addEntity(User.class);
                       user = query.list();
                   }
               }
               List<Trainer> list =new ArrayList<>();
               if (user.size()>0){
                   list.add(user.get(0).getTrainer());
               }
               if (session.isOpen()) {
                   session.close();
               }
               return list;
           }

            query  = session.createSQLQuery("select * from trainers where " + searchForm.getParameter()+" like \""+searchForm.getWord()+"\"").addEntity(Trainer.class);

        }
        List<Trainer> list = query.list();

        if (session.isOpen()) {
            session.close();
        }

        System.out.println("so");
        return list;
    }
}
