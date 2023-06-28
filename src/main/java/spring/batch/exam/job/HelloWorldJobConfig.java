//package spring.batch.exam.job;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@RequiredArgsConstructor
//@Slf4j
//public class HelloWorldJobConfig {
//    private final JobRepository jobRepository;
//    private final PlatformTransactionManager transactionManager;
//
//    @Bean
//    public Job helloWorldjob(Step helloWorldStep1, Step helloWorldStep2) {
//        return new JobBuilder("helloWorldJob", jobRepository)
////                .incrementer(new RunIdIncrementer()) //계속해서 id 업데이트 (내용이같아도)
//                .start(helloWorldStep1)
//                .next(helloWorldStep2)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step helloWorldStep1(Tasklet helloWorldStep1Tasklet) {
//        return new StepBuilder("helloWorldStep1", jobRepository)
//                .tasklet(helloWorldStep1Tasklet, transactionManager)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public Tasklet helloWorldStep1Tasklet(
//    ) {
//        return (contribution, chunkContext) -> {
//            System.out.println("Hello World one!");
//
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    @JobScope
//    public Step helloWorldStep2() {
//        return new StepBuilder("helloWorldStep2", jobRepository)
//                .tasklet(helloWorldStep2Tasklet(), transactionManager)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public Tasklet helloWorldStep2Tasklet() {
//        return (contribution, chunkContext) -> {
//            System.out.println("Hello World two!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//}
