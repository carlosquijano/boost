package io.github.cq.boost.mapper;

import io.github.cq.boost.client.ObjectDTO;
import io.github.cq.boost.entity.ObjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    ObjectDTO objectEntityToDTO(ObjectEntity objectEntity);

    ObjectEntity objectDTOToEntity(ObjectDTO objectDTO);
}
