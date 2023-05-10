package com.cardatabase;

import com.cardatabase.domain.Car;
import com.cardatabase.domain.CarRepository;
import com.cardatabase.domain.Owner;
import com.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {


    @Autowired
    private CarRepository repository;
    @Autowired
    private OwnerRepository ownerRepository;
    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John","Johnson");
        Owner owner2 = new Owner("Mary","Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1,owner2));
        repository.save(new Car("Ford","Mustang","Red","ADF-11211",2021,59000,owner1));
        repository.save(new Car("Nissan","Leaf","White","SSJ-3002",2019,29000,owner2));
        repository.save(new Car("Toyota","Prius","Silver","KKO-0212",2020,39000,owner2));
    }
}
