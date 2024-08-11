package org.pictura.sample_chat_application.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "chat_room")
public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String name;
    private List<String> userIds;
}

