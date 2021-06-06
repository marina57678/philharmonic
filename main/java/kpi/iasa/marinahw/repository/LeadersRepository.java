package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.Events;
import kpi.iasa.marinahw.model.Leaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadersRepository extends JpaRepository<Leaders, Long>  {

    List<Leaders> findByLeaderName(String leaderName);

}
