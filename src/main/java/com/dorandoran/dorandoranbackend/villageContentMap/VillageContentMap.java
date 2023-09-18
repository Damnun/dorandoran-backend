package com.dorandoran.dorandoranbackend.villageContentMap;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "village_content_map")
public class VillageContentMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "content_id")
    private Long contentId;
}
