package main.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import main.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Object> pets() {
        List<Object> pets = new ArrayList();

        NormalPet aPet = new NormalPet();
        WeirdPet weirdPet = new WeirdPet();

        aPet.setId(100000);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);

        weirdPet.setId(1);
        weirdPet.setName("Weirdo");
        weirdPet.setAge(9);
        weirdPet.setClassification(Classification.Reptile);

        pets.add(aPet);
        pets.add(weirdPet);

        return pets;
    }

    public  List<WeirdPet>  getAdoptableWeirdPet() {
        WeirdPet weirdPet = new WeirdPet();
        weirdPet.setId(1);
        weirdPet.setName("Bill");
        weirdPet.setAge(9);
        weirdPet.setClassification(Classification.Reptile);

        List<WeirdPet> pets = new ArrayList();
        pets.add(weirdPet);

        return pets;
    }

    public Owner owner(int id) {
        Owner owner = new Owner();
        owner.setAddress("home address");
        owner.setName("John Doe");

        NormalPet[] pets = new NormalPet[5];

        // create ramdom pet as sample
        for (int x = 0; x <= 4; x ++) {
            pets[x] = new NormalPet(1, "pet"+ x, Animal.DOG, 20, owner, null );

        }

       owner.setPets(Arrays.asList(pets));

        return owner;
    }

    public List<NormalPet>  getAdoptablePet() {
        ScalarDate scalarDate = new ScalarDate(new Date());

        NormalPet aPet = new NormalPet();

        aPet.setId(1);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        aPet.setAvailableDate(scalarDate);

        List<NormalPet> pets = new ArrayList();
        pets.add(aPet);

        return pets;
    }
}
