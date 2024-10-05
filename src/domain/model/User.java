package domain.model;

import java.util.List;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class User {

    String email;
    List<Movie> favorites;

    public User(String email, List<Movie> favorites) {
        this.email = email;
        this.favorites = favorites;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Movie> favorites) {
        this.favorites = favorites;
    }
}
