package controllers;

import models.Task;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks() {
        // java.util.Random;
        Random rnd = new Random();

        Task task   = new Task();
        task.name   = "ピザを" + rnd.nextInt(10) + "枚食べる";
        task.period = new Date();
        task.save();

        List<Task> taskList = Task.find.all();
        return ok(tasks.render(taskList));
    }

    public static Result help() {
        return ok(help.render());
    }
}
