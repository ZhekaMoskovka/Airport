package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "airlines")
public class Airline {
    @Id
    private int id;
    private String name;
    private double rating;
    private String planes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPlanes() {
        return planes;
    }

    public void setPlanes(String planes) {
        this.planes = planes;
    }
}