package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.DTO.LeadersDto;
import kpi.iasa.marinahw.model.Events;
import kpi.iasa.marinahw.model.Leaders;
import kpi.iasa.marinahw.repository.LeadersDtoRepository;
import kpi.iasa.marinahw.repository.LeadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class LeadersServiceImpl implements LeadersService {
    private  final LeadersRepository leadersRepository;
    private  final LeadersDtoRepository leadersDtoRepository;
    @Autowired
    public LeadersServiceImpl(LeadersRepository leadersRepository, LeadersDtoRepository leadersDtoRepository) {this.leadersRepository = leadersRepository;
        this.leadersDtoRepository = leadersDtoRepository;
    }

    @Override
    public List<Leaders> leadersList() { return leadersRepository.findAll(); }

    @Override
    public Leaders saveLeaders(Leaders newLeader) {
        return leadersRepository.save(newLeader);
    }


    @Override
    public Leaders getLeader(long idLeader) {
        return leadersRepository.findById(idLeader).orElseThrow();
    }

    @Override
    public List<Leaders> findByLeaderName(String leaderName) {
        return leadersRepository.findByLeaderName(leaderName);
    }


    @Override
    public String deleteLeader(@PathVariable long idLeader){
        Leaders s = leadersRepository.getOne(idLeader);
        leadersRepository.delete(s);
        return "deleted";
    }

    @Override
    public  List<LeadersDto> getLeadersDtoList (){ return leadersDtoRepository.findAll();}

    @Override
    public List<LeadersDto> findLeadersDtoByIdGenre(long idGenre) { return leadersDtoRepository.findLeadersDtoByIdGenre(idGenre); }
}
