package com.dorandoran.dorandoranbackend.villageUserMap;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "village_user_map")
public class VillageUserMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "user_id")
    private Long userId;
}
