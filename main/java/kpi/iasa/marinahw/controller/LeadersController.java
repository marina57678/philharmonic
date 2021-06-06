package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.DTO.LeadersDto;
import kpi.iasa.marinahw.model.Leaders;
import kpi.iasa.marinahw.service.LeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/leaders")
public class LeadersController {
    private final LeadersService leadersService;

    @Autowired
    public LeadersController(LeadersService leadersService) {this.leadersService=leadersService;}

    @GetMapping
    @ResponseBody
    List<Leaders> getLeadersList() { return leadersService.leadersList(); }


    @GetMapping("/{Long}")
    @ResponseBody
    Leaders getLeaders(@PathVariable long Long){
        return leadersService.getLeader(Long);
    }
    @GetMapping("/byname/{nameLeaders}")
    @ResponseBody
    List<Leaders> findByLeadersName(String leaderName){return leadersService.findByLeaderName(leaderName);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Leaders saveLeaders(@RequestBody Leaders newLeader ){
        return leadersService.saveLeaders(newLeader);
    }



    @DeleteMapping(value = "/delete/{Long}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteLeader(@RequestBody @PathVariable long Long  ){
        leadersService.deleteLeader(Long);
        return "deleted";
    }

    @GetMapping("/leadersDto")
    @ResponseBody
    List<LeadersDto> getLeadersDtoList (){ return leadersService.getLeadersDtoList();}

    @GetMapping("/leadersDto/{idGenre}")
    @ResponseBody
    List<LeadersDto> findLeadersDtoByIdGenre (@PathVariable long idGenre){ return leadersService.findLeadersDtoByIdGenre(idGenre);}

}
