package com.wez.appwithgraphql.controller;

import com.wez.appwithgraphql.model.GraphQLRequestBody;
import com.wez.appwithgraphql.repositories.CustomerRepositories;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import lombok.AllArgsConstructor;
import com.wez.appwithgraphql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wez.appwithgraphql.services.GraphQlService;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private GraphQlService graphQlService;


    @PostMapping(value="customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Map<String,Object>> execute(@RequestBody GraphQLRequestBody body) {
        return Mono.fromCompletionStage(graphQlService.getGraphQL().executeAsync(ExecutionInput.newExecutionInput().query(body.getQuery())
                        .operationName(body.getOperationName()).variables(body.getVariables()).build()))
                .map(ExecutionResult::toSpecification);

    }
}
