package org.martikan.mastore.accountmanagementapi.service;

public interface KafkaService {

    void sendMessage(final String topicName, final Object message);

}
