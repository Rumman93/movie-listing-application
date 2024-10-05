package domain.model;

import java.util.List;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class User {

    private String email;
    private List<Movie> favoriteList;

    public User(String email, List<Movie> favoriteList) {
        this.email = email;
        this.favoriteList = favoriteList;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Movie> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Movie> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void addToFavoriteList(Movie movie) {
        favoriteList.add(movie);
    }

    public void removeFromFavoriteList(Movie movie) {
        favoriteList.remove(movie);
    }
}
