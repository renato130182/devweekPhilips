package com.class_dio.devweek.Entity;


import javax.persistence.*;

@Entity
public class Region {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String region;
    private Long num_exams;

    public Region(String region, Long num_exams) {
        this.region = region;
        this.num_exams = num_exams;
    }

    public Region() {
    }

    public Region(Long id, String region, Long num_exams) {
        this.id = id;
        this.region = region;
        this.num_exams = num_exams;
    }

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getNum_exams() {
        return num_exams;
    }

    public void setNum_exams(Long num_exams) {
        this.num_exams = num_exams;
    }
}
