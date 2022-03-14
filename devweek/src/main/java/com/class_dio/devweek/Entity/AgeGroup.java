package com.class_dio.devweek.Entity;

import javax.persistence.*;

@Entity
public class AgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private Long range_i;
    private Long range_n;
    private String descriptor;

    public AgeGroup(Long range_i, Long range_n, String description) {
        this.range_i = range_i;
        this.range_n = range_n;
        this.descriptor = description;
    }

    public AgeGroup() {
    }

    public AgeGroup(Long id, Long range_i, Long range_n, String descriptor) {
        this.id = id;
        this.range_i = range_i;
        this.range_n = range_n;
        this.descriptor = descriptor;
    }

    public Long getId() {
        return id;
    }

    public Long getRange_i() {
        return range_i;
    }

    public void setRange_i(Long range_i) {
        this.range_i = range_i;
    }

    public Long getRange_n() {
        return range_n;
    }

    public void setRange_n(Long range_n) {
        this.range_n = range_n;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
