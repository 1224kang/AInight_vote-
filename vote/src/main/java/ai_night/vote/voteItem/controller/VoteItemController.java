package ai_night.vote.voteItem.controller;

import ai_night.vote.vote.Dto.VoteItemDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.service.VoteItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class VoteItemController {

    @Autowired
    private final VoteItemService voteItemService;

    //작품등록
    @PostMapping("/vote/{vote_id}")
    public ResponseEntity<VoteItem> createVoteItem(@RequestBody VoteItemDto dto,@PathVariable Long vote_id){
        VoteItem voteItem=voteItemService.createVoteItem(vote_id,dto);
        return ResponseEntity.ok(voteItem);
    }







}
