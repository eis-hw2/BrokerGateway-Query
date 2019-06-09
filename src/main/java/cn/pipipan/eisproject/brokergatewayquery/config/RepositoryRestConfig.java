package cn.pipipan.eisproject.brokergatewayquery.config;

import cn.pipipan.eisproject.brokergatewayquery.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
class SpringDataRestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(
                    RepositoryRestConfiguration config) {
                config.exposeIdsFor(CancelOrder.class, Future.class, LimitOrder.class, MarketOrder.class,
                        MarketDepth.class, OrderBlotter.class, StopOrder.class);
            }
        };
    }
}

