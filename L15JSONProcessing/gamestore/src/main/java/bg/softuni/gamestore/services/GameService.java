package bg.softuni.gamestore.services;

import bg.softuni.gamestore.entities.games.AddGameDTO;

import java.math.BigDecimal;

public interface GameService {
    void addGame(AddGameDTO addGameDTO);

    void editGame(long id, BigDecimal price, float size);

    void deleteGame(long id);

//    List<AllGamesDto> allGames();
//
//    DetailGameDto detailGame(String title);


}
