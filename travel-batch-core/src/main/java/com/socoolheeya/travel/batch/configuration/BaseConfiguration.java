package com.socoolheeya.travel.batch.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing(
        dataSourceRef = "mainDataSource",
        transactionManagerRef = "batchTransactionManager",
        maxVarCharLength = 1000,
        isolationLevelForCreate = "SERIALIZABLE"
)
public class BaseConfiguration {

    private final DataSource mainDataSource;


    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
        factoryBean.setDataSource(mainDataSource);
        factoryBean.setDatabaseType("mysql");
        factoryBean.setTablePrefix("BATCH_");
        factoryBean.setTransactionManager(batchTransactionManager());

        return factoryBean.getObject();
    }

    @Bean
    public JdbcTransactionManager batchTransactionManager() {
        return new JdbcTransactionManager(mainDataSource);
    }

}
