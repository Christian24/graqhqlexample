# graqhqlexample
## Quickstart
You can check if everything is working fine by running the SpringBoot project.
 The GraphQL-Endpoint is `localhost:8080/graphql`. You can test GraphQL-Queries in GraphiQL, which is located under
 `localhost:8080/graphiql`.
### Example query
```
query{
  posts {
    title,
    comments {
      content, author {name}
    },
    author {
      name,
      bio
    }
  }
}
```
### Example mutation
```
mutation {
  createComment(data: {
    postTitle: "Hello world",
    content: "Hello!",
    authorName: "Ivana"
  }) {
    content,
    author {
      name
    },
    timestamp
  }
}
```
This adds a comment by `Ivana` saying `Hello!` to the `Hello world`post.