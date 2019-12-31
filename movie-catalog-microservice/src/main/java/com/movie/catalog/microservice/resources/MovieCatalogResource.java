package com.movie.catalog.microservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.microservice.models.Movie;
import com.movie.catalog.microservice.models.MovieCatalogItem;
import com.movie.catalog.microservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<MovieCatalogItem> getCatalog(@PathVariable("userId") String userId){		
		List<Rating> ratings = Arrays.asList(
			new Rating("1234", 4),
			new Rating("2044",3)
		);
		
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8092/movies/"+rating.getMovieId(), Movie.class);
			return new MovieCatalogItem(movie.getName(), "Description", rating.getRating());
		}).collect(Collectors.toList());
	}
}
