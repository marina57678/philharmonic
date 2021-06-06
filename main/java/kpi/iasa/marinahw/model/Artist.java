
package kpi.iasa.marinahw.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name= "artists" )
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idArtist")
    private Long id;

    @NotNull
    @Column(name= "artistName")
    private String artistName;

    @NotNull
    @Column(name= "artistSname")
    private String artistSname;

    @NotNull
    @Column(name= "artistAge")
    private String artistAge;

    @NotNull
    @Column(name= "artistSex")
    private String artistSex;

    @NotNull
    @Column(name= "artistPhoto")
    private String artistPhoto;

//    @ManyToMany(mappedBy = "idArtist")
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "Employee_Project",
//            joinColumns = { @JoinColumn(name = "employee_id") },
//            inverseJoinColumns = { @JoinColumn(name = "project_id") }
//    )
//    Set<Project> projects = new HashSet<>();
}