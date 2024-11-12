package ai_night.vote.voteItem.dto;

import ai_night.vote.voteItem.entity.VoteItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponseDto {
    private Long id;
    private double turnout;

    public ItemResponseDto(Long id, double turnout) {
        this.id=id;
        this.turnout=turnout;
    }
}


