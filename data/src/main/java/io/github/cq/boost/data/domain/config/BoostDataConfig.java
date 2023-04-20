package io.github.cq.boost.data.domain.config;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@ComponentScan(
        value = {
                "io.github.cq.boost.**.domain.**.repository.**",
                "io.github.cq.boost.**.domain.**.service.**",
                "io.github.cq.boost.**.domain.**.entity.**",
        }
)
@EnableJpaRepositories(
        value = {
                "io.github.cq.boost.**.domain.**.repository.**"
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "io.github.cq.boost.data.domain.repository.*"),
        },
        repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class BoostDataConfig {
}
