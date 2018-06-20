package model;

public class ProfileBs {

    private String name, surname, pic;
    private float rating;

    public ProfileBs(String name, String surname, String pic) {
        this.name=name;
        this.surname=surname;
        this.pic= pic;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPic() {
        return pic;
    }

    public float getRating() {
        return rating;
    }
}
