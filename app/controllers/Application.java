package controllers;

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
        List<String> taskList = Arrays.asList("foo", "bar", "baz");

        List<Integer> fbList = new ArrayList<>(50);
        for (int i = 1; i <= 50; i++) {
            fbList.add(i);
        }

        return ok(tasks.render(taskList, fbList));
    }

    public static Result help() {
        return ok(help.render());
    }
}
