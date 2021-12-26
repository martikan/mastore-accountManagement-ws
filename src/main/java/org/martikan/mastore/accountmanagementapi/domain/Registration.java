package org.martikan.mastore.accountmanagementapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Entity for store newly registered users.
 * If a user is in this `registrations` collection,
 * then the user has to validate her/his e-mail address.
 * Otherwise, the registration will be canceled.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "registrations")
public class Registration {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime mustValidateTill;

}
