package io.github.cq.boost.controller;

import io.github.cq.boost.BoostDataException;
import io.github.cq.boost.client.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface CrudAwareController<T extends ClientDTO, ID>
{
    ResponseEntity<T> show(final ID id) throws BoostDataException;

    ResponseEntity<T> create(final T o) throws BoostDataException;

    ResponseEntity<T> update(final T o) throws BoostDataException;

    void delete(final ID id) throws BoostDataException;
}
