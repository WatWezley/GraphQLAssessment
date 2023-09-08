package com.wez.appwithgraphql.services.customerService;

import com.wez.appwithgraphql.model.Customer;
import com.wez.appwithgraphql.repositories.CustomerRepositories;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AllCustomersDataFetcher implements DataFetcher<List<Customer>> {
@Autowired
    private CustomerRepositories repository;
    @Override
    public List<Customer> get(DataFetchingEnvironment environment) throws Exception {
        return repository.findAll();
    }
}
