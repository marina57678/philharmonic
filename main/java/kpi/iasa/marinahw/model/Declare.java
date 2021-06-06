
package kpi.iasa.marinahw.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "udeclare" )
public class Declare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull
    @Column(name= "name")
    private String declareName;

    @NotNull
    @Column(name= "email")
    private String declareEmail;

    @NotNull
    @Column(name= "phone")
    private String declareTelephone;

    @NotNull
    @Column(name= "country")
    private String declareCountry;

}