package com.pavan.reviewmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    @SequenceGenerator(
            name="job_seq",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    /*@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="company_id")
    @JsonBackReference
    Company company;*/
    Long companyId;

    private String title;
    private String description;
    private Double rating;



    public Review(Long id, Long companyId, String description, Double rating) {
        this.id = id;
        this.companyId = companyId;
        this.description = description;
        this.rating = rating;
    }

    public Review(Long id, Long companyId, String title, String description, Double rating) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
