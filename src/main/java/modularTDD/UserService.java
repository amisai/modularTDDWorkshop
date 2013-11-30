package modularTDD;

import java.util.Set;

public class UserService {
    private final RepositoryUser repository;

    public UserService(RepositoryUser repositoryUser) {
        repository = repositoryUser;
    }

    public boolean register(String username) {
        if (!repository.isRegistered(username)) {
            repository.register(new User(username));
            return true;
        }
        return false;
    }

    public  void follow(String username1, String  username2) {
        User userB = repository.getUser(username2);
        User userA = repository.getUser(username1);
        userA.follow(userB);
        repository.store();
    }

    public Set<User> followers(String username) {
        return repository.getUser(username).getFollowers();
    }
}
