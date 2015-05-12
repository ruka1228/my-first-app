package models;

import java.util.Date;
import java.util.List;

import play.data.validation.Constraints.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy="tasks")
    public List<User> users;

    public static Finder<Integer, Task> find = new Finder<Integer, Task>(
            Integer.class, Task.class
    );
}
