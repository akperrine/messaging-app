package com.perrine.message.dto;

import com.perrine.message.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChatUsersDTO {
        List<String> userIdsToAdd;
}
