package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Declare;
import kpi.iasa.marinahw.repository.DeclareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class DeclareServiceImpl implements DeclareService{
    private final DeclareRepository declareRepository;
    @Autowired
    public DeclareServiceImpl(DeclareRepository declareRepository){
        this.declareRepository=declareRepository;
    }

    @Override
    public List<Declare> declareList() { return declareRepository.findAll(); }

    @Override
    public Declare saveDeclare(Declare newDeclare) {
        return declareRepository.save(newDeclare);
    }

    @Override
    public Declare getDeclare(long id) {
        return declareRepository.findById(id).orElseThrow();
    }


    @Override
    public String deleteDeclare(@PathVariable long id){
        Declare s = declareRepository.getOne(id);
        declareRepository.delete(s);
        return "deleted";
    }

    //@Override
    //  public Declare updateDeclare(long id, Declare declare) {
    //    return null;
    // }

}