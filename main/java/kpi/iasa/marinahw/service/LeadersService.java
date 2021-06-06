package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.DTO.LeadersDto;
import kpi.iasa.marinahw.model.Events;
import kpi.iasa.marinahw.model.Leaders;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface LeadersService {

    List<Leaders> leadersList();
    Leaders saveLeaders(Leaders newLeader);
    List<Leaders> findByLeaderName(@PathVariable String leaderName);
    Leaders getLeader(@PathVariable long idLeader); //имеет тип  long
    String deleteLeader(@PathVariable long idLeader);


    List<LeadersDto> getLeadersDtoList ();
    List<LeadersDto> findLeadersDtoByIdGenre(long idGenre);
}
