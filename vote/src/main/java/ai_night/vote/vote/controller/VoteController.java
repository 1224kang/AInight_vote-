package ai_night.vote.vote.controller;

import ai_night.vote.vote.Dto.VoteDto;
import ai_night.vote.vote.Dto.VoteRequestDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.vote.service.VoteService;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.service.VoteItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final VoteItemService voteItemService;

    //투표 카테고리 생성
    @PostMapping("/vote")
    public ResponseEntity<Vote> createVote (@RequestBody VoteDto dto){
        Vote vote=voteService.createVote(dto);
        return ResponseEntity.ok(vote);
    }

    // WebSocket을 통한 투표 처리
    @MessageMapping("/voting")
    public void voting(@Payload VoteRequestDto dto){
        voteItemService.plusNumOfVoteItem(dto.getVoteItemId());
    }


}
