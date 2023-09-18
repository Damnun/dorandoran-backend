package com.dorandoran.dorandoranbackend.event;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_title")
    private String title;

    @Column(name = "event_description")
    private String description;

    @Column(name = "event_category")
    private String category;

    @Column(name = "event_status")
    private Integer status;

    @CurrentTimestamp
    @Column(name = "event_created")
    private Timestamp created;

    @ColumnDefault("null")
    @Column(name = "event_deleted")
    private Timestamp deleted;

    @Column(name = "village_id")
    private Long villageId;

}
