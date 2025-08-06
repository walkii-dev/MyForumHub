package com.educational.MyForumHub.domain.topic;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;
    @Column(unique = true)
    private String message;

    @Column(name = "creation_data")
    private LocalDateTime creationData;

    @Column(name = "topic_status")
    private Status topicStatus;

    private String author;

    private String course;

    public Topic(TopicCreationData data){
        this.title= data.title();
        this.message = data.message();
        this.creationData = LocalDateTime.now();
        this.topicStatus = Status.OPEN;
        this.author = data.author();
        this.course = data.course();
    }

    public void close(){
        this.topicStatus = Status.CLOSED;
    }

}
