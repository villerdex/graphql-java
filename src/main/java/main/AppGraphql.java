package main;

import com.coxautodev.graphql.tools.SchemaParser;
import main.models.ScalarDate;
import main.publisher.NewsPublisher;
import main.resolvers.Mutation;
import main.resolvers.Query;
import main.resolvers.Subscription;
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

        SchemaParser.newParser()
                .files("petshop.graphqls", "Types.graphqls", "InputTypes.graphqls")
                .resolvers(new Query(), new Mutation(), new Subscription(new NewsPublisher()))
                .scalars(new ScalarDate())
                .build().makeExecutableSchema();

    }
}
