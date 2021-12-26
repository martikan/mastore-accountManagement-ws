package org.martikan.mastore.accountmanagementapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.martikan.mastore.accountmanagementapi.domain.Registration;
import org.martikan.mastore.accountmanagementapi.dto.referenceDTO.RegistrationReferenceDTO;
import org.martikan.mastore.accountmanagementapi.mapper.referenceMapper.RegistrationReferenceMapper;
import org.martikan.mastore.accountmanagementapi.repository.RegistrationRepository;
import org.martikan.mastore.accountmanagementapi.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final String MAIL_SUBJECT = "Email verification.";

    @Value(value = "${server.address}")
    private String serverAddress;

    @Value(value = "${server.port}")
    private String serverPort;

    @Value(value = "${spring.application.name}")
    private String appName;

    private final RegistrationReferenceMapper referenceMapper;

    private final RegistrationRepository registrationRepository;

    private final MailSenderService mailSenderService;

    private final JwtUtils jwtUtils;

    @Override
    @KafkaListener(topics = "registeredUsers", groupId = "${kafka.groupId}")
    public void consumeMessages(final RegistrationReferenceDTO dto) throws MessagingException {

        var generatedVerificationLink = generateVerificationLink(dto.getEmail());
        log.debug("Generated verification link: " + generatedVerificationLink);
//        mailSenderService.sendMail(dto.getEmail(), MAIL_SUBJECT, String.format("activate with this link: <a href=\"%s\">verify email address</a>", generatedVerificationLink));

        mergeRegistration(referenceMapper.toEntity(dto));
    }

    private void mergeRegistration(final Registration registration) {
        registrationRepository.save(registration);
    }

    private String generateVerificationLink(final String email) {
        return "http://" + serverAddress + ":" + serverPort + "/" + appName +
                "/registrations/verify/" + jwtUtils.generateVerificationToken(email);
    }

}
