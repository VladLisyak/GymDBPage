package com.SportsClasses.domain;

import com.SportsClasses.domain.Trainer.Trainer;

import javax.validation.Valid;

/**
 * Created by Влад on 08.11.2014.
 */
public class Wrapper {
    @Valid
    Trainer trainer;
    String[] usernames;
    String[]initClients;

    public String[] getInitClients() {
        return initClients;
    }

    public void setInitClients(String[] initClients) {
        this.initClients = initClients;
    }

    public String[] getUsernames() {
        return usernames;
    }

    public void setUsernames(String[] usernames) {
        this.usernames = usernames;
    }

    public Trainer getTrainer() {

        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
