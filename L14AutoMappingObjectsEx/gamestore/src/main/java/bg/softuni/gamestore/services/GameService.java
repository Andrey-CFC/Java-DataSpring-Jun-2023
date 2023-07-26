package bg.softuni.gamestore.services;

import bg.softuni.gamestore.entities.games.AddGameDTO;
import bg.softuni.gamestore.entities.games.AllGamesDTO;
import bg.softuni.gamestore.entities.games.DetailGameDTO;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(AddGameDTO addGameDTO);

    void editGame(long id, BigDecimal price, double size);

    void deleteGame(long id);

    List<AllGamesDTO> allGames();

    DetailGameDTO detailGame(String title);


}
