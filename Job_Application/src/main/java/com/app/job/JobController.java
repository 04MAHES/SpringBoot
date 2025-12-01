package com.app.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//     Get All Jobs
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

//    Get newJob by Id
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Adding new Job
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("job created successfully", HttpStatus.CREATED);
    }

//    Update Job by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,
                                                @RequestBody Job job){
        System.out.println("Inside Put Request");
        boolean updateStatus = jobService.updateJobById(id, job);
        if(updateStatus)
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
    }

//      Delete Job by id
    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJobById(@PathVariable("jobId") Long id) {
        boolean status = jobService.deleteJobById(id);
        if(status)
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
    }
}
