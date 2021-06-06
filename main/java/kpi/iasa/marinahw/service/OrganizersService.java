package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Organizers;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrganizersService {

    List<Organizers> organizersList();

    Organizers saveOrganizers(Organizers newOrganizers);
    List<Organizers> findByOrganizerName( String organizerName);
    Organizers getOrganizers(@PathVariable long organizerId);
    void deleteOrganizers(@PathVariable long organizerId);

    List<Organizers> getOrganizerByName(String organizerName); // форм парам

    String updateOrg(long organizerId, Organizers organizers);
}
