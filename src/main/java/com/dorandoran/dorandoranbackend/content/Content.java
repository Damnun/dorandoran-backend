package com.dorandoran.dorandoranbackend.content;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Data
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @Column(name ="content_url")
    private String contentUrl;

    @Column(name = "content_extension")
    private String contentExtension;

    @CurrentTimestamp
    @Column(name = "content_created")
    private Timestamp contentCreated;

    @ColumnDefault("1")
    @Column(name = "content_status")
    private String contentStatus;

    @Column(name = "content_volume")
    private String contentVolume;

    @Column(name = "user_id")
    private Long userId;
}
