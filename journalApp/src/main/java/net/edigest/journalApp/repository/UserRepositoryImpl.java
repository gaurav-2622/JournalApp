package net.edigest.journalApp.repository;

import net.edigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {


    @Autowired
    private MongoTemplate mongoTemplate;
    public List<User> getUsersForSA(){
        Query query = new Query();

        query.addCriteria(Criteria.where("email").regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));


 //     also can be used as or operator query.addCriteria(Criteria.where("email").exists(true).orOperator(Criteria.where("sentimentAnalysis").is(true)));
//        query.addCriteria(Criteria.where("userName").is("Gaurav"));
//        query.addCriteria(Criteria.where("age").is(20));
        List<User> users = mongoTemplate.find(query,User.class);
        return users;
    }
}
