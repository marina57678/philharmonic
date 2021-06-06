package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.Genre;
import kpi.iasa.marinahw.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService){this.genreService=genreService;}

    @GetMapping
    @ResponseBody
    List<Genre> getGenreList() {
        return genreService.genreList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Genre getGenre(@PathVariable long idGenre) { return genreService.getGenre(idGenre);
    }

    @GetMapping("/byname/{genreName}")
    @ResponseBody
    List<Genre> findByGenreName(@PathVariable String genreName) {
        return genreService.findByGenreName(genreName);
    }

    @GetMapping("/name/{genreName}")
    @ResponseBody
    List<Genre> getGenreByName (@PathVariable String genreName) {
        return genreService.getGenreByName(genreName);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    Genre saveGenre(@RequestBody Genre newGenre) {
        return genreService.saveGenre(newGenre);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON})
    @ResponseBody
    String deleteGenre(@RequestBody @PathVariable long idGenre) {
        genreService.deleteGenre(idGenre);
        return "deleted";
    }
}


