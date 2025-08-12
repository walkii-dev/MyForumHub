package com.educational.MyForumHub.domain.answer;

import com.educational.MyForumHub.domain.topic.TopicRepository;
import com.educational.MyForumHub.domain.user.User;
import com.educational.MyForumHub.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;


    public Answer reply(AnswerCreationData data, UserDetails loggedUser){

        var topic = topicRepository.getReferenceById(data.topicId());

        User author = (User) userRepository.findByLogin(loggedUser.getUsername());

        var answer = new Answer(data,topic,author);

        answerRepository.save(answer);
        return answer;
    }

    public Answer update(AnswerUpdateData data){
        var answer = answerRepository.getReferenceById(data.answerId());
        answer.updateInfo(data);
        answerRepository.save(answer);
        return answer;
    }

    public void erase(@Valid DeleteAnswerData data) {
        var topic = topicRepository.getReferenceById(data.topicId());
        var answers = topic.getAnswers();
        //for each answer in answers list have to be checked. if the answer_id delivered in the param is equal
        //to one of the answers in the list, just do the erase method.
//        if (data.id().equals(answers.get().getId())){
//
//        }

    }


}
