package spring.batch.exam.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WithParamJobConfig  {

    @Bean
    public Job WithParamJob(JobRepository jobRepository, Step withParamStep1) {
        return new JobBuilder("withParamJob", jobRepository)
                .start(withParamStep1)
                .build();
    }

    @Bean
    @JobScope
    public Step withParamStep1(Tasklet withParamStep1Tasklet, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("withParamStep1", jobRepository)
                .tasklet(withParamStep1Tasklet, transactionManager)
                .build();
    }

    @Bean
    @StepScope
    public Tasklet withParamStep1Tasklet(
            @Value("#{jobParameters['name']}") String name,
            @Value("#{jobParameters['age']}") Long age
    ) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                log.debug("name = {}, age = {}", name, age);

                return RepeatStatus.FINISHED;
            }
        };
    }
//    @Bean
//    @StepScope
//    public Tasklet withParamStep1Tasklet2(
//            @Value("#{jobParameters['name']}") String name,
//            @Value("#{jobParameters['age']}") Integer age
//    ) {
//        return (contribution, chunkContext) -> {
//            log.debug("name = {}, age = {}", name, age);
//
//            return RepeatStatus.FINISHED;
//        };
//    }
}
