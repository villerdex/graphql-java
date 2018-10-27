package main.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import main.models.Animal;
import main.models.Owner;
import main.models.Pet;
import main.models.ScalarDate;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Pet createPet(String name, int age, Animal animal, Owner owner) {

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName(name);

        pet.setAge(age);
        pet.setType(animal);

        pet.setOwner(owner);

        System.out.println("created pet");

        return pet;
    }

    public Pet addForAdoptPet(String name, int age, Animal animal, ScalarDate availableDate) {
        Pet pet = new Pet();

        pet.setId(1);
        pet.setName(name);
        pet.setAge(age);
        pet.setType(animal);
        pet.setAvailableDate(availableDate);

        System.out.println("pet for adopt created");

        return pet;

    }

}
