package kpi.iasa.marinahw.model.DTO;

import kpi.iasa.marinahw.model.Genre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="leaders")
public class LeadersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLeader")
    private Long idLeader;

    @NotNull
    @Column(name = "leaderName")
    private String leaderName;

    //  private Class<Genre> targetEntity;
    // many to one
    @ManyToOne //( targetEntity = Genre.class, fetch = FetchType.EAGER)
    @JoinColumn( name = "idGenre", referencedColumnName = "idGenre")
    private Genre genre;



//    @ManyToOne( targetEntity = Genre.class, fetch = FetchType.EAGER)
//    @JoinColumn( name = "idGenre", referencedColumnName = "idGenre", insertable = false, updatable = false)
//    private Genre genre;

}
