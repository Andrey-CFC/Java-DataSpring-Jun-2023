package bg.softuni.gamestore.entities.games;

import java.math.BigDecimal;

public class AddGameDTO {
    private String title;
    private BigDecimal price;
    private Float size;
    private String trailerId;
    private String thumbnailURL;
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
