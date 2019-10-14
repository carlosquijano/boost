package io.github.cq.boost.controller;

import io.github.cq.boost.client.ObjectDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObjectController {

    private static final Logger logger = LoggerFactory.getLogger(ObjectController.class);

    @PostMapping("/create")
    public ObjectDTO create(@RequestBody ObjectDTO body)
    {
        logger.debug("create object using body: {0}", body);
        // not yet implemented
        return body;
    }

    @PostMapping("/update")
    public ObjectDTO update(@RequestBody ObjectDTO body)
    {
        logger.debug("update object using body: {0}", body);
        // not yet implemented
        return body;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id)
    {
        logger.debug("delete object idenfied with id: {0}", id);
        // not yet implemented
    }
}
