package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class AppGraphql {
    public static void main(String[] args) {
        SpringApplication.run(AppGraphql.class, args);

    }

//    @Bean
//    public GraphQLSchema schema() {
//        return SchemaParser.newParser()
//                .files("petshop.graphqls", "Types.graphqls", "InputTypes.graphqls")
//                .resolvers(new Query(), new Mutation(), new Subscription(new NewsPublisher()))
//                .scalars(new ScalarDate())
//                .dictionary("WeirdPet", WeirdPet.class)
//                .build().makeExecutableSchema();
//    }
}
