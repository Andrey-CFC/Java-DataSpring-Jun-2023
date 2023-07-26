package bg.softuni.gamestore.services.impl;

import bg.softuni.gamestore.Util.ValidationUtil;
import bg.softuni.gamestore.entities.games.AddGameDTO;
import bg.softuni.gamestore.entities.games.AllGamesDTO;
import bg.softuni.gamestore.entities.games.DetailGameDTO;
import bg.softuni.gamestore.entities.games.Game;
import bg.softuni.gamestore.repositories.GameRepository;
import bg.softuni.gamestore.services.GameService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(AddGameDTO addGameDTO) {
        if (!isValidEntity(addGameDTO)) return;
        Game game = mapper.map(addGameDTO, Game.class);
        gameRepository.save(game);
    }


    @Override
    public void editGame(long id, BigDecimal price, double size) {
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
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        gameRepository.delete(game.get());
    }

    @Override
    public List<AllGamesDTO> allGames() {
        return gameRepository.findAll().stream()
                .map(g -> mapper.map(g, AllGamesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetailGameDTO detailGame(String title) {
        Game game = gameRepository.findGameByTitle(title);
        DetailGameDTO detailGameDTO = null;
        if (game != null) {
            detailGameDTO = mapper.map(game, DetailGameDTO.class);
        }
        return detailGameDTO;
    }


    private <E> boolean isValidEntity(E entity) {
        Set<ConstraintViolation<E>> violations = validationUtil.violation(entity);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return false;
        }
        return true;
    }

}
