package com.dorandoran.dorandoranbackend.farm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "farm_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "species")
    private String species;

    @Column(name = "want")
    private String want;

    @Column(name = "why")
    private String why;

    @Column(name = "map_id")
    private Long mapId;

    @Column(name = "village_id")
    private Long villageId;

}
