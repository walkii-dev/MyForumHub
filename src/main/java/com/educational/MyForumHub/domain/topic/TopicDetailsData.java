package com.educational.MyForumHub.domain.topic;


import java.time.LocalDateTime;

public record TopicDetailsData(Long id,
                               String title,
                               String message,
                               LocalDateTime lastChange,
                               Status topicStatus,
                               String author,
                               String course)
{
    public TopicDetailsData (Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getLastChange(),topic.getTopicStatus(), topic.getAuthor(), topic.getCourse());
    }
}
