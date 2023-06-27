package bg.softuni.Accounts.services;

import bg.softuni.Accounts.models.User;
import bg.softuni.Accounts.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
        if (byUsername.isPresent()){
            throw new IllegalArgumentException("Username already taken");
        }
        userRepository.save(user);
    }
}
