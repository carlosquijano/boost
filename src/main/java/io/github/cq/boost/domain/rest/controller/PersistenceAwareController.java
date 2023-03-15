package io.github.cq.boost.domain.rest.controller;

import io.github.cq.boost.BoostDataException;
import io.github.cq.boost.domain.model.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface PersistenceAwareController<T extends ClientDTO, ID>
{
    ResponseEntity<T> show(final ID id) throws BoostDataException;

    ResponseEntity<T> create(final T o) throws BoostDataException;

    ResponseEntity<T> update(final T o) throws BoostDataException;

    void delete(final ID id) throws BoostDataException;
}
