package com.educational.MyForumHub.domain.topic;

import java.time.LocalDateTime;

public record TopicListingData(Long id,
                               String title,
                               LocalDateTime lastChange,
                               Status topicStatus,
                               String course)
{
    public TopicListingData (Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getLastChange(),topic.getTopicStatus(), topic.getCourse());
    }

}
