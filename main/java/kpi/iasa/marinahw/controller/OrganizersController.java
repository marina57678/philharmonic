package kpi.iasa.marinahw.controller;


import kpi.iasa.marinahw.model.Organizers;
import kpi.iasa.marinahw.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/aboutus")
public class OrganizersController {
    private final OrganizersService organizersService;

    @Autowired
    public OrganizersController(OrganizersService organizersService) {
        this.organizersService = organizersService;
    }

    @GetMapping
    @ResponseBody
    List<Organizers> getOrganizersList() {
        return organizersService.organizersList();
    }

    @GetMapping("/{organizerId}")
    @ResponseBody
    Organizers getOrganizers(@RequestBody @PathVariable long organizerId) { return organizersService.getOrganizers(organizerId); }

    @PutMapping("/update/{organizerId}")
    @ResponseBody
    String updateOrg(@PathVariable long organizerId,  @RequestBody Organizers organizers) {
        return organizersService.updateOrg(organizerId, organizers);
    }

    @GetMapping("/byname/{organizerName}")
    @ResponseBody
    List<Organizers> findByOrganizerName(@PathVariable String organizerName) {
        return organizersService.findByOrganizerName(organizerName);
    }

    @GetMapping("/name/{organizerName}")
    @ResponseBody
    List<Organizers> getOrganizerByName (@PathVariable String organizerName) {
        return organizersService.getOrganizerByName(organizerName);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    Organizers saveOrganizers(@RequestBody Organizers newOrganizers) {
        return organizersService.saveOrganizers(newOrganizers);
    }


    @DeleteMapping(value = "/delete/{organizerId}", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    void deleteOrganizers(@RequestBody @PathVariable long organizerId){ organizersService.deleteOrganizers(organizerId);}
}
