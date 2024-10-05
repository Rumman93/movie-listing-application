package domain.model;

import java.math.BigDecimal;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class Movie {

    private BigDecimal budget;
    private String cast;
    private String category;
    private String releaseDate;
    private String title;

    public Movie(BigDecimal budget, String cast, String category, String releaseDate, String title) {
        this.budget = budget;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public Movie() {
    }


    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
