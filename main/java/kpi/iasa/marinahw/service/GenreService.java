package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Genre;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GenreService {

    List<Genre> genreList();

    Genre saveGenre(Genre newGenre);
    List<Genre> findByGenreName (@PathVariable String genreName);
    Genre getGenre(@PathVariable long idGenre);
    String deleteGenre(@PathVariable long idGenre);

    List<Genre> getGenreByName(String genreName);
}
