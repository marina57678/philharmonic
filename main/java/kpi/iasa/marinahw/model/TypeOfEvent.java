package kpi.iasa.marinahw.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "typeOfEvent")
public class TypeOfEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idTypeOfEvent")
    private Long idTypeOfEvent;

    @NotNull
    @Column(name= "nameType")
    private String nameType;
}
