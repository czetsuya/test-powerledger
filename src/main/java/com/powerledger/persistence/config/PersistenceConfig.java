package com.powerledger.persistence.config;

import com.powerledger.persistence.repositories.RepositoriesConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    basePackageClasses = {
        RepositoriesConfig.class
    }
)
@EnableTransactionManagement
public class PersistenceConfig {

}
