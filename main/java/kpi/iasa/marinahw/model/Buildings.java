package kpi.iasa.marinahw.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "buildings" )
public class Buildings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idBuilding")
    private Long idBuilding;

    @NotNull
    @Column(name= "nameBuildings")
    private String nameBuildings;

    @NotNull
    @Column(name= "idAllAboutBuildings")
    private Long idAllAboutBuildings;

    @NotNull
    @Column(name= "idStreet")
    private Long idStreet;



}
