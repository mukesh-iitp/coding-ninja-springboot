package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class MovieController {

	@Autowired
	MovieServiceInterface movieService;

	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return movieService.getMovies();
	}

	@PostMapping("/movie")
	public void addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException("Moive already exist");
		}
		movieService.addMovie(movie);
	}

	@GetMapping("/movie/{id}")
	public Movie getMovieByID(@PathVariable String id) {
		return movieService.getMovie(id);
	}

	@DeleteMapping("/movie/{id}")
	public void deleteMovieByID(@PathVariable String id) {
		movieService.deleteMovie(id);
	}

	@PutMapping("/update/{id}")
	public void updateMovieByID(@Valid @RequestBody Movie topic, @PathVariable String id) {
		movieService.updateMovie(topic, id);
	}

}
