package kpi.iasa.marinahw.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "ourevents")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "idEvent")
    private long eventId;

    @NotNull
    @Column(name= "name")
    private String eventName;


    @NotNull
    @Column(name= "idOrganizer")
    private int organizerId;

    @NotNull
    @Column(name= "dateOfEvent")
    private String dateOfEvent;

    @NotNull
    @Column(name= "idTypeOfEvent")
    private int idTypeOfEvent;

    @NotNull
    @Column(name= "idBuilding")
    private int BuildingId;



    @ManyToOne
   @JoinColumn( name = "idOrganizer", referencedColumnName = "idOrganizer",insertable = false, updatable = false )
    private Organizers organizers;


   @ManyToOne
   @JoinColumn( name = "idBuilding", referencedColumnName = "idBuilding", insertable = false, updatable = false )
   private Buildings  buildings;

    @ManyToOne
    @JoinColumn( name = "idTypeOfEvent", referencedColumnName = "idTypeOfEvent", insertable = false, updatable = false )
    private TypeOfEvent  typeOfEvent;

//    @ManyToOne( targetEntity = Organizers.class, fetch = FetchType.EAGER)
//    @JoinColumn( name = "idOrganizer", referencedColumnName = "idOrganizer",insertable = false, updatable = false )
//    private Organizers organizers;


//    @ManyToOne( targetEntity = Buildings.class, fetch = FetchType.EAGER)
//    @JoinColumn( name = "idBuilding", referencedColumnName = "idBuilding")
//    private Buildings  buildings;
//


}
