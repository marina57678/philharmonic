package kpi.iasa.marinahw.service;


import kpi.iasa.marinahw.model.TypeOfEvent;
import kpi.iasa.marinahw.repository.TypeOfEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TypeOfEventServiceImpl  implements TypeOfEventService{
    private final TypeOfEventRepository typeOfEventRepository;
    @Autowired

    public TypeOfEventServiceImpl (TypeOfEventRepository typeOfEventRepository){this.typeOfEventRepository=typeOfEventRepository; }
    @Override
    public List<TypeOfEvent> typeOfEventList() { return typeOfEventRepository.findAll(); }

    @Override
    public TypeOfEvent saveTypeOfEvent(TypeOfEvent newBuildings) {
        return typeOfEventRepository.save(newBuildings);
    }

    @Override
    public TypeOfEvent getTypeOfEvent(long idTypeOfEvent) {
        return typeOfEventRepository.findById(idTypeOfEvent).orElseThrow();
    }

    @Override
    public List<TypeOfEvent> findByNameType(String nameType) {
        return typeOfEventRepository.findByNameType(nameType);
    }


    @Override
    public String deleteTypeOfEvent(@PathVariable long idTypeOfEvent){
        TypeOfEvent s = typeOfEventRepository.getOne(idTypeOfEvent);
        typeOfEventRepository.delete(s);
        return "deleted";
    }

}

