package com.SportsClasses.domain.User;

import com.SportsClasses.domain.Trainer.SearchForm;

/**
 * Created by Влад on 25.11.2014.
 */
public class UserSearchForm extends SearchForm{
    String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
