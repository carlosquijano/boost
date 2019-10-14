package io.github.cq.boost.test.component;

import io.github.cq.boost.entity.ObjectEntity;
import io.github.cq.boost.repository.ObjectRepository;
import io.github.cq.boost.service.ObjectService;
import io.github.cq.boost.util.ObjectTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;

@RunWith(MockitoJUnitRunner.class)
public class ObjectServiceTest  {
    @Mock
    ObjectRepository objectRepository;

    @InjectMocks
    ObjectService objectService;

    @Test
    public void serviceShouldAddNewEntity()
    {
        // given
        final ObjectEntity sampleObject = buildSampleEntity();
        // when
        objectService.add(sampleObject);
        // then
        then(objectRepository).should(atLeastOnce()).saveAndFlush(sampleObject);
        assertThat(sampleObject.getObjectType()).isEqualByComparingTo(ObjectTypes.OBJECT);
    }

    @Test
    public void serviceShouldUpdateEntity()
    {
        // given
        final ObjectEntity sampleEntity = buildSampleEntity();
        // when
        objectService.update(sampleEntity);
        // then
        then(objectRepository).should(atLeastOnce()).saveAndFlush(sampleEntity);
    }

    @Test
    public void serviceShouldDeleteEntity()
    {
        // given
        final ObjectEntity sampleEntity = buildSampleEntity();
        // when
        objectService.delete(sampleEntity);
        // then
        then(objectRepository).should(atLeastOnce()).delete(sampleEntity);
    }

    private ObjectEntity buildSampleEntity()
    {
        final ObjectEntity entity = new ObjectEntity();
        entity.setId(1L);
        entity.setCreatedBy("system");
        entity.setCreatedOn(LocalTime.now());
        entity.setTitle("Sample object");
        entity.setSummary("Sample object for testing");
        return entity;
    }
}
