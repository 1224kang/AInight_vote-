package ai_night.vote.vote.Dto;

import ai_night.vote.vote.entity.Vote;
import ai_night.vote.voteItem.entity.VoteItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//투표 후보 등록을 위한 dto
public class VoteItemDto {
    private String title;
    private String path;
    private String description;
    private Float turnout;
    private Integer vote_count;
    @JsonProperty("voteId")
    private Vote vote; // 연결될 Vote ID를 받기 위한 필드

    // DTO를 엔티티로 변환하는 메서드
    public static VoteItem toEntity(VoteItemDto dto, Optional<Vote> vote) {
        VoteItem voteItem=new VoteItem();
        voteItem.setTitle(dto.getTitle());
        voteItem.setPath(dto.getPath());
        voteItem.setDescription(dto.getDescription());
        voteItem.setVoteCount(dto.getVote_count());
        vote.ifPresent(voteItem::setVote);
        return voteItem;
    }


}
