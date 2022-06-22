package pl.kapelinski.mateusz.taco.cloud.tacos.model;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<String> ingredients;
}
