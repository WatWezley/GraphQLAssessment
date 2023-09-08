package com.wez.appwithgraphql.services.customerService;

import com.wez.appwithgraphql.model.Customer;
import com.wez.appwithgraphql.repositories.CustomerRepositories;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataFetcher implements DataFetcher<Customer> {
    @Autowired
    private CustomerRepositories repository;


    @Override
    public Customer get(DataFetchingEnvironment environment) throws Exception {
        String email = environment.getArgument("email");
        return repository.findByEmail(email);
    }


}
