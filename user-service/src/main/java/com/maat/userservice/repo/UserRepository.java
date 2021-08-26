package com.maat.userservice.repo;

import com.maat.datamodel.beans.Blog;
import com.maat.datamodel.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
