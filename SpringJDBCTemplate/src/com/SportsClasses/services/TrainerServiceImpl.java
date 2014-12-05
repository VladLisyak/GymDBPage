package com.SportsClasses.services;

import com.SportsClasses.dao.TrainerDao;
import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 26.10.2014.
 */
@Repository
public class TrainerServiceImpl implements TrainerService {
   TrainerDao trainerDao;

    @Autowired
    public TrainerServiceImpl(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    @Override
    public void insertData(Trainer trainer) {
        trainerDao.insertData(trainer);
    }

    @Override
    public List<Trainer> getTrainerList() {
        return trainerDao.getTrainerList();
    }

    @Override
    public void deleteData(int id) {
        trainerDao.deleteData(id);
    }

    @Override
    public Trainer getTrainer(int id) {
        Trainer tr =trainerDao.getTrainer(id);
        //tr.setUsernames(new ArrayList<String>());
        return tr;
    }
    public Trainer getTrainer(String name) {
        return trainerDao.getTrainer(name);
    }

    @Override
    public void updateData(Trainer trainer) {
        trainerDao.updateData(trainer);
    }

    @Override
    public void resetData(Wrapper wrapper,UserService userService) {
        ArrayList<User> newUsers = new ArrayList<>();
        /*if (wrapper.getTrainer().getUsers()!=null){
        for (User user :wrapper.getTrainer().getUsers()) {
            user.setTrainer(null);
         }
        }*/
        ArrayList<User> init = new ArrayList<>();
        wrapper.getTrainer().setUsers(init);
        if (wrapper.getInitClients() != null)
            for (String user : wrapper.getInitClients()) {
                wrapper.getTrainer().getUsers().add(userService.getUser(user));
            }

        updateData(wrapper.getTrainer());

        for (User user : wrapper.getTrainer().getUsers()) {
            user.setTrainer(null);
            userService.setNull(user);
        }

        // wrapper.getTrainer().setUsers(new ArrayList<User>());

        if (wrapper.getUsernames() != null) {
            for (int i = 0; i < wrapper.getUsernames().length; i++) {
                User u = userService.getUser(wrapper.getUsernames()[i]);
                u.setTrainer(wrapper.getTrainer());
                newUsers.add(u);
            }
        }

        wrapper.getTrainer().setUsers(newUsers);

        updateData(wrapper.getTrainer());

        if (wrapper.getTrainer().getUsers() != null)
            for (User user : wrapper.getTrainer().getUsers()) {
                user.setTr_name(wrapper.getTrainer().getNAME_TR());
                userService.updateData(user, this);
            }

    }

    @Override
    public List<Trainer> getTrainersByParam(SearchForm searchForm) {
        if (searchForm.getParameter().equals("ID")){
            List<Trainer> tr = new ArrayList<>();
            try{
                tr.add(trainerDao.getTrainer(Integer.parseInt(searchForm.getWord())));
                return tr;
            }catch (Exception e){
               return tr;
            }
        } else
        return trainerDao.getTrainersByParam(searchForm);
    }


}
