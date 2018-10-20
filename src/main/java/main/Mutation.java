package main;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
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

}
