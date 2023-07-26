package bg.softuni.gamestore.config;

import bg.softuni.gamestore.entities.games.AddGameDTO;
import bg.softuni.gamestore.entities.games.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(localDateConverter);
        modelMapper.typeMap(AddGameDTO.class, Game.class)
                .addMappings(mapper -> {
                    mapper.map(AddGameDTO::getThumbnailURL,
                            Game::setThumbnailUrl);
                    mapper.using(localDateConverter).map(AddGameDTO::getReleaseDate, Game::setReleaseDate);
                });

        return modelMapper;
    }
}
