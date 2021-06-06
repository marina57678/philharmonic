package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Organizers;
import kpi.iasa.marinahw.repository.OrganizersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class OrganizersServiceImpl implements OrganizersService {
    private final OrganizersRepository organizersRepository;
    @Autowired
    public OrganizersServiceImpl (OrganizersRepository organizersRepository)
    {this.organizersRepository= organizersRepository;}
    @Override
    public   List<Organizers>  organizersList() {
        return  organizersRepository.findAll();
    }
    @Override
    public Organizers saveOrganizers(Organizers newOrganizers) {
        return organizersRepository.save(newOrganizers);
    }

    @Override
    public Organizers getOrganizers(long organizerId) {
        return organizersRepository.findById(organizerId).orElseThrow();
    }

    @Override
    public List<Organizers> findByOrganizerName(String organizerName) {
        return organizersRepository.findByOrganizerName(organizerName);}

    @Override
    public void deleteOrganizers(long id){ organizersRepository.delete(organizersRepository.getOne(id));}

    @Override
    public List<Organizers> getOrganizerByName(String organizerName) // форм парам
    {
        List<Organizers> newList  = new ArrayList<Organizers>();
    //    newList.add(organizersRepository.getOne(2L));
        Iterator<Organizers> iter = organizersRepository.findAll().iterator();
        while (iter.hasNext())
        {   Organizers temp = iter.next();

            if(temp.getOrganizerName().compareTo(organizerName) == 0 )
            {newList.add(temp);}
        }
        return newList;
    }

    @Override
    public String updateOrg(long organizerId, Organizers organizers) {
        organizersRepository.getOne(organizerId).setOrganizerName(organizers.getOrganizerName()); //setName(client.getName());
        organizersRepository.getOne(organizerId).setOrganizerSname(organizers.getOrganizerSname());
        organizersRepository.save(organizersRepository.getOne(organizerId));
        return "Client updated";
    }

    // зачем мне тут s хз. нужно узнать!!!
}
