package com.SportsClasses.domain.Trainer;

import com.SportsClasses.domain.User.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Влад on 04.11.2014.
 */

@Entity
@Table(name = "trainers", schema = "", catalog = "userdb")
public class Trainer implements Serializable{
    private Integer trainerId;
    @NotNull
    @Size(min = 2)
    private String NAME_TR;
    @NotNull
    private Integer rank;
    @NotNull
    @Min(15)
    private Integer salary;
    private Collection<User> users;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "NAME_TR")
    public String getNAME_TR() {
        return NAME_TR;
    }

    public void setNAME_TR(String NAME_TR) {
        this.NAME_TR = NAME_TR;
    }

    @Basic
    @Column(name = "rank")
    @NotNull
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer trainer = (Trainer) o;

        if (NAME_TR != null ? !NAME_TR.equals(trainer.NAME_TR) : trainer.NAME_TR != null) return false;
        if (rank != null ? !rank.equals(trainer.rank) : trainer.rank != null) return false;
        if (salary != null ? !salary.equals(trainer.salary) : trainer.salary != null) return false;
        if (trainerId != null ? !trainerId.equals(trainer.trainerId) : trainer.trainerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainerId != null ? trainerId.hashCode() : 0;
        result = 31 * result + (NAME_TR != null ? NAME_TR.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "trainer",cascade={CascadeType.PERSIST/*, CascadeType.REMOVE*/})
    @org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return NAME_TR;
    }

    public void addUser(User user) {
        user.setTrainer(this);
        users.add(user);
    }
}
