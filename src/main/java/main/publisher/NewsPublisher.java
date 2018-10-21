package main.publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import main.models.NewsUpdate;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class NewsPublisher {

    private Random random = new Random();

    public Publisher<NewsUpdate> getPublisher() {

        Observable<NewsUpdate> newsUpdateObservable = Observable.create(emitter -> {

            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(createNewDummyNews(emitter), 0, 2, TimeUnit.SECONDS);

        });


        ConnectableObservable<NewsUpdate> connectableObservable = newsUpdateObservable.share().publish();
        connectableObservable.connect();

        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }


    private Runnable createNewDummyNews(ObservableEmitter<NewsUpdate> emitter) {
       return () -> {

           int randomNumber = random.nextInt(10);
           emitter.onNext(new NewsUpdate("news content" + randomNumber, randomNumber));

       };
    }


}
