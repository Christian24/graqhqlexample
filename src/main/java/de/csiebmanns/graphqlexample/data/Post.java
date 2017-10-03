package de.csiebmanns.graphqlexample.data;



import java.util.List;

public class Post implements HasAuthorName {
    private String title;
    private String content;
    private long timestamp;
    private String authorName;
    private List<Comment> comments;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comment addComment(CommentData data) {
        Comment comment = new Comment(data);
        this.comments.add(comment);
        return comment;
    }


}
