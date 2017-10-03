package de.csiebmanns.graphqlexample.fetchers;


import de.csiebmanns.graphqlexample.data.Data;
import de.csiebmanns.graphqlexample.data.Post;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

public class PostsFetcher implements DataFetcher<List<Post>> {
    private Data data;
    public PostsFetcher(Data data) {
       this.data = data;
    }
    public List<Post> get(DataFetchingEnvironment environment) {
        return this.data.getPosts();
    }
}
