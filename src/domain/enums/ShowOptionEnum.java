package domain.enums;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */

public enum ShowOptionEnum {

    SEARCH_MOVIES("1. Search Movies"),

    VIEW_MOVIE_DETAILS("2. View Movie Details"),

    ADD_TO_FAVORITES("3. Add Movie to Favorites"),

    REMOVE_FROM_FAVORITES("4. Remove Movie from Favorites"),

    VIEW_FAVORITES("5. View Favorites"),

    SEARCH_FAVORITES("6. Search Favorites"),

    VIEW_PERSONAL_DETAILS("7. View Personal Details"),

    EXIT("8. Exit");

    private final String text;

    ShowOptionEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

