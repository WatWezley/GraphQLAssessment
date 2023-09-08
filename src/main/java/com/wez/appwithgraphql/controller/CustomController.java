package com.wez.appwithgraphql.controller;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/graphql")
public class CustomController {

//    private final GraphQL graphQL;
//
//    @Autowired
//    public CustomController(GraphQLSchema graphQLSchema) {
//        graphQLSchema = GraphQLSchema.newSchema().build();
//        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> executeGraphQL(@RequestBody Map<String, Object> requestMap) {
//        String query = (String) requestMap.get("query");
//        if (query == null || query.trim().isEmpty()) {
//            return new ResponseEntity<>("No GraphQL query provided", HttpStatus.BAD_REQUEST);
//        }
//
//        ExecutionResult executionResult;
//        try {
//            executionResult = graphQL.execute(query);
//        } catch (GraphQLException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//        if (executionResult.getErrors().isEmpty()) {
//            return new ResponseEntity<>(executionResult.getData(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(executionResult.getErrors(), HttpStatus.BAD_REQUEST);
//        }
//    }
}


