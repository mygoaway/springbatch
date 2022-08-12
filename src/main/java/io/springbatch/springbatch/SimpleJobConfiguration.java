package io.springbatch.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

//@Configuration
@RequiredArgsConstructor
public class SimpleJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    /*
    @Bean
    public Job job() {
        return jobBuilderFactory.get("batchJob")
                .start(step1())
                .next(step2())
                .next(step3())
                .next(step4()) // chunk 기반 tasklet 추가
                .next(step5())
                //.validator(new CustomJobParametersValidator()) // 검증에서 실패하면 Job 실행 자체가 안됨(Batch 관련 DB 저장안됨)
                //.validator(new DefaultJobParametersValidator(new String[]{"name", "date"}, new String[]{"count"}))
                //.preventRestart() // 재시작을 하지 않음 (restartable = false)
                .incrementer(new CustomJobParametersIncrement()) // run.id 값은 계속 변하기 때문에 동일한 파라미터를 넘겨주더라도 항상 배치가 실행된다.
                .build(); // SimpleJob 객체 생성(step으로만 구성이 가능하다.), SimpleJob 클래스는 Job 인터페이스의 자식
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step1 was executed");
                    return RepeatStatus.FINISHED;
                })
                .allowStartIfComplete(true) // Step의 이전 성공 여부와 상관없이 항상 step을 실행하기 위한 설정(실행마다 유효성을 검증하거나 사전 작업이 꼭 필요한 Step 등은 지정한다.)
                .build();

    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step2 was executed");
                    //throw new RuntimeException("step2 failed");
                     return RepeatStatus.FINISHED;
                })
                .startLimit(3) // Step의 실행 횟수를 조정할 수 있다.
                .build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step3 was executed");
                    return RepeatStatus.FINISHED; // Tasklet 종료( null로 반환하면 RepeatStatus.FINISHED로 해석됨)
                    // RepeatStatus.CONTINUABLE - Tasklet 반복(무한루프를 주의해야함, 조건으로 분기처리 필수!)
                })
                .build();
    }

    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4")
                .<String, String>chunk(10) // 10개 단위로 짜름
                .reader(new ListItemReader<>(Arrays.asList("item1", "item2", "item3", "item4", "item5")))
                .processor(new ItemProcessor<String, String>() {
                    @Override
                    public String process(String item) throws Exception {
                        return item.toUpperCase();
                    }
                })
                .writer(new ItemWriter<String>() {
                    @Override
                    public void write(List<? extends String> items) throws Exception {
                        items.forEach(item -> System.out.println("item = " + item));
                    }
                })
                .build();
    }

    @Bean
    public Step step5() {
        return stepBuilderFactory.get("step5")
                .tasklet(new CustomTasklet())
                .build();
    }
    */
}
