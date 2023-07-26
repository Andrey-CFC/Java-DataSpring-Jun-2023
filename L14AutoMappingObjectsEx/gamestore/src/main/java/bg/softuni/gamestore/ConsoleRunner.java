package bg.softuni.gamestore;

import bg.softuni.gamestore.entities.games.AddGameDTO;
import bg.softuni.gamestore.entities.games.AllGamesDTO;
import bg.softuni.gamestore.entities.games.DetailGameDTO;
import bg.softuni.gamestore.entities.games.OwnedGamesDTO;
import bg.softuni.gamestore.entities.users.LoginDTO;
import bg.softuni.gamestore.entities.users.RegisterDTO;
import bg.softuni.gamestore.services.impl.GameServiceImpl;
import bg.softuni.gamestore.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserServiceImpl userService;
    private final GameServiceImpl gameService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, GameServiceImpl gameService) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter a command:");
            String[] commandLine = bufferedReader.readLine().split("\\|");
            switch (commandLine[0]) {
                case "RegisterUser" -> userService.registerUser(new RegisterDTO(commandLine[1], commandLine[2], commandLine[3], commandLine[4]));
                case "LoginUser" -> userService.loginUser(new LoginDTO(commandLine[1], commandLine[2]));
                case "Logout" -> userService.logoutUser();
                case "AddGame" -> {
                    if (!isLoggedUser()) return;
                    gameService.addGame(new AddGameDTO(commandLine[1],
                            new BigDecimal(commandLine[2]),
                            Double.parseDouble(commandLine[3]),
                            commandLine[4],
                            commandLine[5],
                            commandLine[6],
                            commandLine[7])
                    );
                }
                case "EditGame" -> {
                    if (!isLoggedUser()) return;
                    gameService.editGame(
                            Long.parseLong(commandLine[1]),
                            new BigDecimal(commandLine[2].split("=")[1]),
                            Double.parseDouble(commandLine[3].split("=")[1])
                    );
                }
                case "DeleteGame" -> {
                    if (!isLoggedUser()) return;
                    gameService.deleteGame(Long.parseLong(commandLine[1]));
                }
                case "AllGames" -> printAllGames();
                case "DetailGame" -> printDetailGame(commandLine[1]);
                case "OwnedGames" -> printOwnedGames();
            }
        }
    }

    private void printOwnedGames() {
        if (!isLoggedUser()) return;
        List<OwnedGamesDTO> ownedGames = userService.printOwnedGames(userService.getLoggedInUser());
        if (ownedGames.isEmpty()) {
            System.out.println("You don't own any games");
            return;
        }
        ownedGames.forEach(System.out::println);
    }

    private void printDetailGame(String title) {
        if (!isLoggedUser()) return;
        DetailGameDTO detailGameDTO = gameService.detailGame(title);
        if (detailGameDTO == null) {
            System.out.println("There is no such game");
            return;
        }
        System.out.println(detailGameDTO);
    }

    private void printAllGames() {
        if (!isLoggedUser()) return;

        List<AllGamesDTO> allGames = gameService.allGames();
        if (allGames.isEmpty()) {
            return;
        }
        allGames.forEach(System.out::println);
    }

    private boolean isLoggedUser() {
        if (userService.getLoggedInUser() == null) {
            System.out.println("Please loginUser");
            return false;
        }
        return true;
    }

}
