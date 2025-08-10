package com.educational.MyForumHub.domain.topic;


import com.educational.MyForumHub.domain.answer.Answer;
import com.educational.MyForumHub.domain.answer.AnswerDetailsData;
import com.educational.MyForumHub.domain.user.User;
import com.educational.MyForumHub.domain.user.UserDetailsData;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;

public record TopicDetailsData(Long id,
                               String title,
                               String message,
                               LocalDateTime lastChange,
                               Status topicStatus,
                               String author,
                               String course,
                               List<AnswerDetailsData> answers)
{
    public TopicDetailsData (Topic topic){
        this(topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getLastChange(),
                topic.getTopicStatus(),
                topic.getAuthor().getUsername(),
                topic.getCourse(),
                topic.getAnswers().stream().map(AnswerDetailsData::new).toList());
    }
}
