package ai_night.vote.choice.entity.repository;

import ai_night.vote.voteItem.entity.VoteItem;
import jakarta.persistence.*;

@Entity
public class Choice {

    @Id
    private Long id;

    @Column(name="isLogined")
    private Boolean isLogined;

    @Column(name="isVoted")
    private Boolean isVoted;

    @JoinColumn(name="voteItem_id")
    @OneToOne
    private VoteItem voteItem;
}
