package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.TypeOfEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOfEventRepository extends JpaRepository<TypeOfEvent, Long> {
    List<TypeOfEvent> findByNameType(String nameType);
}
