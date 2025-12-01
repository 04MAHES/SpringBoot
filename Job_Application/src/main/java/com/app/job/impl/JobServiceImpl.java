package com.app.job.impl;

import com.app.job.Job;
import com.app.job.JobRepository;
import com.app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    //    private List<Job> jobs = new ArrayList<>();
    //    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        for (Job job : jobs) {
//            if(job.getId().equals(id)){
//                return jobs.remove(job);
//            }
//        }
//        Iterator<Job> jobIterator = jobs.iterator();
//        while (jobIterator.hasNext()){
//            Job job = jobIterator.next();
//            if(job.getId().equals(id)){
//                jobIterator.remove();
//                return true;
//            }
//        }
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
