package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Buildings;
import kpi.iasa.marinahw.repository.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BuildingsServiceImpl  implements BuildingsService {
    private final  BuildingsRepository buildingsRepository;
    @Autowired
  
    public BuildingsServiceImpl (BuildingsRepository buildingsRepository){this.buildingsRepository=buildingsRepository; }
    @Override
    public List<Buildings> buildingsList() { return buildingsRepository.findAll(); }

    @Override
    public Buildings saveBuildings(Buildings newBuildings) {
        return buildingsRepository.save(newBuildings);
    }

    @Override
    public Buildings getBuilding(long idBuilding) {
        return buildingsRepository.findById(idBuilding).orElseThrow();
    }

    @Override
    public List<Buildings> findByNameBuildings(String nameBuildings) {
        return buildingsRepository.findByNameBuildings(nameBuildings);
    }


    @Override
    public String deleteBuilding(@PathVariable long idBuilding){
        Buildings s = buildingsRepository.getOne(idBuilding);
        buildingsRepository.delete(s);
        return "deleted";
    }

}

