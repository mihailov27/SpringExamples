package com.mm.reactive_samples;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class TestCase_Flowable_1 {

    public static void main(String[] args) {

        // create a subscriber
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Subscribe.");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.printf("Entry %d\n", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.printf("Error: %s", throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };

        // create flowable
        Flowable.fromArray(new Integer[]{1,2,3,4,5}).delay(1000, TimeUnit.MILLISECONDS)
                .subscribe(subscriber);
        try {
            Thread.sleep(2000);
        }catch (Exception e) {}

    }
}
