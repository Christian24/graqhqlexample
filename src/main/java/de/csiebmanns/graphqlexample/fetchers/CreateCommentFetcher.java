package de.csiebmanns.graphqlexample.fetchers;

import de.csiebmanns.graphqlexample.data.Comment;
import de.csiebmanns.graphqlexample.data.CommentData;
import de.csiebmanns.graphqlexample.data.Data;
import de.csiebmanns.graphqlexample.data.Post;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.LinkedHashMap;

public class CreateCommentFetcher implements DataFetcher<Comment> {
    private Data data;

    public CreateCommentFetcher(Data data) {
        this.data = data;
    }
    @Override
    public Comment get(DataFetchingEnvironment environment) {
     LinkedHashMap<String, String> arguments = environment.getArgument("data");
     CommentData commentData = new CommentData(arguments);
     Post post = this.data.getPost(commentData.getPostTitle());
     Comment comment = null;
     if (post != null) {
        comment = post.addComment(commentData);
     }
     return comment;
    }
}
