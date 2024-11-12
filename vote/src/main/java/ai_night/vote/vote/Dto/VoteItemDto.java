package ai_night.vote.vote.Dto;

import ai_night.vote.vote.entity.Vote;
import ai_night.vote.voteItem.entity.VoteItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
//투표 후보 등록을 위한 dto
public class VoteItemDto {
    private String title;
    private String description;
    private double turnout;
    private int vote_count;



    // DTO를 엔티티로 변환하는 메서드
    public static VoteItem toEntity(VoteItemDto dto, Optional<Vote> vote) {
        VoteItem voteItem=new VoteItem();
        voteItem.setTitle(dto.getTitle());
        voteItem.setDescription(dto.getDescription());
        voteItem.setVoteCount(dto.getVote_count());
        vote.ifPresent(voteItem::setVote);
        return voteItem;
    }


}
