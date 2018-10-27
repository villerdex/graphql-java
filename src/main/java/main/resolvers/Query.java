package main.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import main.models.Animal;
import main.models.Owner;
import main.models.Pet;
import main.models.ScalarDate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Pet> pets() {
        List<Pet> pets = new ArrayList();

        Pet aPet = new Pet();

        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);

        pets.add(aPet);

        return pets;
    }

    public Owner owner(int id) {
        Owner owner = new Owner();
        owner.setAddress("home address");
        owner.setName("John Doe");

        Pet[] pets = new Pet[5];

        // create ramdom pet as sample
        for (int x = 0; x <= 4; x ++) {
            pets[x] = new Pet(1, "pet"+x, Animal.DOG, 20, owner, null );

        }

       owner.setPets(Arrays.asList(pets));

        return owner;
    }

    public List<Pet>  getAdoptablePet() {
        ScalarDate scalarDate = new ScalarDate(new Date());

        List<Pet> pets = new ArrayList();

        Pet aPet = new Pet();

        aPet.setId(1);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        aPet.setAvailableDate(scalarDate);
        pets.add(aPet);

        return pets;
    }
}
