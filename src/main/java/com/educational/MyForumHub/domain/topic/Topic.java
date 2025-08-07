package com.educational.MyForumHub.domain.topic;


import com.educational.MyForumHub.domain.answer.Answer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "last_change")
    private LocalDateTime lastChange;

    @Column(name = "topic_status")
    @Enumerated(EnumType.STRING)
    private Status topicStatus;

    @OneToMany
    private List<Answer> answers = new ArrayList<>();

    private String author;

    private String course;

    public Topic(TopicCreationData data){
        this.title= data.title();
        this.message = data.message();
        this.lastChange = LocalDateTime.now();
        this.topicStatus = Status.OPEN;
        this.author = data.author();
        this.course = data.course();
    }

    public void updateInfo(TopicUpdateData data){
        if(data.title() !=null){
            this.title = data.title();
        }
        if(data.message() !=null){
            this.message = data.message();
        }

        this.lastChange = LocalDateTime.now();

        if(data.author() !=null){
            this.author = data.author();
        }
        if(data.course() !=null){
            this.course = data.course();
        }
    }

    public void close(){
        this.topicStatus = Status.CLOSED;
        this.lastChange = LocalDateTime.now();
    }

}
