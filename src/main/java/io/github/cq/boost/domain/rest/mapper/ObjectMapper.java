package io.github.cq.boost.domain.rest.mapper;

import io.github.cq.boost.domain.model.ObjectDTO;
import io.github.cq.boost.domain.entity.ObjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    ObjectDTO objectEntityToDTO(ObjectEntity objectEntity);

    ObjectEntity objectDTOToEntity(ObjectDTO objectDTO);
}
