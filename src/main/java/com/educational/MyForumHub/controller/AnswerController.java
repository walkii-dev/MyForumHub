package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.answer.*;
import com.educational.MyForumHub.domain.topic.TopicListingData;
import com.educational.MyForumHub.domain.topic.TopicUpdateData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid AnswerCreationData data, UriComponentsBuilder uriBuilder){
        var answer = answerService.reply(data);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(answer.getId()).toUri();
        return ResponseEntity.created(uri).body(new AnswerDetailsData(answer));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AnswerUpdateData data){
        var answer = answerService.update(data);
        return ResponseEntity.ok(new AnswerDetailsData(answer));
    }

    @GetMapping
    public ResponseEntity<Page<AnswerDetailsData>> list(Pageable pagination){
        var page = answerRepository.findAll(pagination).map(AnswerDetailsData::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity close(@PathVariable Long id){
        answerRepository.getReferenceById(id).erase();
        return ResponseEntity.noContent().build();
    }



}
