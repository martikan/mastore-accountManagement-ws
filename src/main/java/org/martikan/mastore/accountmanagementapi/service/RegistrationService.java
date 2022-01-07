package org.martikan.mastore.accountmanagementapi.service;

import org.martikan.mastore.accountmanagementapi.dto.referenceDTO.RegistrationReferenceDTO;

import javax.mail.MessagingException;

public interface RegistrationService {

    void consumeMessages(final RegistrationReferenceDTO dto) throws MessagingException;

    boolean verifyVerificationToken(final String token);

}
