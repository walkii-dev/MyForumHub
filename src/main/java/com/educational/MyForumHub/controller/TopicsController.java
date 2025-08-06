package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.topic.Topic;
import com.educational.MyForumHub.domain.topic.TopicCreationData;
import com.educational.MyForumHub.domain.topic.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TopicCreationData data){
        var topic = new Topic(data);
        topicRepository.save(topic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity closeTopic(@PathVariable Long id){
        topicRepository.getReferenceById(id).close();
        return ResponseEntity.noContent().build();
    }




}
