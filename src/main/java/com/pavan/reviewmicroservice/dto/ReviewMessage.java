package com.pavan.reviewmicroservice.dto;

public class ReviewMessage {

    private Long id;
    private Long companyId;
    private String title;
    private String description;
    private Double rating;

    public ReviewMessage() {

    }

    public ReviewMessage(Long id, Double rating, String description, String title, Long companyId) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.title = title;
        this.companyId = companyId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}