package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Accs;
import kpi.iasa.marinahw.repository.AccsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccsServiceImpl implements AccsService {
    private final AccsRepository accsRepository;

    @Autowired
    public AccsServiceImpl(AccsRepository accsRepository){
        this.accsRepository=accsRepository;
    }

    @Override
    public List<Accs> accsList() { return accsRepository.findAll(); }

    @Override
    public Accs saveAccs(Accs newAccs) {
        return accsRepository.save(newAccs);
    }

    @Override
    public Accs getAccs(long id) {
        return accsRepository.findById(id).orElseThrow();
    }


    @Override
    public String deleteAccs(@PathVariable long id){
        Accs s = accsRepository.getOne(id);
        accsRepository.delete(s);
        return "deleted";
    }

    //@Override
    //  public Artist updateArtist(long id, Artist artist) {
    //    return null;
    // }

}
