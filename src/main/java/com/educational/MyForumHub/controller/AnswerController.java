package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.answer.*;
import com.educational.MyForumHub.domain.topic.TopicListingData;
import com.educational.MyForumHub.domain.topic.TopicUpdateData;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("answers")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid AnswerCreationData data, @AuthenticationPrincipal UserDetails loggedUser, UriComponentsBuilder uriBuilder){
        var answer = answerService.reply(data,loggedUser);
        var uri = uriBuilder.path("/answers/{id}").buildAndExpand(answer.getId()).toUri();
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

    @DeleteMapping
    @Transactional
    public ResponseEntity close(@RequestBody @Valid DeleteAnswerData data){
        answerService.erase(data);
        return ResponseEntity.noContent().build();
    }



}
