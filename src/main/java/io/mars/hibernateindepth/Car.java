package io.mars.hibernateindepth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Car {

    public Car(String model, List<Accessory> accessoryList){
        this.accessoryList = accessoryList;
        this.model = model;
    }

    public Car(String model){
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "car_owner_foreign_key_id"))
    private Owner owner;

    @OneToMany(mappedBy = "car")
    private List<Accessory> accessoryList;

    public void addAccessory(Accessory accessory){
        this.accessoryList.add(accessory);
    }
}
