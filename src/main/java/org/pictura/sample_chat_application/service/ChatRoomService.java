package org.pictura.sample_chat_application.service;

import lombok.RequiredArgsConstructor;
import org.pictura.sample_chat_application.model.ChatRoom;
import org.pictura.sample_chat_application.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
        return chatRoomRepository
                .findByUserIds(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    public String createGroupChat(String name, List<String> userIds) {
        var chatId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .chatId(chatId)
                .name(name)
                .userIds(userIds)
                .build();
        chatRoomRepository.save(chatRoom);
        return chatId;
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom chatRoom = ChatRoom.builder()
                .chatId(chatId)
                .userIds(List.of(senderId, recipientId))
                .build();

        chatRoomRepository.save(chatRoom);

        return chatId;
    }
}

