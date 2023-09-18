package com.dorandoran.dorandoranbackend.benefit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "benefit")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "benefit_title")
    private String title;

    @Column(name = "benefit_category")
    private String category;

    @Column(name = "benefit_agency")
    private String agency;

    @Column(name = "benefit_description")
    private String description;

    @Column(name = "benefit_qualification")
    private String qualification;

    @Column(name = "benefit_standard")
    private String standard;

    @CurrentTimestamp
    @Column(name = "benefit_created")
    private Timestamp created;

    @Column(name = "benefit_started")
    private Timestamp started;

    @Column(name = "benefit_ended")
    private Timestamp ended;

    @Column(name = "benefit_url")
    private String url;

}
