package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie){
		movieService.addMovie(movie);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director director){
		movieService.addDirector(director);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@PutMapping("/movies/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name")String movie,@RequestParam("director name")String director){
		movieService.makePair(director, movie);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie){
		Movie curr_movie = movieService.getMovieByName(movie);
		return new ResponseEntity<>(curr_movie,HttpStatus.OK);
		
	}
	
	@GetMapping("/get-director-by-name/{name}")
	public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director){
		Director curr_director = movieService.getDirectorByName(director);
		return new ResponseEntity<>(curr_director,HttpStatus.OK);
		
	}
	
	@GetMapping("/get-movies-by-director-name/{director}")
	public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
		List<String> movies_name = movieService.getmoviesList(director);
		return new ResponseEntity<>(movies_name,HttpStatus.OK);
		
	}
	
	@GetMapping("/get-all-movies")
	public ResponseEntity<List<String>> findAllMovies(){
		List<String> all_movies = movieService.getAllMovies();
		return new ResponseEntity<>(all_movies,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam("director’s name") String director_name){
		movieService.deleteDirectorRecord(director_name);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@DeleteMapping("delete-all-directors")
	public ResponseEntity<String> deleteAllDirectors(){
		movieService.deleteDirectorRecord();
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
}
