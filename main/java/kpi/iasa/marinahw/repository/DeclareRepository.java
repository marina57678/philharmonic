package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.Declare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclareRepository extends JpaRepository<Declare, Long> {

}