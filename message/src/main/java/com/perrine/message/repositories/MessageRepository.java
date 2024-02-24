package com.perrine.message.repositories;

import com.perrine.message.models.Message;
import org.springframework.data.domain.OffsetScrollPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    public Page<Message> findByChatIdInOrderByTimestampDesc(String chatId, Pageable pageable);
}
