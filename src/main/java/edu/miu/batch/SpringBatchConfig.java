package edu.miu.batch;

import edu.miu.domain.Requisition;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Bean
    Job job( JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            ItemReader<Requisition> itemReader,
            ItemProcessor<Requisition, Requisition> itemProcessor,
            ItemWriter<Requisition> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-file_load")
                .<Requisition, Requisition>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ETL_load")
                .incrementer(new RunIdIncrementer())
                .start(step) //.flow() for more steps // .next()
                .build();
    }


        @Bean
        public FlatFileItemReader<Requisition> itemReader() {
            FlatFileItemReader<Requisition> flatFileItemReader = new FlatFileItemReader<>();
            flatFileItemReader.setResource(new FileSystemResource("src/main/resources/requisition.csv"));
            flatFileItemReader.setName("CSV-Reader");
            flatFileItemReader.setLinesToSkip(1);
            flatFileItemReader.setLineMapper(lineMapper());
            return flatFileItemReader;
        }


        @Bean
        public LineMapper<Requisition>  lineMapper() {

            DefaultLineMapper<Requisition> defaultLineMapper = new DefaultLineMapper<>();
            DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

            lineTokenizer.setDelimiter(",");
            lineTokenizer.setStrict(false);
            lineTokenizer.setNames(new String[]{"id", "title", "description", "empId", "projectId"});

            BeanWrapperFieldSetMapper<Requisition> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
            fieldSetMapper.setTargetType(Requisition.class);

            defaultLineMapper.setLineTokenizer(lineTokenizer);
            defaultLineMapper.setFieldSetMapper(fieldSetMapper);

            return defaultLineMapper;
        }
    }


