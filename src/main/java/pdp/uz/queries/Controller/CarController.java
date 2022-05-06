package pdp.uz.queries.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.queries.Entity.AutoShop;
import pdp.uz.queries.Entity.Car;
import pdp.uz.queries.Payload.CarDto;
import pdp.uz.queries.Repository.AutoShopRepository;
import pdp.uz.queries.Repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AutoShopRepository autoShopRepository;

    @GetMapping
    public List<Car> readCar(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @PostMapping
    public String addCar(@RequestBody CarDto carDto){

        Car car = new Car();
        car.setModel(carDto.getModel());
        car.setPrice(car.getPrice());
        car.setYear(car.getYear());

        Optional<AutoShop> optionalAutoShop = autoShopRepository.findById(car.getId());
        if(optionalAutoShop.isPresent()){

            car.setAutoShop(optionalAutoShop.get());
            carRepository.save(car);
            return "saved";

        }
        return "not found";

    }

    @DeleteMapping("/{carId}")
    public String deleteCar(@PathVariable Integer carId){
        carRepository.deleteById(carId);
        return "deleted";
    }

    @GetMapping("/{autoShopId}")
    public List<Car> getCarByAutoShopId(@PathVariable Integer autoShopId){

        List<Car> carByAutoShopId = carRepository.getCarByAutoShopId(autoShopId);
        return carByAutoShopId;
    }

}
