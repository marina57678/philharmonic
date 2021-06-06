package kpi.iasa.marinahw.service;


import kpi.iasa.marinahw.model.Genre;
import kpi.iasa.marinahw.model.Genre;
import kpi.iasa.marinahw.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreRepository;

    @Autowired
    public  GenreServiceImpl (GenreRepository genreRepository){
        this.genreRepository=genreRepository;
    }

    @Override
    public List<Genre> genreList() {return genreRepository.findAll();}

    @Override
    public Genre saveGenre(Genre newGenre) { return genreRepository.save(newGenre); }

    @Override
    public List<Genre> findByGenreName(String genreName) {  return genreRepository.findByGenreName(genreName); }

    @Override
    public Genre getGenre(long idGenre) {return genreRepository.findById(idGenre).orElseThrow();}

    @Override
    public String deleteGenre(long idGenre) {
        Genre s = genreRepository.getOne(idGenre);
        genreRepository.delete(s);
        return "deleted";}

    @Override
    public List<Genre> getGenreByName(String genreName) {
        List<Genre> newList  = new ArrayList<Genre>();
        //    newList.add(genreRepository.getOne(2L));
        Iterator<Genre> iter = genreRepository.findAll().iterator();
        while (iter.hasNext())
        {   Genre temp = iter.next();

            if(temp.getGenreName().compareTo(genreName) == 0 )
            {newList.add(temp);}
        }
        return newList;
    }
    
}
