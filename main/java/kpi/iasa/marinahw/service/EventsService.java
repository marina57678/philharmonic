package kpi.iasa.marinahw.service;
//
//import kpi.iasa.marinahw.model.DTO.EventsDto;
import kpi.iasa.marinahw.model.Events;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EventsService {

    List<Events> eventsList();
    // List<Events> eventsByOneGenre();
    Events saveEvents(Events newEvents);
    List<Events> findByEventName(@PathVariable String eventName);
    Events getEvents(@PathVariable long eventId); //имеет тип  long
    void deleteEvents(long eventId);

    List<Events> getEventByName(String eventName);

    List<Events> findByIdOrganizer(int organizerId);
    List<Events> getEventsByOrganizerName(String organizerName);
    List<Events> getEventsByDateOfEvent(String dateOfEvent1,String dateOfEvent2);
    List<Events>  getEventsByNameBuildings (String nameBuildings);
    List<Events> getOrganizersCountByEvents ();
    List<Object>  getOrganizersCount();
//    List<EventsDto> getEventsDtoList ();
//    List<EventsDto> findEventsByIdOrganizer(@PathVariable Integer organizerId);


    // Events updateEvents(@PathVariable long id, Events events);
}