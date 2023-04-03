package com.example.application.Data;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Status extends  AbstractEntity{

    private String name;

}
