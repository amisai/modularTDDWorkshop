package modularTDD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepositoryUser {
    private static Map<String, User> users = new HashMap<String, User>();

    public static void register(User user) {
        users.put(user.getUsername(), user);
    }

    public static boolean isRegistered(String username) {
        return users.containsKey(username);
    }

    public static User getUser(String username) {
        return users.get(username);
    }
}
