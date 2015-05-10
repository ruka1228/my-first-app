package controllers;

import models.Task;

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

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result tasks() {
        List<Task> taskList = Task.find.all();
        return ok(tasks.render(taskList));
    }

    public static Result createTask() {
        Form<Task> form = Form.form(Task.class).bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        } else {
            Task newTask = form.get();
            newTask.save();
            return redirect(routes.Application.tasks());
        }
    }

    public static Result help() {
        return ok(help.render());
    }
}
