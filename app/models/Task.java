package models;

import java.util.Date;

import play.data.validation.Constraints.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Task extends Model {

    @Id
    public Integer id;

    @Required
    @MinLength(2)
    @MaxLength(100)
    public String name;

    public Date period;

    @ManyToOne
    public User user;

    public static Finder<Integer, Task> find = new Finder<Integer, Task>(
            Integer.class, Task.class
    );
}
