package io.github.cq.boost.service;

import io.github.cq.boost.client.ObjectDTO;
import io.github.cq.boost.client.ObjectType;
import io.github.cq.boost.entity.ObjectEntity;
import io.github.cq.boost.mapper.ObjectMapper;
import io.github.cq.boost.repository.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ObjectService {

    private static final Logger logger = LoggerFactory.getLogger(ObjectService.class);

    private ObjectRepository objectRepository;

    private ObjectMapper objectMapper;

    @Autowired
    public ObjectService(ObjectRepository objectRepository, ObjectMapper objectMapper)
    {
        this.objectRepository = objectRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Optional<ObjectDTO> get(Long id)
    {
        return findById(id).map(objectMapper::objectEntityToDTO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ObjectDTO createFromClient(final ObjectDTO objectDTO) {
        final ObjectEntity objectEntity = objectMapper.objectDTOToEntity(objectDTO);
        save(objectEntity);
        return objectMapper.objectEntityToDTO(objectEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ObjectDTO updateFromClient(final ObjectDTO objectDTO)
    {
        final ObjectEntity objectEntity = objectMapper.objectDTOToEntity(objectDTO);
        save(objectEntity);
        return objectMapper.objectEntityToDTO(objectEntity);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Optional<ObjectEntity> findById(Long id)
    {
        logger.debug("Find object entity by id {}", id);

        return objectRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(ObjectEntity entity)
    {
        logger.debug("Save object entity: {}", entity);

        verifyObject(entity);
        objectRepository.save(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id)
    {
        logger.debug("Delete object by id: {}", id);
        objectRepository.deleteById(id);
    }

    void verifyObject(ObjectEntity entity)
    {
        logger.debug("Verify object entity: {}", entity);
        // default to OBJECT type
        if (entity.getObjectType() == null)
        {
            logger.debug("Entity with no objectType specified, default to OBJECT. entity: {}", entity);

            entity.setObjectType(ObjectType.OBJECT);
        }
    }
}
