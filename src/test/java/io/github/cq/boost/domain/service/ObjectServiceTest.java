package io.github.cq.boost.domain.service;

import io.github.cq.boost.domain.entity.ObjectEntity;
import io.github.cq.boost.domain.repository.ObjectRepository;
import io.github.cq.boost.domain.service.ObjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ObjectServiceTest
{
    @Mock
    ObjectRepository objectRepository;

    @InjectMocks
    ObjectService objectService;

    @Test
    public void serviceShouldFindEntityById()
    {
        // given
        ObjectEntity sampleObject = mock(ObjectEntity.class);
        given(sampleObject.getId()).willReturn(1L);
        given(objectRepository.findById(anyLong())).willReturn(Optional.of(sampleObject));

        // when
        Optional<ObjectEntity> returnedObject = objectService.findById(anyLong());

        // then
        then(objectRepository).should(atLeastOnce()).findById(anyLong());
        assertThat(returnedObject).isPresent();
        assertThat(returnedObject.get().getId()).isNotNull();
    }

    @Test
    public void serviceShouldDeleteEntity()
    {
        // given
        ObjectEntity sampleEntity = mock(ObjectEntity.class);
        given(sampleEntity.getId()).willReturn(1L);

        // when
        objectService.delete(sampleEntity.getId());

        // then
        then(objectRepository).should(atLeastOnce()).deleteById(anyLong());
    }
}