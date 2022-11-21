package com.yazdanfar.assignment.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ExerciseEntity implements BaseEntity {

    @Id()
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;

    private String codeListCode;

    @Column(unique = true)
    private String code;

    private String displayValue;

    private String longDescription;

    private String fromDate;

    private String toDate;

    private Integer sortingPriority;


}
