package org.martikan.mastore.accountmanagementapi.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.martikan.mastore.accountmanagementapi.dto.referenceDTO.RegistrationReferenceDTO;
import org.springframework.messaging.handler.annotation.Payload;

import javax.mail.MessagingException;

public interface RegistrationService {

    void consumeMessages(ConsumerRecord<String, RegistrationReferenceDTO> consumerRecord,
                         @Payload RegistrationReferenceDTO payload) throws MessagingException;

    boolean verifyVerificationToken(final String token);

}
