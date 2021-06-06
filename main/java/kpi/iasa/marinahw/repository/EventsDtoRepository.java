/*  package kpi.iasa.marinahw.repository;
  
  
  import kpi.iasa.marinahw.model.DTO.EventsDto;

  import kpi.iasa.marinahw.model.Events;
  import kpi.iasa.marinahw.model.Organizers;
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;
  import org.springframework.stereotype.Repository;
  
  import java.util.List;
  
  @Repository
  public interface EventsDtoRepository extends JpaRepository<EventsDto, Long> {
  
        // List<EventsDto> findByOrgName(String organizerName);
      @Query(  nativeQuery= true , value= "select ourevents.name from ourevents where ourevents.id_organizer = ?1")
      List<Events>  findEventsByIdOrganizer(long id);
  }
  */

