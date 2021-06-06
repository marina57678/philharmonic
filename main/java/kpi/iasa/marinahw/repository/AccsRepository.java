package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.Accs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccsRepository  extends JpaRepository<Accs,Long> {

}
