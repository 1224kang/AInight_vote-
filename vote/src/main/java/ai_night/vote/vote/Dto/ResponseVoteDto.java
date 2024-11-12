package ai_night.vote.vote.Dto;

import ai_night.vote.voteItem.entity.VoteItem;

import java.util.List;

public class ResponseVoteDto {

    private Long voteId;
    private String category;
    private List<VoteItemDto> items;

    public ResponseVoteDto(Long voteId, List<VoteItemDto> items) {
        this.voteId = voteId;
        this.items = items;
    }

}
