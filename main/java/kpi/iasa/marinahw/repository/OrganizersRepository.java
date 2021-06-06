package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.Organizers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrganizersRepository  extends JpaRepository<Organizers,Long> {
 //@Query ( "FROM organizers WHERE organizerName =?1")
 List<Organizers> findByOrganizerName(String organizerName);

//    Organizers getOrganizerName(String organizerName);
}
