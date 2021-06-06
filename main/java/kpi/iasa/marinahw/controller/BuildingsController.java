package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.Buildings;
import kpi.iasa.marinahw.service.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/buildings")
public class BuildingsController {
    private final BuildingsService buildingsService;

    @Autowired
    public BuildingsController(BuildingsService buildingsService) {this.buildingsService=buildingsService;}

    @GetMapping
    @ResponseBody
    List<Buildings> getBuildingsList() { return buildingsService.buildingsList(); }


    @GetMapping("/{idBuilding}")
    @ResponseBody
    Buildings getBuildings(@PathVariable long idBuilding){
        return buildingsService.getBuilding(idBuilding);
    }
    @GetMapping("/byname/{nameBuildings}")
    @ResponseBody
    List<Buildings> findByNameBuildings(String nameBuildings){return buildingsService.findByNameBuildings(nameBuildings);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Buildings saveBuildings(@RequestBody Buildings newBuilding ){
        return buildingsService.saveBuildings(newBuilding);
    }



    @DeleteMapping(value = "/delete/{idBuilding}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteBuilding(@RequestBody @PathVariable long idBuilding  ){
        buildingsService.deleteBuilding(idBuilding);
        return "deleted";
    }

//    @GetMapping("/leadersDto")
//    @ResponseBody
//    List<BuildingsDto> getBuildingsDtoList (){ return buildingsService.getBuildingsDtoList();}

}
