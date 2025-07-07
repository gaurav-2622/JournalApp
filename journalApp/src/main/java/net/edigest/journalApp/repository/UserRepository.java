package net.edigest.journalApp.repository;

import net.edigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByuserName (String username);
    void deleteByUserName (String username);
}
