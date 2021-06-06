
package kpi.iasa.marinahw.controller;


import kpi.iasa.marinahw.model.Declare;
import kpi.iasa.marinahw.service.DeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/declares")
public class DeclareController {
    private  final  DeclareService declareService;
    @Autowired
    public DeclareController(DeclareService declareService) {this.declareService=declareService;}

    @GetMapping
    @ResponseBody
    List<Declare> getDeclareList() { return declareService.declareList(); }


    @GetMapping("/{id}")
    @ResponseBody
    Declare getDeclare(@PathVariable long id){
        return declareService.getDeclare(id);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Declare saveDeclare(@RequestBody Declare newDeclare ){
        return declareService.saveDeclare(newDeclare);
    }



    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteDeclare(@RequestBody @PathVariable long id  ){
        declareService.deleteDeclare(id);
        return "deleted";
    }

    //@PutMapping(value="/update/{sid}", produces = {MediaType.APPLICATION_JSON})
    //@ResponseBody



}