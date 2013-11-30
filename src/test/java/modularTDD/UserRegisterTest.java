package modularTDD;


import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserRegisterTest {
    @Test
    public void shouldAllowSomeUsersRegister() {
        String username1 = "@pasku1";
        UserService.register(username1);
        assertTrue(RepositoryUser.isRegistered(username1), "user " + username1 + "is not registered");

        String username2 = "@pasku2";
        UserService.register(username2);
        assertTrue(RepositoryUser.isRegistered(username1), "user " + username1 + " is not registered");
        assertTrue(RepositoryUser.isRegistered(username2), "user " + username2 + "is not registered");
    }

    @Test
    public void shouldAlertWhenAttemptingRegisterAnAlreadyRegisteredUser() {
        String username1 = "@pasku1";
        UserService.register(username1);

        assertFalse(UserService.register(username1), "already registered");
    }

    @Test
    public void userRegisteredShouldFollowAnotherUserRegistered() {
        String username1 = "@pasku1";
        UserService.register(username1);
        String username2 = "@pasku2";
        UserService.register(username2);

        UserService.follow(username1, username2);

        assertTrue(UserService.followers(username1).contains(new User(username2)), "user2 is not following user1 " + UserService.followers(username1));
    }
}

