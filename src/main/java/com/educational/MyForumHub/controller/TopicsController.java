package com.educational.MyForumHub.controller;

import com.educational.MyForumHub.domain.topic.*;
import com.educational.MyForumHub.domain.user.User;
import com.educational.MyForumHub.domain.user.UserRepository;
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
@RequestMapping("topics")
@SecurityRequirement(name = "bearer-key")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDetailsData(topic));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TopicCreationData data,
                                 @AuthenticationPrincipal UserDetails loggedUser,
                                 UriComponentsBuilder uriBuilder){

        var author = (User) userRepository.findByLogin(loggedUser.getUsername());

        System.out.println(author);

        var topic = new Topic(data,author);

        topicRepository.save(topic);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDetailsData(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid TopicUpdateData data){
        var topic = topicRepository.getReferenceById(data.id());
        topic.updateInfo(data);
        return ResponseEntity.ok(new TopicUpdateData(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicListingData>> list(Pageable pagination){
        var page = topicRepository.findAll(pagination).map(TopicListingData::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity close(@PathVariable Long id){
        topicRepository.getReferenceById(id).close();
        return ResponseEntity.noContent().build();
    }




}
