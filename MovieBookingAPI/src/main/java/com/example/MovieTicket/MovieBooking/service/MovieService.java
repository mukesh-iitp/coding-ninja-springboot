package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;


@Service
public class MovieService implements MovieServiceInterface {

	List<Movie> movieList = new ArrayList<Movie>();
	Map<String, Movie> movieMap = new HashMap<String, Movie>();
	
	@Autowired
	RatingRestCommunicator ratingRestCommunicator;

	public List<Movie> getMovies() {
		return movieList;
	}

	public void addMovie(Movie movie) {
		if(movieMap.containsKey(movie.getId())) {
			throw new IdAlreadyExist("Movie with id " + movie.getId()+" already exist");
		}
		else {
			Map<String, Long> ratingMap = new HashMap<String, Long>(); 
			
			movieList.add(movie);
			movieMap.put(movie.getId(), movie);
			ratingMap.put(movie.getId(), movie.getMovieRating());
			ratingRestCommunicator.addRating(ratingMap);
		}

	}

	public Movie getMovie(String id) {
		//if(!movieMap.containsKey(id))
		if(ObjectUtils.isEmpty(movieMap.get(id))){
			throw new IdNotFound("Movie not found for id: "+id);
		}
		Movie movie = movieMap.get(id);
		long updatedRating = ratingRestCommunicator.getRating(id);
		movie.setMovieRating(updatedRating);
		
		return movie;
	}

	public void deleteMovie(String id) {
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("Moive not found.");
		}
		else {
			
			movieList.remove(getMovie(id));
			movieMap.remove(id);
			
			ratingRestCommunicator.deleteRating(id);
		}

	}

	public void updateMovie(Movie topic, String id) {
		System.out.println("starting to fetch by id");
		Movie existingMovie = getMovie(id);
		System.out.println("movie fetched by id");
		movieList.remove(existingMovie);
		movieList.add(topic);
		movieMap.put(id, topic);
		
		Map<String, Long> updateRating = new HashMap<String, Long>();
		updateRating.put(topic.getId(), topic.getMovieRating());
		ratingRestCommunicator.updateRating(updateRating);
	}


}
