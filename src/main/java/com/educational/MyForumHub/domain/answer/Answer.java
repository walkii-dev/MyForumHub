package com.educational.MyForumHub.domain.answer;

import com.educational.MyForumHub.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Answer")
@Table(name = "answers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private String author;

    private LocalDateTime lastChange;

    private Boolean active;

    public Answer(AnswerCreationData data,Topic topic){
        this.message = data.message();
        this.topic = topic;
        this.lastChange = LocalDateTime.now();
        this.author = data.author();
        this.active = true;
    }

    public void updateInfo(AnswerUpdateData data){

        if(data.message() !=null){
            this.message = data.message();
        }

        this.lastChange = LocalDateTime.now();

    }
    public void erase(){
        this.active = false;
        this.lastChange = LocalDateTime.now();
    }


}
