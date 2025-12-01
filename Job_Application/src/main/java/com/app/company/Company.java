package com.app.company;

import com.app.job.Job;
import com.app.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {
    }

    public Company(Long companyId, String companyName, String description, List<Job> jobs) {
        this.id = companyId;
        this.companyName = companyName;
        this.description = description;
        this.jobs = jobs;
    }

    public Long getCompanyId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setCompanyId(Long companyId) {
        this.id = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
