package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImp implements CarDAO {
    private List<Car> car;

    {
        car = new ArrayList<>();
        car.add(new Car("Audi", "Black", 2024));
        car.add(new Car("BMW", "Red", 2025));
        car.add(new Car("Mercedes", "White", 2020));
        car.add(new Car("Ford", "Green", 2010));
        car.add(new Car("Honda", "Yellow", 2012));

    }


    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return car;
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(car.get(i));
        }
        return cars;
    }
}
