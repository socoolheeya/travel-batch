package com.socoolheeya.travel.batch.property.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PropertyStep {


    public Step getPropertyStep(JobRepository jobRepository, PlatformTransactionManager mainTransactionManager) {
        return new StepBuilder("getPropertyStep", jobRepository)
                .<String, String>chunk(10, mainTransactionManager)
//                .reader()
//                .writer()
                .build();
    }

}
