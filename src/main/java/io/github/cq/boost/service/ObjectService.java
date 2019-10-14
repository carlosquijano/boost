package io.github.cq.boost.service;

import io.github.cq.boost.entity.ObjectEntity;
import io.github.cq.boost.repository.ObjectRepository;
import io.github.cq.boost.util.ObjectTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObjectService {

    private ObjectRepository objectRepository;

    @Autowired
    public ObjectService(ObjectRepository objectRepository)
    {
        this.objectRepository = objectRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(ObjectEntity entity)
    {
        // default to OBJECT type
        entity.setObjectType(ObjectTypes.OBJECT);
        objectRepository.saveAndFlush(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(ObjectEntity entity)
    {
        objectRepository.saveAndFlush(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ObjectEntity entity)
    {
        objectRepository.delete(entity);
    }
}
