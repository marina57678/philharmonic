package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.TypeOfEvent;
import kpi.iasa.marinahw.service.TypeOfEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/typeofevent")
public class TypeOfEventController {
    private final TypeOfEventService typeOfEventService;

    @Autowired
    public TypeOfEventController(TypeOfEventService typeOfEventService){this.typeOfEventService=typeOfEventService;}

    @GetMapping
    @ResponseBody
    List<TypeOfEvent> getTypeOfEventList() {
        return typeOfEventService.typeOfEventList();
    }

    @GetMapping("/{idTypeOfEvent}")
    @ResponseBody
    TypeOfEvent getTypeOfEvent(@PathVariable long idTypeOfEvent) {
        return typeOfEventService.getTypeOfEvent(idTypeOfEvent);
    }

    @GetMapping("/byname/{typeOfEventName}")
    @ResponseBody
    List<TypeOfEvent> findByNameType(@PathVariable String nameType) {
        return typeOfEventService.findByNameType(nameType);
    }

    @GetMapping("/name/{typeOfEventName}")
    @ResponseBody
    List<TypeOfEvent> getTypeOfEventByName (@PathVariable String nameType) {
        return typeOfEventService.findByNameType(nameType);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    TypeOfEvent saveTypeOfEvent(@RequestBody TypeOfEvent newTypeOfEvent) {
        return typeOfEventService.saveTypeOfEvent(newTypeOfEvent);
    }

    @DeleteMapping(value = "/delete/{idTypeOfEvent}", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    String deleteTypeOfEvent(@RequestBody @PathVariable long idTypeOfEvent) {
        typeOfEventService.deleteTypeOfEvent(idTypeOfEvent);
        return "deleted";
    }
}
