package bg.softuni.gamestore.services;

import bg.softuni.gamestore.entities.games.OwnedGamesDTO;
import bg.softuni.gamestore.entities.users.LoginDTO;
import bg.softuni.gamestore.entities.users.RegisterDTO;
import bg.softuni.gamestore.entities.users.User;

import java.util.List;

public interface UserService {
    void registerUser(RegisterDTO registerData);

    void loginUser(LoginDTO loginData);

    void logoutUser();

    List<OwnedGamesDTO> printOwnedGames(User loggedInUser);
}
