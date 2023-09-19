package com.dorandoran.dorandoranbackend.dorandoran;

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
@Table(name = "dorandoran")
public class DoranDoran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dorandoran_title")
    private String title;

    @Column(name = "dorandoran_description")
    private String description;

    @CurrentTimestamp
    @Column(name = "dorandoran_created")
    private Timestamp created;

    @Column(name = "user_id")
    private Long userId;

}
