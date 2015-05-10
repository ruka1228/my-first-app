package controllers;

import models.Task;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks() {
        Task task   = new Task();
        task.name   = "Pizza を食べる";
        task.period = new Date();
        task.save();

        List<String> taskList = Arrays.asList("foo", "bar", "baz");
        return ok(tasks.render(taskList));
    }

    public static Result help() {
        return ok(help.render());
    }
}
