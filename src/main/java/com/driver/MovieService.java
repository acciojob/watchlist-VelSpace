package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public void addMovie(Movie movie) {
		movieRepository.addMovie(movie);
	}

	public void addDirector(Director director) {
		movieRepository.addDirector(director);
	}
	
	public void makePair(String director, String movie) {
		movieRepository.MakePair(director, movie);
	}

	public Movie getMovieByName(String movie) {
		
		return movieRepository.getMovie(movie);
	}

	public Director getDirectorByName(String director) {
		return movieRepository.getDirector(director);
	}

	public List<String> getmoviesList(String director) {
		
		return movieRepository.getMoviesList(director);
	}

	public List<String> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	public void deleteDirectorRecord(String director_name) {
		movieRepository.deleteDirectorRecord(director_name);
	}

	public void deleteDirectorRecord() {
		movieRepository.deleteDirectorRecords();
		
	}

}
