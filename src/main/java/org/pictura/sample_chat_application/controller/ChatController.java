package org.pictura.sample_chat_application.controller;

import lombok.RequiredArgsConstructor;
import org.pictura.sample_chat_application.model.ChatMessage;
import org.pictura.sample_chat_application.model.CreateGroupRequest;
import org.pictura.sample_chat_application.service.ChatMessageService;
import org.pictura.sample_chat_application.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @PostMapping("/message")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessage chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        return ResponseEntity.ok(savedMsg);
    }

    @GetMapping("/messages/{chatId}")
    public ResponseEntity<List<ChatMessage>> getMessages(@PathVariable String chatId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(chatId));
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> getMessages(
            @PathVariable String senderId,
            @PathVariable String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }

    @PostMapping("/group")
    public ResponseEntity<String> createGroupChat(@RequestBody CreateGroupRequest request) {
        String chatId = chatRoomService.createGroupChat(request.getName(), request.getUserIds());
        return ResponseEntity.ok(chatId);
    }
}

