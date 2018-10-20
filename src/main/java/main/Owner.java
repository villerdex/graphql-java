package main;

import lombok.Data;

import java.util.List;

@Data
public class Owner {

    private int Id;
    private String name;
    private String address;
    private List<Pet> pets;
}
