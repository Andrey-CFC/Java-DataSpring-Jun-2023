package bg.softuni.gamestore.entities.games;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddGameDTO {

    @Pattern(regexp = "[A-Z][\\w\\d\\s\\.]{3,100}", message = "Title – has to begin with an uppercase letter and must have length between 3 and 100 symbols.")
    private String title;

    @DecimalMin(value = "0", message = "Must be a positive number.")
    private BigDecimal price;

    @Positive(message = "Must be a positive number.")
    private Double size;

    @Size(min = 11, max = 11, message = "Enter valid trailer ID. Must be exactly 11 characters.")
    private String trailerId;

    @Pattern(regexp = "(https?\\:\\/\\/.*)", message = "Enter valid path. Must be starting with http://, https://")
    private String thumbnailUrl;

    @Size(min = 20, message = "Enter valid description. Must be at least 20 symbols.")
    private String description;


    private String releaseDate;

    public AddGameDTO() {
    }

    public AddGameDTO(String title, BigDecimal price, Double size, String trailerId, String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailerId = trailerId;
        this.thumbnailUrl = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
