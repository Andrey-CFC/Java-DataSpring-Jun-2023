package bg.softuni.gamestore.entities.games;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddGameDTO {

    @Pattern(regexp = "[A-Z][\\w\\d\\s\\.]{3,100}")
    private String title;

    @DecimalMin(value = "0")
    private BigDecimal price;

    @Positive
    private Float size;

    @Size(min = 11, max = 11)
    private String trailerId;

    @Pattern(regexp = "(https?\\:\\/\\/.*)")
    private String thumbnailURL;

    @Size(min = 20)
    private String description;


    private String releaseDate;

    public AddGameDTO() {
    }

    public AddGameDTO(String[] commandParts) {
        this.title = commandParts[1];
        this.price = new BigDecimal(commandParts[2]);
        this.size = Float.parseFloat(commandParts[3]);
        this.trailerId = commandParts[4];
        this.thumbnailURL = commandParts[5];
        this.description = commandParts[6];
        this.releaseDate = commandParts[7];

    }


    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Float getSize() {
        return size;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
