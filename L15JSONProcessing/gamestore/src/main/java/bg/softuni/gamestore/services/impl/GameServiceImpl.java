package bg.softuni.gamestore.services.impl;

import bg.softuni.gamestore.entities.games.Game;
import bg.softuni.gamestore.entities.games.AddGameDTO;
import bg.softuni.gamestore.repositories.GameRepository;
import bg.softuni.gamestore.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public void addGame(AddGameDTO addGameDTO) {
        ModelMapper mapper = new ModelMapper();
        Game game = mapper.map(addGameDTO, Game.class);
        gameRepository.save(game);
    }

    @Override
    public void editGame(long id, BigDecimal price, float size) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        if (size < 0 && price.compareTo(BigDecimal.ZERO) != 0) {
            System.out.println("Enter positive price and size");
            return;

        }
        game.get().setPrice(price);
        game.get().setSize(size);
        gameRepository.save(game.get());
        System.out.println("Edited " + game.get().getTitle());
    }

    @Override
    public void deleteGame(long id) {

    }
}
