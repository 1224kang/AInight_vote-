package ai_night.vote.vote.controller;

import ai_night.vote.vote.Dto.VoteDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.vote.service.VoteService;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.service.VoteItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;
    private final VoteItemService voteItemService;

    //투표 카테고리 생성
    @PostMapping("/vote")
    public ResponseEntity<Vote> createVote (@RequestBody VoteDto dto){
        Vote vote=voteService.createVote(dto);
        return ResponseEntity.ok(vote);
    }

    // 부문별 투표 결과 조회
    @GetMapping("/vote/{vote_id}")
    public ResponseEntity<List<VoteItem>> showResult(@PathVariable("vote_id") Long id) {
        List<VoteItem> voteItemList = voteService.showResult(id);
        return ResponseEntity.ok(voteItemList);
    }



}
