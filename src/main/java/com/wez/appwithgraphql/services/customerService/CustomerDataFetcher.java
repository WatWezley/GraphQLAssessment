package com.wez.appwithgraphql.services.customerService;

import com.wez.appwithgraphql.model.Customer;
import com.wez.appwithgraphql.repositories.CustomerRepositories;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerDataFetcher implements DataFetcher<Customer> {
    @Autowired
    private CustomerRepositories repository;


    @Override
    public Customer get(DataFetchingEnvironment environment) throws Exception {
        String email = environment.getArgument("email");
        return repository.findByEmail(email);
    }

    public DataFetcher<Customer> registerCustomer() {
        return env -> {
            String name = env.getArgument("name");
            String email = env.getArgument("email");
            String password = env.getArgument("password");
            password = Base64.getEncoder().encodeToString(password.getBytes());


            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);

            return repository.save(customer);

        };


    }
}
