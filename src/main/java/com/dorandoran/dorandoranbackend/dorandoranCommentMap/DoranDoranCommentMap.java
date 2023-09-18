package com.dorandoran.dorandoranbackend.dorandoranCommentMap;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "dorandoran_comment_map")
public class DoranDoranCommentMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dorandoran_id")
    private Long dorandoranId;

    @Column(name = "comment_id")
    private Long commentId;
}
