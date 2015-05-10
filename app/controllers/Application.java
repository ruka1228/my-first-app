package controllers;

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
        List<String> taskList = Arrays.asList("foo", "bar", "baz");
        return ok(tasks.render(taskList));
    }

    public static Result help() {
        return ok(help.render());
    }
}
