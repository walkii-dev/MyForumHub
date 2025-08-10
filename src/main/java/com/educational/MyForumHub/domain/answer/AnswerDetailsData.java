package com.educational.MyForumHub.domain.answer;

import com.educational.MyForumHub.domain.user.User;

import java.time.LocalDateTime;

public record AnswerDetailsData(Long id,
                                String message,
                                Long topicId ,
                                String author,
                                LocalDateTime lastChange,
                                Boolean active) {
    public AnswerDetailsData (Answer answer){
        this(answer.getId(), answer.getMessage(), answer.getTopic().getId(), answer.getAuthor().getUsername(), answer.getLastChange(),answer.getActive());
    }
}
