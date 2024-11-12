package ai_night.vote.voteItem.entity;

import ai_night.vote.vote.entity.Vote;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class VoteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;


    @Column(name="description")
    private String description;


    @Column(name="voteCount")
    @Builder.Default
    private int voteCount=0;


    @Column(name="turnout")
    @Builder.Default
    private double turnout=0;


    @JoinColumn(name="voteId",nullable = true)
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Vote vote;

}
