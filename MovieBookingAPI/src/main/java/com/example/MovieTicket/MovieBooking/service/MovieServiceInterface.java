package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {

	List<Movie> getMovies();

	void addMovie(Movie movie);

	Movie getMovie(String id);

	void deleteMovie(String id);

	void updateMovie(Movie topic, String id);

}
