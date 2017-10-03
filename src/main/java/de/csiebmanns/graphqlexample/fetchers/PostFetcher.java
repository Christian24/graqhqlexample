package de.csiebmanns.graphqlexample.fetchers;

import de.csiebmanns.graphqlexample.data.Post;
import de.csiebmanns.graphqlexample.data.Data;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class PostFetcher implements DataFetcher<Post> {
    private Data data;

    public PostFetcher(Data data) {
       this.data = data;
    }
    @Override
    public Post get(DataFetchingEnvironment environment) {
       String title = environment.getArgument("title");
       return this.data.getPost(title);
    }
}
