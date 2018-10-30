package main.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import main.models.*;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public NormalPet createPet(String name, int age, Animal animal, Owner owner) {

        NormalPet pet = new NormalPet();
        pet.setId(1);
        pet.setName(name);

        pet.setAge(age);
        pet.setType(animal);

        pet.setOwner(owner);

        System.out.println("created pet");

        return pet;
    }

    public NormalPet addForAdoptPet(String name, int age, Animal animal, ScalarDate availableDate) {
        NormalPet pet = new NormalPet();

        pet.setId(1);
        pet.setName(name);
        pet.setAge(age);
        pet.setType(animal);
        pet.setAvailableDate(availableDate);

        System.out.println("pet for adopt created");

        return pet;

    }

    public WeirdPet addForAdoptWeirdPet(String name, int age, Classification classification, ScalarDate availableDate) {
        WeirdPet pet = new WeirdPet();

        pet.setId(1);
        pet.setName(name);
        pet.setAge(age);
        pet.setClassification(classification);
        pet.setAvailableDate(availableDate);

        System.out.println("pet for adopt created");

        return pet;

    }

}
