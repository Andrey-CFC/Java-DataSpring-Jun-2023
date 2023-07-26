package bg.softuni.gamestore.services.impl;

import bg.softuni.gamestore.Util.ValidationUtil;
import bg.softuni.gamestore.entities.games.OwnedGamesDTO;
import bg.softuni.gamestore.entities.users.LoginDTO;
import bg.softuni.gamestore.entities.users.RegisterDTO;
import bg.softuni.gamestore.entities.users.User;
import bg.softuni.gamestore.repositories.UserRepository;
import bg.softuni.gamestore.services.UserService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
            return;
        }
        if (isValidEntity(registerDTO)) return;
        User user = mapper.map(registerDTO, User.class);
        userRepository.save(user);
        System.out.println(registerDTO.getFullName() + " was registered");
    }

    @Override
    public List<OwnedGamesDTO> printOwnedGames(User loggedInUser) {

        return userRepository.findAllByUser(loggedInUser.getId()).stream()
                .map(game -> mapper.map(game, OwnedGamesDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public void loginUser(LoginDTO loginDTO) {
        if (isValidEntity(loginDTO)) return;

        Optional<User> user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (user.isEmpty()) {
            System.out.println("Incorrect username / password");
            return;
        }
        loggedInUser = user.get();
        System.out.printf("Successfully logged in %s%n", user.get().getFullName());

    }

    @Override
    public void logoutUser() {
        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        System.out.printf("User %s successfully logged out%n", loggedInUser.getFullName());
        loggedInUser = null;
    }

    private <E> boolean isValidEntity(E entity) {
        Set<ConstraintViolation<E>> violations = validationUtil.violation(entity);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return true;
        }
        return false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}