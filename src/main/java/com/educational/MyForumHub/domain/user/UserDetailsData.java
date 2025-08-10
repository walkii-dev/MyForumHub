package com.educational.MyForumHub.domain.user;

import com.educational.MyForumHub.domain.answer.AnswerDetailsData;
import com.educational.MyForumHub.domain.topic.TopicDetailsData;
import com.educational.MyForumHub.domain.topic.TopicListingData;

import java.util.List;

public record UserDetailsData(Long id, String login, UserRole role, List<TopicListingData> topics, List<AnswerDetailsData> answers) {
    public UserDetailsData(User user){
        this(   user.getId(),
                user.getLogin(),
                user.getRole(),
                user.getUserTopics().stream().map(TopicListingData::new).toList(),
                user.getUserAnswers().stream().map(AnswerDetailsData::new).toList()
            );
    }
}
