package modularTDD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepositoryMemoryUser implements RepositoryUser {
    private static Map<String, User> users = new HashMap<String, User>();

    public void register(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean isRegistered(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void store() {
    }
}
