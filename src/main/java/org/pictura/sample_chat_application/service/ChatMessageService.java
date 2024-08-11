package org.pictura.sample_chat_application.service;

import lombok.RequiredArgsConstructor;
import org.pictura.sample_chat_application.model.ChatMessage;
import org.pictura.sample_chat_application.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatMessage.isGroupMessage() ? chatMessage.getChatId() :
                chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                        .orElseThrow(); // You can create your own dedicated exception
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String chatId) {
        return repository.findByChatId(chatId);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}


