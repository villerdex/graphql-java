package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeirdPet {

    private long id;
    private String name;
    private int age;
    private ScalarDate availableDate;
    private Classification classification;

}
