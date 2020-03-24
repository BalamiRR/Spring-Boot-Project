package com.fuatkara.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CarRepository extends JpaRepository<Car, Long> {
	//Car sinifina ait ekleme silme duzenleme yapican anlamina geliyor.
	
}