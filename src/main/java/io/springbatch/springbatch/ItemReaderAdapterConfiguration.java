package io.springbatch.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

//@Configuration
@RequiredArgsConstructor
public class ItemReaderAdapterConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

/*
    @Bean
    public Job job() {
        return jobBuilderFactory.get("JpaBatchJob")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String>chunk(2)
                .reader(customItemReader())
                .writer(customItemWriter())
                .build();

    }

    @Bean
    public ItemReader<? extends String> customItemReader() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstname", "A%");

        ItemReaderAdapter<String> reader = new ItemReaderAdapter<>();
        reader.setTargetObject(new CustomerService());
        reader.setTargetMethod("customRead");

        return reader;
    }

    @Bean
    public ItemWriter<? super String> customItemWriter() {
        return items -> {
            for(String item : items) {
                System.out.println(item.toString());
            }
        };
    }*/
}
