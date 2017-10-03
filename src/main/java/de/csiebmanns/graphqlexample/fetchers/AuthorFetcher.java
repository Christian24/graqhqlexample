package de.csiebmanns.graphqlexample.fetchers;

import de.csiebmanns.graphqlexample.data.Author;
import de.csiebmanns.graphqlexample.data.Data;
import de.csiebmanns.graphqlexample.data.HasAuthorName;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class AuthorFetcher implements DataFetcher<Author> {
    private Data data;
    public AuthorFetcher(Data data) {
        this.data = data;
    }
    @Override
    public Author get(DataFetchingEnvironment environment) {
        HasAuthorName object = environment.getSource();
    String authorName = object.getAuthorName();
        return this.data.getAuthor(authorName);
    }
}
