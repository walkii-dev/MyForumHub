package com.educational.MyForumHub.domain.answer;

import java.time.LocalDateTime;

public record AnswerDetailsData(Long id,
                                String message,
                                Long topicId ,
                                String author,
                                LocalDateTime lastChange,
                                Boolean active) {
    public AnswerDetailsData (Answer answer){
        this(answer.getId(), answer.getMessage(), answer.getTopic().getId(), answer.getAuthor(), answer.getLastChange(),answer.getActive());
    }
}
