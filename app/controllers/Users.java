package controllers;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.users.*;

public class Users extends Controller {
    public static Form<User> userForm = Form.form(User.class);

    public static Result index() {
        List<User> users = User.find.all();
        return ok(index.render(users));
    }

    public static Result newUser() {
        return ok(newForm.render(userForm));
    }

    public static Result createUser() {
        Form<User> form = userForm.bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(newForm.render(form));
        }

        User user = form.get();
        User.create(user.name, user.password);
        return redirect(routes.Users.index());
    }
}
