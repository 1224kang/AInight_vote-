package ai_night.vote.voteItem.entity;

import ai_night.vote.vote.entity.Vote;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    //이미지 첨부 //fe 상에서 그냥 처리해도 될거같긴함..ㅎㅎ
    @Column(name="imgs")
    String path="";

    @Column(name="description")
    private String description;


    @Column(name="voteCount")
    private Integer voteCount;

    @JoinColumn(name="voteId",nullable = true)
    @ManyToOne(fetch=FetchType.LAZY)
    private Vote vote;
}
