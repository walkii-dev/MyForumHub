package com.educational.MyForumHub.domain.answer;

import com.educational.MyForumHub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Answer reply(AnswerCreationData data){

        var topic = topicRepository.getReferenceById(data.topicId());
        var answer = new Answer(data,topic);

        answerRepository.save(answer);
        return answer;
    }

    public Answer update(AnswerUpdateData data){
        var answer = answerRepository.getReferenceById(data.answerId());
        answer.updateInfo(data);
        answerRepository.save(answer);
        return answer;
    }

}
