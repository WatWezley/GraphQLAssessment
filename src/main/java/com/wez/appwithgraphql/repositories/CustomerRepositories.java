package com.wez.appwithgraphql.repositories;

import com.wez.appwithgraphql.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositories extends MongoRepository<Customer,String>{

    Customer findByEmail(String email);


}
