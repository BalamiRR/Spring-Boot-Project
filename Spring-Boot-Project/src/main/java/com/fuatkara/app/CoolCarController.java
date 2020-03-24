package com.fuatkara.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolCarController {
    private CarRepository repository;

    public CoolCarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
        return repository.findAll().stream()  
                .filter(this::isCool)
                .collect(Collectors.toList());  //Yani application'daki stream bul diyor(find all) sonra filtrele 
    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
    
//    Runnable r = new  Runnable() {
//    	@GetMapping("/info")
//		@Override
//		public void run() {
//			System.out.println("La vie cest");
//		}
//	};
    
//Runnable r = ()-> System.out.print("Run method");  Bu yukaridekiyle ayni.
}