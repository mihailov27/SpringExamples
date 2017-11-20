package com.mm.reactive_samples;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class TestCase_Maybe_1 {

    public static void main(String[] args) {
        Maybe pointMaybe = Maybe.create(emitter -> {
            System.out.println("Starting subscriber.");
            emitter.onSuccess(new Point(1,1));
            System.out.println("Subscriber emitted a point.");
        }).delay(2000, TimeUnit.MILLISECONDS);
        pointMaybe.subscribe(new MaybeObserver<Point>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Observer - onSubscribe() is invoked.");
            }

            @Override
            public void onSuccess(Point point) {
                System.out.println("Observer - onSuccess() is invoked -> point = " + point);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Observer - onError() is invoked. Error: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("Observer - onComplete() is invoked.");
            }
        });
        try {
            Thread.currentThread().sleep(2500);
        }catch (InterruptedException ie) {
            System.err.println("Thread interrupted: " + ie);
        }
    }
}
