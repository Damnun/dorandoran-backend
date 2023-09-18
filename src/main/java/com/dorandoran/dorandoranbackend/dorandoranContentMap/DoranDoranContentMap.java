package com.dorandoran.dorandoranbackend.dorandoranContentMap;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "dorandoran_content_map")
public class DoranDoranContentMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dorandoran_id")
    private Long dorandoranId;

    @Column(name = "content_id")
    private Long contentId;
}
