package com.class_dio.devweek.Entity;


import javax.persistence.*;

@Entity
public class Incidence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private Long region_id;
    private Integer mouth;
    private Long ageGroupId;
    private Integer num_exams;

    public Incidence(Long region_id, Integer mouth, Long ageGroupId, Integer num_exams) {
        this.region_id = region_id;
        this.mouth = mouth;
        this.ageGroupId = ageGroupId;
        this.num_exams = num_exams;
    }

    public Incidence(Long id, Long region_id, Integer mouth, Long ageGroupId, Integer num_exams) {
        this.id = id;
        this.region_id = region_id;
        this.mouth = mouth;
        this.ageGroupId = ageGroupId;
        this.num_exams = num_exams;
    }

    public Incidence() {
    }

    public Long getId() {
        return id;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public Integer getMouth() {
        return mouth;
    }

    public void setMouth(Integer mouth) {
        this.mouth = mouth;
    }

    public Long getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(Long ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public Integer getNum_exams() {
        return num_exams;
    }

    public void setNum_exams(Integer num_exams) {
        this.num_exams = num_exams;
    }
}
