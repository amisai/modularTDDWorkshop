package modularTDD;


import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserRegisterTest {
    @Test
    public void shouldAllowSomeUsersRegister() {
        String username1 = "@pasku1";
        RepositoryUser.register(username1);
        assertTrue(RepositoryUser.isRegistered(username1), "user " + username1 + "is not registered");

        String username2 = "@pasku2";
        RepositoryUser.register(username2);
        assertTrue(RepositoryUser.isRegistered(username1), "user " + username1 + " is not registered");
        assertTrue(RepositoryUser.isRegistered(username2), "user " + username2 + "is not registered");
    }

    @Test
    public void shouldAlertWhenAttemptingRegisterAnAlreadyRegisteredUser() {
        String username1 = "@pasku1";
        RepositoryUser.register(username1);

        assertFalse(RepositoryUser.register(username1), "already registered");


    }

}

class RepositoryUser {
    private static Set<String> users = new HashSet<String>();

    public static boolean register(String username) {
        if (!isRegistered(username)) {
            users.add(username);
            return true;
        }
        return false;
    }

    public static boolean isRegistered(String username) {
        return users.contains(username);
    }

}
