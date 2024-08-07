package com.socoolheeya.travel.batch.core.property.job;

import com.socoolheeya.travel.batch.core.property.step.PropertyStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PropertyJob {

    @Bean
    public Job getProperty(JobRepository jobRepository,
                           PlatformTransactionManager mainTransactionManager,
                           PropertyStep propertyStep) {
        return new JobBuilder("getProperty", jobRepository)
                .start(propertyStep.getPropertyStep(jobRepository, mainTransactionManager))
                .build();
    }
}
