package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Buildings;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BuildingsService {

    List<Buildings> buildingsList();
    Buildings saveBuildings(Buildings newBuilding);
    List<Buildings> findByNameBuildings(@PathVariable String nameBuildings);
    Buildings getBuilding(@PathVariable long idBuilding);

//    List<BuildingsDto> getBuildingsDtoList();

    String deleteBuilding ( @PathVariable long idBuilding);



}
