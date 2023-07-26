package bg.softuni.gamestore.services;

import bg.softuni.gamestore.entities.users.LoginDTO;
import bg.softuni.gamestore.entities.users.RegisterDTO;
import bg.softuni.gamestore.entities.users.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginData);

    User getLoggedUser();

    void logout();
}
