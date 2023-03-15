package io.github.cq.boost.domain.rest.controller;

import io.github.cq.boost.BoostDataException;
import io.github.cq.boost.domain.model.ObjectDTO;
import io.github.cq.boost.domain.service.ObjectService;
import io.github.cq.boost.util.BoostMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(BoostMappings.OBJECT_ROUTE)
public class ObjectController implements PersistenceAwareController<ObjectDTO, Long>
{
    private static final Logger logger = LoggerFactory.getLogger(ObjectController.class);

    private final ObjectService objectService;

    public ObjectController(final ObjectService objectService)
    {
        this.objectService = objectService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ObjectDTO> show(final @PathVariable Long id) throws BoostDataException
    {
        logger.debug("show object by id: {}", id);

        final ObjectDTO objectDTO = objectService.get(id)
                .orElseThrow(() -> new BoostDataException("No object found"));

        logger.debug("Returning client object {}", objectDTO);
        return ResponseEntity.ok(objectDTO);
    }

    @Override
    @PostMapping(BoostMappings.CREATE_ROUTE)
    public ResponseEntity<ObjectDTO> create(final @RequestBody ObjectDTO body) throws BoostDataException {
        logger.debug("create object using body: {}", body);

        final ObjectDTO objectDTO = objectService.createFromClient(body);

        return ResponseEntity.ok(objectDTO);
    }

    @Override
    @PostMapping(BoostMappings.UPDATE_ROUTE)
    public ResponseEntity<ObjectDTO> update(final @RequestBody ObjectDTO body)
    {
        logger.debug("update object using body: {}", body);

        final ObjectDTO objectDTO = objectService.updateFromClient(body);
        return ResponseEntity.ok(objectDTO);
    }

    @Override
    @DeleteMapping(BoostMappings.DELETE_ROUTE + "/{id}")
    public void delete(final @PathVariable Long id)
    {
        logger.debug("delete object by id: {}", id);
    }
}
