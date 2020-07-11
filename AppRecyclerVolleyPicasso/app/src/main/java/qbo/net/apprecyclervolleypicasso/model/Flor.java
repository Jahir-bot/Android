package qbo.net.apprecyclervolleypicasso.model;

public class Flor {

    private String tag;
    private String user;
    private String imageurl;

    public Flor(String tag, String user, String imageurl) {
        this.tag = tag;
        this.user = user;
        this.imageurl = imageurl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
