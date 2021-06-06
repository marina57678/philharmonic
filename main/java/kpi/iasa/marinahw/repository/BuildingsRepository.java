package kpi.iasa.marinahw.repository;


import kpi.iasa.marinahw.model.Buildings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingsRepository extends JpaRepository<Buildings, Long> {
    List<Buildings> findByNameBuildings(String nameBuildings);

    //  List<Buildings> findByNameBuildings(String nameBuildings);
}
