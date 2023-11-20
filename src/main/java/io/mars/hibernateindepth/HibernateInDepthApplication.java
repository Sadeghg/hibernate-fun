package io.mars.hibernateindepth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateInDepthApplication implements CommandLineRunner {

    private final AccessoryRepository accessoryRepository;
    private final OwnerRepository ownerRepository;
    private final CarRepository carRepository;

    public HibernateInDepthApplication(AccessoryRepository accessoryRepository,
                                       OwnerRepository ownerRepository,
                                       CarRepository carRepository) {
        this.accessoryRepository = accessoryRepository;
        this.ownerRepository = ownerRepository;
        this.carRepository = carRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateInDepthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        scenarioTwo();
    }

    private void scenarioTwo(){
        Owner owner = new Owner("Sadegh");

        Car benz = new Car("Benz");
        Car audi = new Car("Audi");

        audi.setOwner(owner);
        benz.setOwner(owner);

        List<Car> carList = List.of(benz, audi);
        owner.setCarList(carList);

        ownerRepository.save(owner);
    }

    private void scenarioOne(){
        Car car = new Car("BMW");
        Owner owner = new Owner("Ali");
        Accessory accessory = new Accessory("Tire");

//        car.setOwner(owner);

        accessoryRepository.save(accessory);
        ownerRepository.save(owner);
        carRepository.save(car);
    }
}
