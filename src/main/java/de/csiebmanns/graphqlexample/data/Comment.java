package de.csiebmanns.graphqlexample.data;




public class Comment implements HasAuthorName {
    private String authorName;
    private String content;
    private long timestamp;


    public Comment() {

    }
    public Comment(String authorName, String content) {
        this.authorName = authorName;
        this.content = content;
        this.timestamp = System.currentTimeMillis() / 1000L;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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


}
