package rc.legostore.model;

import java.util.Collection;

import lombok.Setter;

//@Setter
public class ProductReview {
    private String userName;
    private int rating;

    public ProductReview(String userName, int rating) {
        this.userName = userName;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
