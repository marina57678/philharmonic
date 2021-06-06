
package kpi.iasa.marinahw.controller;

import kpi.iasa.marinahw.model.Artist;
import kpi.iasa.marinahw.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private  final  ArtistService artistService;
    @Autowired
    public ArtistController(ArtistService artistService) {this.artistService=artistService;}

    @GetMapping
    @ResponseBody
    List<Artist> getArtistList() { return artistService.artistList(); }


    @GetMapping("/{id}")
    @ResponseBody
    Artist getArtist(@PathVariable long id){
        return artistService.getArtist(id);
    }
    @GetMapping("/byname/{nameArtist}")
    @ResponseBody
    List<Artist> findByArtistName(String artistName){return artistService.findByArtistName(artistName);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    Artist saveArtist(@RequestBody Artist newArtist ){
        return artistService.saveArtist(newArtist);
    }



    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON} )
    @ResponseBody
    String deleteArtist(@RequestBody @PathVariable long id  ){
        artistService.deleteArtist(id);
        return "deleted";
    }

    //@PutMapping(value="/update/{sid}", produces = {MediaType.APPLICATION_JSON})
    //@ResponseBody



}