package de.csiebmanns.graphqlexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.csiebmanns.graphqlexample.fetchers.AuthorFetcher;
import de.csiebmanns.graphqlexample.fetchers.PostFetcher;
import de.csiebmanns.graphqlexample.data.Data;
import de.csiebmanns.graphqlexample.fetchers.PostsFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

@SpringBootConfiguration
public class Configuration {
    @Bean
    public ClassLoader getClassLoader() {
     return getClass().getClassLoader();
    }
    @Bean
    public TypeDefinitionRegistry getRegistry(ClassLoader loader) {
        File schemaFile = new File(loader.getResource("schema.graphqls").getFile());
        SchemaParser parser = new SchemaParser();
       return parser.parse(schemaFile);
    }

    @Bean
    public PostFetcher getPostFetcher(Data repository) {
        return new PostFetcher(repository);
    }
    @Bean
    public AuthorFetcher getAuthorFetcher(Data data) {
        return new AuthorFetcher(data);
    }
    @Bean
    public PostsFetcher getPostsFetcher(Data repository) {
        return new PostsFetcher(repository);
    }
    @Bean
    public RuntimeWiring buildRuntimeWiring(PostsFetcher postsFetcher,
                                            PostFetcher postFetcher, AuthorFetcher authorFetcher) {
        return RuntimeWiring.newRuntimeWiring().type("Query",
                typeWiring -> typeWiring.dataFetcher("posts",postsFetcher)
                        .dataFetcher("post", postFetcher))
                .type("Post", typeWiring -> typeWiring.dataFetcher("author", authorFetcher))
                .type("Comment", typeWiring -> typeWiring.dataFetcher("author", authorFetcher))
                .build();
    }
    @Bean
  public GraphQLSchema buildSchema(TypeDefinitionRegistry registry, RuntimeWiring wiring) {
        SchemaGenerator generator = new SchemaGenerator();
return generator.makeExecutableSchema(registry, wiring);

  }
   @Bean
   public Data getData(ClassLoader loader) throws IOException {
      ObjectMapper objectMapper = new ObjectMapper();

       File file = new File(loader.getResource("data.json").getFile());
       Data data = null;
       if(file != null) {
           data = objectMapper.readValue(file, Data.class);
       }
       return data;
   }
}
