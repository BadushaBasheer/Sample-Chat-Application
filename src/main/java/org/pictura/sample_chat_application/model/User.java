package org.pictura.sample_chat_application.model;

import lombok.*;
import org.pictura.sample_chat_application.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    @Id
    private String nickName;
    private String fullName;
    private Status status;
}

