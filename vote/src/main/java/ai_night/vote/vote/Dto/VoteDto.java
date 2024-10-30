package ai_night.vote.vote.Dto;

import ai_night.vote.vote.entity.Vote;
import ai_night.vote.voteItem.entity.VoteItem;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//투표 카테고리 등록을 위한 dto
public class VoteDto {
    private String category;

    public static Vote toEntity(VoteDto dto){
        Vote vote=new Vote();
        vote.setCategory(dto.getCategory());
        return vote;
    }

}





