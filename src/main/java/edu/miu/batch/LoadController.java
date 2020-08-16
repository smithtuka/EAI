package edu.miu.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/batch")
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job ;



    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobInstanceAlreadyCompleteException, org.springframework.batch.core.repository.JobRestartException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);

        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("Avengers JobExecution: " + jobExecution.getStatus());

        System.out.println("Avengers Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("........................");
        }

        return jobExecution.getStatus();
    }
}
