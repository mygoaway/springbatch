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

@Configuration
@RequiredArgsConstructor
public class JobInstanceConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("jobInstance")
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
                        JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
                        String name = jobParameters.getString("name");
                        Long seq = jobParameters.getLong("seq");
                        Date data = jobParameters.getDate("data");
                        Double age = jobParameters.getDouble("age");

                        System.out.println("name = " + name);
                        System.out.println("seq = " + seq);
                        System.out.println("data = " + data);
                        System.out.println("age = " + age);

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
                        Map<String, Object> jobParameters1 = chunkContext.getStepContext().getJobParameters();
                        String name1 = (String) jobParameters1.get("name");
                        System.out.println("name1 = " + name1);

                        System.out.println("step2 was executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}
