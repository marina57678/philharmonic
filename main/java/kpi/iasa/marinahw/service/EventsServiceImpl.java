package kpi.iasa.marinahw.service;

//import kpi.iasa.marinahw.model.DTO.EventsDto;

import kpi.iasa.marinahw.model.Events;
//import kpi.iasa.marinahw.repository.EventsDtoRepository;
import kpi.iasa.marinahw.repository.EventsRepository;
import kpi.iasa.marinahw.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class EventsServiceImpl implements EventsService{
    private final EventsRepository eventsRepository;
  /*  private  final EventsDtoRepository eventsDtoRepository;

    public EventsServiceImpl(EventsRepository eventsRepository, EventsDtoRepository eventsDtoRepository) {
       this.eventsRepository = eventsRepository;
       this.eventsDtoRepository = eventsDtoRepository;    } */


   @Autowired
    public  EventsServiceImpl (EventsRepository eventsRepository){this.eventsRepository=eventsRepository;}

    @Override
    public List<Events> eventsList() { return eventsRepository.findAll(); }

    @Override
    public Events saveEvents(Events newEvents) {
        return eventsRepository.save(newEvents);
    }

    @Override
    public Events getEvents(long eventId) {
        return eventsRepository.findById(eventId).orElseThrow();
    }

    @Override
    public List<Events> findByEventName(String eventName) {
        return eventsRepository.findByEventName(eventName);
    }


    @Override
    public void deleteEvents(long eventId){ eventsRepository.delete(eventsRepository.getOne(eventId));}

    @Override
    public List<Events> getEventByName(String eventName) // форм парам
    {
        List<Events> newList  = new ArrayList<Events>();
        Iterator<Events> iter = eventsRepository.findAll().iterator();
        while (iter.hasNext())
        {   Events temp = iter.next();

            if(temp.getEventName().compareTo(eventName) == 0 )
            {newList.add(temp);}
        }
        return newList;
    }


   /*@Override
   public  List<EventsDto> getEventsDtoList (){ return eventsDtoRepository.findAll();}*/

    @Override
    public List<Events> findByIdOrganizer(@PathVariable int organizerId){ return eventsRepository.findByIdOrganizer(organizerId);}

    @Override
    public List<Events> getEventsByOrganizerName(String organizerName){ return eventsRepository.getEventsByOrganizerName(organizerName);}

    @Override
    public List<Events> getEventsByDateOfEvent(String dateOfEvent1,String dateOfEvent2) { return eventsRepository.getEventsByDateOfEvent(dateOfEvent1,dateOfEvent2);}
    //@Override
    //  public Events updateEvents(long id, Events artist) {
    //    return null;
    // }
    @Override
    public List<Events>  getEventsByNameBuildings (String nameBuildings) { return eventsRepository.getEventsByNameBuildings(nameBuildings);}

    @Override
    public List<Events> getOrganizersCountByEvents() {  return eventsRepository.getOrganizersCountByEvents();}

    @Override
    public  List<Object> getOrganizersCount() {  return eventsRepository.getOrganizersCount();}
}