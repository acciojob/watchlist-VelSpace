package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MovieRepository {

	HashMap<String, Movie> movies = new HashMap<>();
	
	HashMap<String, Director> directors = new HashMap<>();
	
	HashMap<String, HashSet<String>> pairs = new HashMap<>();
	public void addMovie(Movie movie) {
		movies.put(movie.getName(), movie);
		
	}
	public void addDirector(Director director) {
		directors.put(director.getName(), director);
		//System.out.println(directors.size());
	}
	
	public void MakePair(String director, String movie) {
		if(!directors.containsKey(director) || !movies.containsKey(movie)) {
			return;
		}
		if(pairs.containsKey(director)) {
			HashSet<String> curr_set = pairs.get(director);
			curr_set.add(movie);
			pairs.put(director, curr_set);
		}
		else {
			HashSet<String> curr_set = new HashSet<>();
			curr_set.add(movie);
			pairs.put(director, curr_set);
		}
		System.out.println(pairs.size());
	}
	public Movie getMovie(String movie) {
		return movies.get(movie);
	}
	public Director getDirector(String director) {
		return directors.get(director);
	}
	public List<String> getMoviesList(String director) {
		HashSet<String> names = pairs.get(director);
		List<String> list = new ArrayList<>();
		for(String name:names){
			list.add(name);
		}
		return list;
	}
	public List<String> getAllMovies() {
		List<String> list = new ArrayList<>();
		for(Map.Entry<String, Movie> e:movies.entrySet()) {
			list.add(e.getValue().getName());
		}
		return list;
	}
	public void deleteDirectorRecord(String director_name) {
		
		HashSet<String> curr_movies = pairs.get(director_name);
		for(String movie:curr_movies) {
			movies.remove(movie);
		}
		directors.remove(director_name);
		pairs.remove(director_name);
	}
	public void deleteDirectorRecords() {
		for(Map.Entry<String, HashSet<String>> e:pairs.entrySet()) {
			deleteDirectorRecord(e.getKey());
		}
		
	}

}
