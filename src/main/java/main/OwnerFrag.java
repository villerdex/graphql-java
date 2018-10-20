package main;

import lombok.Data;

import java.util.List;

@Data
public class OwnerFrag {

    private int Id;
    private String name;
    private String address;
    private List<Pet> pets;
}
