package edu.miu.batch;//package edu.miu.reporting;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchRequisition {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    Job simpleJob(){
//        return jobBuilderFactory.get("simpleJob")
//                .start(simpleStep())
//                .build();
//    }
//
//    private Step simpleStep() {
//        return stepBuilderFactory
//                .get("simpleStep")
//                .tasklet(
//                        (StepContribution contribution, ChunkContext chunk) -> {
//                            System.out.println(" Avengers - all about quality");
//                            return RepeatStatus.FINISHED;
//                        }
//                )
//                .build();
//    }
//}
