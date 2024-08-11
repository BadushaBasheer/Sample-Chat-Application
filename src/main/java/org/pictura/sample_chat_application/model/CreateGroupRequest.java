package org.pictura.sample_chat_application.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGroupRequest {
    private String name;
    private List<String> userIds;
}

