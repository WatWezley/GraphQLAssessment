package com.wez.appwithgraphql.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor

@Document(collection = "Customers")
public class Customer {
@Id
    private String id;
    private String name;
    private String email;
    private String password;




}
