package com.SportsClasses.domain.Trainer;

import com.sun.istack.internal.Nullable;

import javax.validation.constraints.Size;

/**
 * Created by Влад on 23.11.2014.
 */
public class SearchForm {
    @Nullable
    String word;
    String parameter;

    @Size(min = 1)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
