package com.SportsClasses.domain.User;


import com.SportsClasses.domain.Trainer.Trainer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Влад on 04.11.2014.
 */
@Entity
public class User {
    private Integer userId;
    @NotNull
    @Size(min=2)
    private String firstName;
    @NotNull
    private String gender;
    @NotNull
    @Size(min=2)
    private String lastName;

    @NotNull
    @Min(0)
    private Integer money;
    private Trainer trainer;



    @Transient
    private String tr_name;

    public String getTr_name() {
        return tr_name;
    }

    public void setTr_name(String tr_name) {
        this.tr_name = tr_name;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

       // if (NAME_TR != null ? !NAME_TR.equals(user.NAME_TR) : user.NAME_TR != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (money != null ? !money.equals(user.money) : user.money != null) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
       // result = 31 * result + (NAME_TR != null ? NAME_TR.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NAME_TR", referencedColumnName = "NAME_TR")
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        if (trainer!=null)
            this.setTr_name(trainer.getNAME_TR());
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return firstName + ' ' +
                lastName;
    }
}
