package kpi.iasa.marinahw.repository;


import kpi.iasa.marinahw.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByGenreName(String genreName);
}
