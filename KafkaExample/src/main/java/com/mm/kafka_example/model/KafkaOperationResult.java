package com.mm.kafka_example.model;

public final class KafkaOperationResult<T> {

    private final T result;

    private final KafkaOperationError error;

    private final boolean isSuccessful;


    protected KafkaOperationResult(T result, KafkaOperationError error) {
        this.result = result;
        this.error = error;
        this.isSuccessful = result!=null;
    }

    public static <M> KafkaOperationResult<M> success(M result) {
        return new KafkaOperationResult<M>(result, null);
    }

    public static KafkaOperationResult error(KafkaOperationError kafkaOperationError) {
        return new KafkaOperationResult(null, kafkaOperationError);
    }

    public T getResult() {
        return result;
    }

    public KafkaOperationError getError() {
        return error;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }
}
