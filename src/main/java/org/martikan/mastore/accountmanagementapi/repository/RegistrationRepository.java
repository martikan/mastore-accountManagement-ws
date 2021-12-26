package org.martikan.mastore.accountmanagementapi.repository;

import org.martikan.mastore.accountmanagementapi.domain.Registration;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends ReactiveCrudRepository<Registration, String> {
}
