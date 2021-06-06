package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.Accs;
import kpi.iasa.marinahw.service.AccsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/accs")
public class  AccsController {
    private final AccsService accsService;
    @Autowired
    public AccsController (AccsService accsService){this.accsService=accsService;}

    @GetMapping
    @ResponseBody
    List<Accs> getAccsList() { return accsService.accsList(); }

    @GetMapping("/{id}")
    @ResponseBody
    Accs getAccs(@PathVariable long id){
        return accsService.getAccs(id);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Accs saveAccs(@RequestBody Accs newAccs ){
        return  accsService.saveAccs(newAccs);
    }


    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteAccs(@RequestBody @PathVariable long id  ){
        accsService.deleteAccs(id);
        return "deleted";
    }
}
