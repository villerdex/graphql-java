package main.models;

import lombok.Data;

import java.util.List;

@Data
public class Owner {

    private long Id;
    private String name;
    private String address;
    private List<NormalPet> pets;
}
