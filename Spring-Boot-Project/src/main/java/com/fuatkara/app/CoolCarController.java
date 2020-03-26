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
    public Collection<Car> coolCars() {// Car'in icindeki butun colectionlari dondurur. 
    								  //Returns the number of elements in this collection.
        return repository.findAll().stream()  
                .filter(this::isCool)
                .collect(Collectors.toList());  //Yani application'daki stream bul diyor(find all) sonra filtrele 
    }
    
//    filter: The filter method is used to select elements as per the Predicate passed as argument.
//    List names = Arrays.asList("Reflection","Collection","Stream");
//    List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());

    private boolean isCool(Car car) {
        return !car.getName().equals("Fuat") &&
                !car.getName().equals("Furkan") &&
                !car.getName().equals("Fatih") &&
                !car.getName().equals("Mashar");
    }

//    private boolean isCool(Car car) {
//        return !car.getName().equals("AMC Gremlin") &&
//                !car.getName().equals("Triumph Stag") &&
//                !car.getName().equals("Ford Pinto") &&
//                !car.getName().equals("Yugo GV");
//    }


//    Runnable r = new  Runnable() {
//    	@GetMapping("/info")
//		@Override
//		public void run() {
//			System.out.println("La vie cest");
//		}
//	};
    
//Runnable r = ()-> System.out.print("Run method");  Bu yukaridekiyle ayni.
}