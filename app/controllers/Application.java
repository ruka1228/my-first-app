package controllers;

import models.Task;
import models.User;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
    public static Form<Task> taskForm = Form.form(Task.class);

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks() {
        List<Task> taskList = Task.find.all();
        return ok(tasks.render(taskList, taskForm));
    }

    @Security.Authenticated(Secured.class)
    public static Result myTasks() {
        User user = User.find.where().eq("name", request().username()).findUnique();
        return ok(myTasks.render(user.tasks));
    }

    @Security.Authenticated(Secured.class)
    public static Result createTask() {
        Form<Task> form = taskForm.bindFromRequest();

        if (form.hasErrors()) {
            List<Task> taskList = Task.find.all();

            // 制約エラーが発生したら、その情報を持っ form を渡してあげる
            return badRequest(tasks.render(taskList, form));
        } else {
            Task newTask = form.get();
            User user = User.find.where().eq("name", request().username()).findUnique();
            newTask.users.add(user);
            newTask.save();
            return redirect(routes.Application.tasks());
        }
    }

    public static Result help() {
        return ok(help.render());
    }
}
