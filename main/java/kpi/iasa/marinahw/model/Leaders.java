package kpi.iasa.marinahw.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "leaders" )
public class Leaders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idLeader")
    private Long idLeader;

    @NotNull
    @Column(name= "leaderName")
    private String leaderName;

    @NotNull
    @Column(name= "idGenre")
    private Long idGenre;

}