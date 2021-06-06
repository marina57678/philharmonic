package kpi.iasa.marinahw.repository;


import kpi.iasa.marinahw.model.DTO.LeadersDto;
import kpi.iasa.marinahw.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadersDtoRepository extends JpaRepository<LeadersDto, Long> {



    @Query( nativeQuery= true , value= "select * from leaders join genres on leaders.id_genre = genres.id_genre   where leaders.id_genre = ?1")
    List<LeadersDto> findLeadersDtoByIdGenre(long idGenre);
}
