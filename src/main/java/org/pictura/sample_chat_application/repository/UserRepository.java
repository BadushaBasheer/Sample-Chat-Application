package org.pictura.sample_chat_application.repository;

import org.pictura.sample_chat_application.enums.Status;
import org.pictura.sample_chat_application.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);
}

