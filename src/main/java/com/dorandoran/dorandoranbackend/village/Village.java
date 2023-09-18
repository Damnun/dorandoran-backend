package com.dorandoran.dorandoranbackend.village;

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
@Table(name = "village")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "village_name")
    private String villageName;

    @Column(name = "village_description")
    private String villageDescription;

    @CurrentTimestamp
    @Column(name = "created")
    private Timestamp villageCreated;

    @Column(name = "village_latitude")
    private String latitude;

    @Column(name = "village_longitude")
    private String longitude;
}
