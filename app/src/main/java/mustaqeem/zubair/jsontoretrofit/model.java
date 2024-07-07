package mustaqeem.zubair.jsontoretrofit;

public class model {
    int id,userId;
    String body,title;

    public model(int id, int userId, String body, String title) {
        this.id = id;
        this.userId = userId;
        this.body = body;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
