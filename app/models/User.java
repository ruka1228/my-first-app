package models;

import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;

import play.db.ebean.Model;

@Entity
public class User extends Model {
    @Id
    public Long id;

    public String name;

    public String password;

    public static Finder<Long, User> find = new Finder<Long,User>(
        Long.class, User.class
    );

    /**
     * <code>
     * if (User.create("gongo", "pizza")) {
     *     System.out.println("認証成功!!");
     * } else {
     *     System.out.println("認証失敗...");
     * }
     * </code>
     *
     * @param username ユーザ名
     * @param password パスワード
     * @return ユーザ名 & パスワードのセットが正しければ true
     */
    public static Boolean authenticate(String username, String password) {
        User user = find.where().eq("name", username).findUnique();
        return (user != null && BCrypt.checkpw(password, user.password));
    }

    public static Long create(String username, String password) {
        User user = new User();
        user.name = username;
        user.password = BCrypt.hashpw(password, BCrypt.gensalt());
        user.save();

        return user.id;
    }
}