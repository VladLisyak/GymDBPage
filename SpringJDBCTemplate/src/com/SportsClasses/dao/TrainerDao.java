package com.SportsClasses.dao;

import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;

import java.util.List;

/**
 * Created by Влад on 26.10.2014.
 */
public interface TrainerDao {
    public void insertData(Trainer trainer);

    public List<Trainer> getTrainerList();

    public void updateData(Trainer trainer);

    public void deleteData(int id);

    public Trainer getTrainer(int id);

    public Trainer getTrainer(String name);

    public List<Trainer> getTrainersByParam(SearchForm searchForm);
}
