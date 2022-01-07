package org.martikan.mastore.accountmanagementapi.controller;

import lombok.RequiredArgsConstructor;
import org.martikan.mastore.accountmanagementapi.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/verify/{token}")
    public ResponseEntity<Boolean> verifyRegistration(@PathVariable("token") final String token) {

        var verified = registrationService.verifyVerificationToken(token);

        return ResponseEntity.ok(verified);
    }

}
