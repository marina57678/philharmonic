package kpi.iasa.marinahw.service;

//import kpi.iasa.marinahw.model.DTO.TypeOfEventDto;
import kpi.iasa.marinahw.model.TypeOfEvent;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TypeOfEventService {

    List<TypeOfEvent> typeOfEventList();
    TypeOfEvent saveTypeOfEvent(TypeOfEvent newTypeOfEvent);
    List<TypeOfEvent> findByNameType(@PathVariable String nameType);
    TypeOfEvent getTypeOfEvent(@PathVariable long idTypeOfEvent); //имеет тип  long
    String deleteTypeOfEvent(@PathVariable long idTypeOfEvent);




//    List<TypeOfEventDto> getTypeOfEventDtoList ();
}
