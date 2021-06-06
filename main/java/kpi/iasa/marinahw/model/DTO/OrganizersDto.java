package kpi.iasa.marinahw.model.DTO;

import kpi.iasa.marinahw.model.Genre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="organizers")
public class OrganizersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idOrganizer")
    private long organizerId;
    // organizerId

    @NotNull
    @Column(name= "nameOrganizer")
    private String organizerName;

    @NotNull
    @Column(name= "snameOrganizer")
    private String organizerSname;

    @NotNull
    @Column(name= "photoOrganizer")
    private String photoOrganizer;

//    @OneToMany( targetEntity = Genre.class, fetch = FetchType.EAGER)
//    @JoinColumn( name = "idGenre", referencedColumnName = "idGenre")
//    private Genre genre;
}
