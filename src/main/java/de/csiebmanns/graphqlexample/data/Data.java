package de.csiebmanns.graphqlexample.data;

import java.util.List;

public class Data {
    private List<Author> authors;
    private List<Post> posts;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Author getAuthor(String name) {
       return this.authors.stream().filter(author -> author.getName().equals(name)).findFirst().orElse(null);
    }
    public Post getPost(String title) {
        return this.posts.stream().filter(post -> post.getTitle().equals(title)).findFirst().orElse(null);
    }
}
