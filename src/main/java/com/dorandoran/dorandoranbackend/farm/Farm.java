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

    @Column(name = "species")
    private String species;

    @Column(name = "want")
    private String want;

    @Column(name = "why")
    private String why;

    @Column(name = "hobit")
    private String hobit;

    @Column(name = "address")
    private String address;

    @Column(name = "userId")
    private Long userId;

}
