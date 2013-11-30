package modularTDD;

import java.util.Set;

public class UserService {

    public static boolean register(String username) {
        if (!RepositoryUser.isRegistered(username)) {
            RepositoryUser.register(new User(username));
            return true;
        }
        return false;
    }

    public static void follow(String username1, String  username2) {
        User userA = RepositoryUser.getUser(username1);
        User userB = RepositoryUser.getUser(username2);
        userA.follow(userB);
    }

    public static Set<User> followers(String username) {
        return RepositoryUser.getUser(username).getFollowers();
    }
}
