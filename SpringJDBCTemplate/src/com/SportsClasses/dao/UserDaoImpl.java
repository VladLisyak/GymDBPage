package com.SportsClasses.dao;

import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.User.UserSearchForm;
import com.SportsClasses.services.TrainerService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {


    SessionFactory sessionFactory;

    TrainerService ts;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory,TrainerService ts) {
        this.sessionFactory=sessionFactory;
        this.ts=ts;

    }


    private SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @Override
    public void insertData(User user,TrainerService ts) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Trainer tr = ts.getTrainer(user.getTr_name());
        tr.addUser(user);
        session.save(user);
        session.update(tr);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();}

    }

    public List<User> getUserList() {
        List userList;

        Session session = getSessionFactory().openSession();
        //session.beginTransaction();


        userList = session.createCriteria(User.class).list();

        List<User> users= new ArrayList<>();
        for (Object user :userList) {
             User f = (User)user;
            //if (ts.getTrainer(f.getTr_name())!=null)
            //f.setTrainer(ts.getTrainer(f.getTr_name()));
            users.add(f);
        }

        if (session.isOpen()) {
            session.close();
        }
        return users;
    }

    @Override
    public void deleteData(int id,TrainerService ts) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User user = getUser(id);
        /*Trainer tr = user.getTrainer();
        tr.getUsers().remove(user);
        session.save(tr);*/
        session.delete(user);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void updateData(User user, TrainerService ts) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();


        Trainer tr = ts.getTrainer(user.getTr_name());
        user.setTrainer(tr);
        if (!tr.getUsers().contains(user)){
            tr.addUser(user);
        }

        session.update(user);

        //Trainer f = ts.getTrainer("Vaad");

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }


    }

    @Override
    public User getUser(int id) {
        Session session= getSessionFactory().openSession();
        User us = (User)session.get(User.class,id);
        if (session.isOpen()) {
            session.close();
        }
        return us;
    }

    @Override
    public User getUser(String name) {
        String[] fnln = name.split(" ");
        Session session= getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from user where FIRST_NAME like '"+ fnln[0]+"' and last_name like '"+fnln[1]+"'").addEntity(User.class);
        List result = query.list();
        return (User) result.get(0);
    }

    @Override
    public List<User> getFreeUsers() {
        Session session= getSessionFactory().openSession();
        Query query = session.createSQLQuery("select * from user where NAME_TR is NULL").addEntity(User.class);
        List result = query.list();

        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
    public void setNull(User user) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(user);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<User> getUsersByParam(UserSearchForm searchForm) {
        Session session= getSessionFactory().openSession();
        String genderQuery = " AND gender like \""+searchForm.getGender()+"\"";
        String queryBuild;
        Query query;
        List<User> user;

        if (searchForm.getParameter().equals("money")){

            try {
                queryBuild ="select * from user where " + searchForm.getParameter() + " = " + Integer.parseInt(searchForm.getWord());

                if (!searchForm.getGender().equals("both")) {
                    queryBuild+= genderQuery;
                }

                query=session.createSQLQuery(queryBuild).addEntity(User.class);
                return query.list();
            } catch (NumberFormatException e) {
                return new ArrayList<>();
            }
           }

        if (searchForm.getParameter().equals("name")){
            String[] f = searchForm.getWord().split(" ");
            String querySt = "select * from user where first_name like \""+f[0]+"\"";
            if (f.length>1){
                query = session.createSQLQuery(querySt+"AND last_name LIKE \""+f[1]+"\"").addEntity(User.class);
                user = query.list();
            } else{
                query = session.createSQLQuery(querySt).addEntity(User.class);
                user = query.list();
                if (user.size()==0){
                    query = session.createSQLQuery("select * from user where last_name like \""+f[0]+"\"").addEntity(User.class);
                    user = query.list();
                }
            }
            if (!searchForm.getGender().equals("both")){
                List<User> gender = new ArrayList<>();
                for (User user1 :user) {
                    if (user1.getGender().equals(searchForm.getGender()))
                        gender.add(user1);
                }
                return gender;
            }
            return user;
        }

         queryBuild = "select * from user";
       if (!searchForm.getGender().equals("both")){
           queryBuild+=" AND gender like \""+searchForm.getGender() +"\"";
       }

        query = session.createSQLQuery(queryBuild).addEntity(User.class);
        user = query.list();

        List<User> usersWithPropTrainer = new ArrayList<User>();
                for (User o :user) {
                   if (o.getTrainer()!=null)
                   if (o.getTrainer().getNAME_TR().equals(searchForm.getWord())){
                       usersWithPropTrainer.add(o);
                   }
                }


        return usersWithPropTrainer;
        }

}


