package kpi.iasa.marinahw.service;

import kpi.iasa.marinahw.model.Artist;
import kpi.iasa.marinahw.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ArtistServiceImpl implements ArtistService{
    private final ArtistRepository artistRepository;
    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository){
        this.artistRepository=artistRepository;
    }

    @Override
    public List<Artist> artistList() { return artistRepository.findAll(); }

    @Override
    public Artist saveArtist(Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    @Override
    public Artist getArtist(long id) {
        return artistRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Artist> findByArtistName(String artistName) {
        return artistRepository.findByArtistName(artistName);
    }


    @Override
    public String deleteArtist(@PathVariable long id){
        Artist s = artistRepository.getOne(id);
        artistRepository.delete(s);
        return "deleted";
    }

    //@Override
    //  public Artist updateArtist(long id, Artist artist) {
    //    return null;
    // }

}