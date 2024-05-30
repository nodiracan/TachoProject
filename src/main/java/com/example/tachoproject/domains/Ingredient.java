package com.example.tachoproject.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient{

    @Id
    private  String id;
    private  String name;
    private  Type type;



    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE


    }
}