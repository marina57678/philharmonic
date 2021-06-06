package kpi.iasa.marinahw.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name= "organizers")
public class Organizers {
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

//        @NotNull
        @Column(name= "photoOrganizer")
        private String photoOrganizer;

        // @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrganizer")
        // private List<Events> events;

        // добавлю связь one to many  что б реализовать в дальнейшем адекватный поиск ивента ,который сделал
        // конкретный организатор.

      //  @OneToMany
       // @JoinColumn (name = "idOrganizer", referencedColumnName="idOrganizer" )
        //List<Events> events;
}
