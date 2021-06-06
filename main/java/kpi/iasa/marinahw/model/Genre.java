
package kpi.iasa.marinahw.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "genres" )
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idGenre")
    private Long idGenre;

    @NotNull
    @Column(name= "genreName")
    private String genreName;

}