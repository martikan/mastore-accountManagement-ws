package org.martikan.mastore.accountmanagementapi.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for sending verified accounts via kafka.
 */
@Builder
@Data
public class VerifiedAccountDTO implements Serializable {

    private static final long serialVersionUID = -8484048688088470850L;

    private Long userId;

}
