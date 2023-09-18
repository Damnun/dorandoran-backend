package com.dorandoran.dorandoranbackend.map;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "map")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "map_name")
    private String name;

    @Column(name = "map_latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "village_id")
    private Long villageId;
}
