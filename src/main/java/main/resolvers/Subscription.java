package main.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import main.models.NewsUpdate;
import main.publisher.NewsPublisher;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;


@Component
public class Subscription implements GraphQLSubscriptionResolver {

    private NewsPublisher newsPublisher;

    public Subscription(NewsPublisher newsPublisher) {
        this.newsPublisher = newsPublisher;
    }

    Publisher<NewsUpdate> getNews() {
        return newsPublisher.getPublisher();
    }

}


