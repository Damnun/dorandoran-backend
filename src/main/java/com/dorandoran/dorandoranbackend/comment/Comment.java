package com.dorandoran.dorandoranbackend.comment;

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
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_text")
    private String text;

    @CurrentTimestamp
    @Column(name = "comment_created")
    private Timestamp created;

    @Column(name = "comment_status")
    private Integer status;

    @Column(name = "user_id")
    private Long userId;
}
