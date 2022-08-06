package io.springbatch.springbatch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomJobParametersIncrement implements JobParametersIncrementer {
    static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-hhmmss");
    @Override
    public JobParameters getNext(JobParameters parameters) {

        String id = format.format(new Date());

        JobParameters jobParameters = new JobParametersBuilder()
                        .addString("run.id", id)
                        .toJobParameters();
        return jobParameters;
    }
}
