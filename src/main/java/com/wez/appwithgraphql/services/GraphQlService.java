package com.wez.appwithgraphql.services;

import com.wez.appwithgraphql.services.customerService.AllCustomersDataFetcher;
import com.wez.appwithgraphql.services.customerService.CustomerDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GraphQlService {



    @Value("classpath:customer.graphql")
    Resource resource;

    private GraphQL graphQL;
    @Autowired
    private AllCustomersDataFetcher allCustomersDataFetcher;
    @Autowired
    private CustomerDataFetcher customerDataFetcher;


    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }



    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getAllCustomers", allCustomersDataFetcher))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("loginCustomer", customerDataFetcher))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("signUpCustomer", customerDataFetcher.registerCustomer()))
                .build();

    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}




