package org.martikan.mastore.accountmanagementapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendMessage(final String topicName, final Object message) {
        kafkaTemplate.send(topicName, message);
    }
}
