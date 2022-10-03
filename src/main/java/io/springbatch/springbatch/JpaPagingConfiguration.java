package io.springbatch.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

//@Configuration
@RequiredArgsConstructor
public class JpaPagingConfiguration {
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
                .<Customer, Customer>chunk(2)
                .reader(customItemReader())
                .writer(customItemWriter())
                .build();

    }

    @Bean
    public ItemReader<? extends Customer> customItemReader() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstname", "A%");


        return new JpaPagingItemReaderBuilder<Customer>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(2)
                .queryString("select c from Customer c join fetch c.address")
                //.parameterValues(parameters)
                .build();
    }

    @Bean
    public ItemWriter<? super Customer> customItemWriter() {
        return items -> {
            System.out.println("itemWriter 호출됨");
            for(Customer customer : items) {
                System.out.println(customer.getAddress().getLocation());
            }
        };
    }
    */

}
