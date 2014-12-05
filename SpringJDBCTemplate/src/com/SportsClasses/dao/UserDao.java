package com.SportsClasses.dao;

import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.User.UserSearchForm;
import com.SportsClasses.services.TrainerService;

import java.util.List;

public interface UserDao {
	//public void insertData(User user);

    void insertData(User user, TrainerService ts);

    public List<User> getUserList();

    void deleteData(int id,TrainerService ts);

    public void updateData(User user, TrainerService ts);

	//public void deleteData(int id);

	public User getUser(int id);

    public User getUser(String name);

    public List<User> getFreeUsers();

    public void setNull(User user);

    List<User> getUsersByParam(UserSearchForm searchForm);
}
