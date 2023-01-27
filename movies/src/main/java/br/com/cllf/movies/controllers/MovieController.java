package br.com.cllf.movies.controllers;

import br.com.cllf.movies.entities.Movie;
import br.com.cllf.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> include(@RequestBody Movie movie){
        Movie response = movieService.include(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> find(@PathVariable Long id) throws Exception {
        Movie response = movieService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List <Movie>> findAll() throws Exception {
        List <Movie> response = movieService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
