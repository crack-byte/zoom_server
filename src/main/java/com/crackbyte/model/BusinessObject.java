package com.crackbyte.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class BusinessObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true)
    private Long id;

    @Column
    private long createdDate;

    @Column
    private long updatedDate;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean deleted = false;

    @Column(columnDefinition = "boolean default true")
    private boolean active = true;

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = System.currentTimeMillis();
        this.updatedDate = this.createdDate;
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = System.currentTimeMillis();
    }

}
