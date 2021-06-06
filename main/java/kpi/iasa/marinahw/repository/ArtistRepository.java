package kpi.iasa.marinahw.repository;

import kpi.iasa.marinahw.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByArtistName(String artistName);
}

