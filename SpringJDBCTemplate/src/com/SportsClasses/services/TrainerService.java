package com.SportsClasses.services;

import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.Wrapper;

import java.util.List;

/**
 * Created by Влад on 26.10.2014.
 */
public interface TrainerService {
    public void insertData(Trainer trainer);

    public List<Trainer> getTrainerList();

    public void deleteData(int id);

    public Trainer getTrainer(int id);
    public Trainer getTrainer(String name);

    public void updateData(Trainer trainer);

    public void resetData(Wrapper wrapper,UserService userService);

    List<Trainer> getTrainersByParam(SearchForm searchForm);
}
