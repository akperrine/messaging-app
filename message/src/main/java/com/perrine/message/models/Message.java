package com.perrine.message.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Message {

    @Id
    private String id;
    private String chatId;
    private String userId;
    private String content;

    @Indexed
    private Instant timestamp;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + chatId +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}