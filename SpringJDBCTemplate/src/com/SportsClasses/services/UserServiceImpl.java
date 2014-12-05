package com.SportsClasses.services;

import com.SportsClasses.dao.UserDao;
import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.User.UserSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {


    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertData(User user, TrainerService trainerService) {

        userDao.insertData(user, trainerService);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public void deleteData(int id,TrainerService ts) {
        userDao.deleteData(id, ts);

    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateData(User user, TrainerService trainerService) {
        userDao.updateData(user, trainerService);
    }

    @Override
    public List<User> getFreeUsers() {
        return userDao.getFreeUsers();
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    @Override
    public void setNull(User user) {
        userDao.setNull(user);
    }

    @Override
    public List<User> getUsersByParam(UserSearchForm searchForm) {
        if (searchForm.getParameter().equals("ID")){
            List<User> tr = new ArrayList<>();
            try{
                tr.add(userDao.getUser(Integer.parseInt(searchForm.getWord())));
                return tr;
            }catch (Exception e){
                return tr;
            }
        } else
            return userDao.getUsersByParam(searchForm);
    }

    @Override
    public List<User> getEmpty() {
        return userDao.getFreeUsers();
    }


}
