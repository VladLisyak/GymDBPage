package com.SportsClasses.services;

import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.User.UserSearchForm;

import java.util.List;

public interface UserService {
	public void insertData(User user, TrainerService trainerService);

	public List<User> getUserList();

	//public void deleteData(int id);

    void deleteData(int id, TrainerService ts);

    public User getUser(int id);

	public void updateData(User user, TrainerService trainerService);

    public List<User> getFreeUsers();

    public User getUser(String name);

    public void setNull(User user);

    public List<User> getUsersByParam(UserSearchForm searchForm);

    public List<User> getEmpty();
}
