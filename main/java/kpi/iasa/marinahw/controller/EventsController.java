package kpi.iasa.marinahw.controller;


//import kpi.iasa.marinahw.model.DTO.EventsDto;
import kpi.iasa.marinahw.model.Artist;
import kpi.iasa.marinahw.model.Events;
import kpi.iasa.marinahw.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventsController {
    private final EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping
    @ResponseBody
    List<Events> getEventsList() {
        return eventsService.eventsList();
    }

    @GetMapping("/{eventId}")
    @ResponseBody
    Events getEvents(@PathVariable long eventId) {
        return eventsService.getEvents(eventId);
    }

    @GetMapping("/byname/{eventName}")
    @ResponseBody
    List<Events> findByEventName(@PathVariable String eventName) {
       return eventsService.findByEventName(eventName);
   }

      @GetMapping("/name/{eventName}")
      @ResponseBody
      List<Events> getEventByName (@PathVariable String eventName) {
          return eventsService.getEventByName(eventName);
      }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    Events saveEvents(@RequestBody Events newEvents) {
        return eventsService.saveEvents(newEvents);
    }

    @DeleteMapping(value = "/delete/{eventId}", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    void deleteEvents(@RequestBody @PathVariable int eventId){ eventsService.deleteEvents(eventId);}

   /*@GetMapping("/eventsDto")
   @ResponseBody
   List<EventsDto> getEventsDtoList (){ return eventsService.getEventsDtoList();}*/


// пока что организатора по айди.
    //теперь вообще ивент по айдию...
    @GetMapping("/eventsByOrg/{organizerId}")
    @ResponseBody
    List<Events> findByIdOrganizer (@PathVariable int organizerId ){ return eventsService.findByIdOrganizer(organizerId);}


    //tz6.1
    @GetMapping("/eventsBy/{organizerName}")
    @ResponseBody
    List<Events> getEventsByOrganizerName(@PathVariable String organizerName){ return eventsService.getEventsByOrganizerName(organizerName);}


    //tz6.2
    @GetMapping("/eventsByDate/{dateOfEvent1},{dateOfEvent2}")
    @ResponseBody
    List<Events> getEventsByDateOfEvent(@PathVariable String dateOfEvent1, @PathVariable String dateOfEvent2) { return eventsService.getEventsByDateOfEvent(dateOfEvent1,dateOfEvent2);}

    // tz8
    @GetMapping("/eventsByBuildings/{nameBuildings}")
    @ResponseBody
    List<Events> getEventsByNameBuildings(@PathVariable String nameBuildings){ return eventsService.getEventsByNameBuildings(nameBuildings);}

    // tz11
    @GetMapping("/orgCEv")
    @ResponseBody
    List<Events> getOrganizersCountByEvents(){ return eventsService.getOrganizersCountByEvents();}

    //try
    @GetMapping("/try")
    @ResponseBody
    List<Object> getOrganizersCount(){ return eventsService.getOrganizersCount();}


}
