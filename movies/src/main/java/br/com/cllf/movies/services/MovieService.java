package br.com.cllf.movies.services;

import br.com.cllf.movies.entities.Movie;
import br.com.cllf.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public Movie include(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie find(Long id) throws Exception {
        return movieRepository.findById(id).orElseThrow(() -> new Exception("Filme nao encontrado"));
    }

    public List<Movie> findAll() throws Exception {
        List<Movie> listMovie = movieRepository.findAll();
        if (listMovie.isEmpty()) {
            throw new Exception("Sem filmes registrados");
        }
        return listMovie;
    }
}
