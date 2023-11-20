package io.mars.hibernateindepth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Owner {

    public Owner(String name, List<Car> carList){
        this.carList = carList;
        this.name = name;
    }

    public Owner(String name){
        this.carList = new ArrayList<>();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Car> carList;

    public void addCar(Car car){
        this.carList.add(car);
    }

}
