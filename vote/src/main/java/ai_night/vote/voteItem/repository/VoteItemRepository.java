package ai_night.vote.voteItem.repository;

import ai_night.vote.voteItem.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem,Long> {
    List<VoteItem> findByVoteId(Long voteId);
}
