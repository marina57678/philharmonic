package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Artist;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ArtistService {
    List<Artist> artistList();
   // List<Artist> artistByOneGenre();

    Artist saveArtist(Artist newArtist);
    List<Artist> findByArtistName(@PathVariable String artistName);
    Artist getArtist(@PathVariable long id); //имеет тип  long
    String deleteArtist(@PathVariable long id);

    // Artist updateArtist(@PathVariable long id, Artist artist);
}