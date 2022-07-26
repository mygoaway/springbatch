package io.springbatch.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

// @Configuration
@RequiredArgsConstructor
public class JobExecutionConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    /*
    @Bean
    public Job job() {
        return jobBuilderFactory.get("jobExecution")
                .start(jobInstanceStep1())
                .next(jobInstanceStep2())
                .build();
    }

    @Bean
    public Step jobInstanceStep1() {
        return stepBuilderFactory.get("jobInstanceStep1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step1 was executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();

    }

    @Bean
    public Step jobInstanceStep2() {
        return stepBuilderFactory.get("jobInstanceStep2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step2 was executed");
                        // throw new RuntimeException("step2 has failed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

     */
}
