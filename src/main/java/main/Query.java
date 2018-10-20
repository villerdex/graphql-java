package main;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
            pets[x] = new Pet(1, "pet"+x, Animal.DOG, 20, owner );

        }

       owner.setPets(Arrays.asList(pets));

        return owner;
    }
}
