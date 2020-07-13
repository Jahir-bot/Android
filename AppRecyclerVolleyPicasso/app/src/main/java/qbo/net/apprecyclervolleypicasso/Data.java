package qbo.net.apprecyclervolleypicasso;

public class Data {

    private Integer postId;
    private Integer id;

    @Override
    public String toString() {
        return "Data{" +
                "postId=" + postId +
                ", id=" + id +
                '}';
    }

    public Data(Integer postId, Integer id) {
        this.postId = postId;
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
