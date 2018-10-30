package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalPet {

    private long id;

    private String name;

    private Animal type;

    private int age;

    private Owner owner;

    private ScalarDate availableDate;
}
