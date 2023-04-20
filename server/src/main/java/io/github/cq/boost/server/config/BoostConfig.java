package io.github.cq.boost.server.config;

import io.github.cq.boost.data.domain.config.BoostDataConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import(BoostDataConfig.class)
public class BoostConfig {
}
