package com.wez.appwithgraphql.controller;

import com.wez.appwithgraphql.model.GraphQLRequestBody;
import com.wez.appwithgraphql.repositories.CustomerRepositories;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import lombok.AllArgsConstructor;
import com.wez.appwithgraphql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wez.appwithgraphql.services.GraphQlService;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private GraphQlService graphQlService;
    @Autowired
    private CustomerRepositories repositories;



    @PostMapping("/registration")
    public Customer registerCustomer(@RequestBody Customer customer) {
        repositories.save(customer);
        return customer;
    }


    @PostMapping("/login")

    public ResponseEntity<Object> loginCustomer (@RequestBody String query) {
        System.out.println("I AM RUNNING OH, WHATS THE PROBLEM");

        ExecutionResult execute = graphQlService.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);

    }
}
