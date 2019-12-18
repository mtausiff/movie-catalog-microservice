package com.movie.catalog.microservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalog.microservice.models.MovieCatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<MovieCatalogItem> getCatalog(@PathVariable("userId") String userId){		
		return Collections.singletonList(
				new MovieCatalogItem("Titanic", "Titanic Description", 1001)				
		);
	}
}
