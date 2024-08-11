package org.pictura.sample_chat_application.repository;

import org.pictura.sample_chat_application.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    @Query("{ 'userIds': { $all: [?0, ?1] } }")
    Optional<ChatRoom> findByUserIds(String userId1, String userId2);
}

