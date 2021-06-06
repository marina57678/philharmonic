package kpi.iasa.marinahw.repository;

//import kpi.iasa.marinahw.model.DTO.EventsDto;
import kpi.iasa.marinahw.model.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventsRepository  extends JpaRepository<Events,Long>{
    List<Events> findByEventName(String eventName);

    @Query( nativeQuery= true , value= "select * from ourevents where ourevents.id_organizer = ?1")
    List<Events> findByIdOrganizer(int organizerId);

    //tz6.1
    @Query( nativeQuery= true , value= "select * from ourevents join organizers on ourevents.id_organizer = organizers.id_organizer where organizers.id_organizer = (select organizers.id_organizer from  organizers where  name_organizer =?1)")
    List<Events>  getEventsByOrganizerName(String organizerName);
    //tz6.2
    @Query (nativeQuery= true , value= "select * from ourevents where date_of_event between ?1 and ?2")
    List<Events>  getEventsByDateOfEvent(String dateOfEvent1,String dateOfEvent2);

    // tz8 #Отримати перелік концертних заходів, проведених в зазначеному культурному спорудженні.
    @Query (nativeQuery= true , value= "select * from ourevents where id_building = (select id_building from buildings where name_buildings =?1)" )
    List<Events>  getEventsByNameBuildings (String nameBuildings);

    // tz11 #Отримати список організаторів культурних заходів і кількість проведених ними концертів протягом певного періоду часу.
    @Query (nativeQuery= true , value= "select *  from ourevents" )
    List<Events>  getOrganizersCountByEvents ();

    @Query (nativeQuery= true , value= "select name_buildings ,  count(ourevents.id_organizer)  from ourevents join buildings on ourevents.id_building = buildings.id_building group by ourevents.id_organizer " )
    List<Object> getOrganizersCount();

}