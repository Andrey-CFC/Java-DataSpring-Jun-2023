package bg.softuni.gamestore.entities.games;

public class OwnedGamesDTO {
    private  String title;

    public OwnedGamesDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  title;
    }
}
