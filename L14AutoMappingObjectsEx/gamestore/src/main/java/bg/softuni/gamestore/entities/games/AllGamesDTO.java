package bg.softuni.gamestore.entities.games;

import java.math.BigDecimal;

public class AllGamesDTO {
    private String title;
    private BigDecimal price;

    public AllGamesDTO() {
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

    @Override
    public String toString() {
        return title + " " + price;
    }
}
