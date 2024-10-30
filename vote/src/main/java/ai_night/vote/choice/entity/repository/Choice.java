package ai_night.vote.choice.entity.repository;

import ai_night.vote.voteItem.entity.VoteItem;
import jakarta.persistence.*;

@Entity
public class Choice {

    @Id
    private Long id;

//    @JoinColumn(name="voteItem_id")
//    @ManyToMany
//    private VoteItem voteItem;
}
