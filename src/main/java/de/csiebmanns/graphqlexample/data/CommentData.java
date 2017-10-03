package de.csiebmanns.graphqlexample.data;

import java.util.LinkedHashMap;

public class CommentData {

    private String authorName;
    private String content;
    private String postTitle;

    public CommentData(LinkedHashMap<String, String> map) {
        this.authorName = map.get("authorName");
        this.content = map.get("content");
        this.postTitle = map.get("postTitle");
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

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
