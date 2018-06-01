package model;

public class Message {

    private String image, timestamp, sender;

    public  Message (String image, String timestamp, String sender) {
        this.image = image;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getImage() {
        return image;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return sender;
    }
}
