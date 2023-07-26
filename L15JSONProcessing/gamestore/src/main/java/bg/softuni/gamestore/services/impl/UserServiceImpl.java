package bg.softuni.gamestore.services.impl;

import bg.softuni.gamestore.entities.users.LoginDTO;
import bg.softuni.gamestore.entities.users.RegisterDTO;
import bg.softuni.gamestore.entities.users.User;
import bg.softuni.gamestore.exceptions.UserNotLoggedInException;
import bg.softuni.gamestore.repositories.UserRepository;
import bg.softuni.gamestore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser = null;
    }

    @Override
    public User register(RegisterDTO registerData) {
        if (this.currentUser != null) {

        }
        ModelMapper mapper = new ModelMapper();
        User toRegister = mapper.map(registerData, User.class);
        long userCount = this.userRepository.count();
        if (userCount == 0) {
            toRegister.setAdmin(true);
        }
        return this.userRepository.save(toRegister);
    }

    @Override
    public Optional<User> login(LoginDTO loginData) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
        user.ifPresent(value -> this.currentUser = value);
        return user;
    }


    @Override
    public User getLoggedUser() {
        if (this.currentUser == null) {
            throw new UserNotLoggedInException();
        }
        return this.currentUser;
    }

    @Override
    public void logout() {
        //TODO : Logout Cannot log out. No user was logged in.
    }
}
