package org.martikan.mastore.accountmanagementapi.mapper.referenceMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.martikan.mastore.accountmanagementapi.domain.Registration;
import org.martikan.mastore.accountmanagementapi.dto.referenceDTO.RegistrationReferenceDTO;

/**
 * Mapper for {@link Registration} and {@link RegistrationReferenceDTO}.
 */
@Mapper(componentModel = "spring")
public interface RegistrationReferenceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "id")
    Registration toEntity(RegistrationReferenceDTO dto);

}
