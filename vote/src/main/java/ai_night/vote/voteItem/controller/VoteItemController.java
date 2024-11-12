package ai_night.vote.voteItem.controller;

import ai_night.vote.vote.Dto.VoteItemDto;
import ai_night.vote.voteItem.dto.ItemResponseDto;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.repository.VoteItemRepository;
import ai_night.vote.voteItem.service.VoteItemService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class VoteItemController {

    @Autowired
    private final VoteItemService voteItemService;
    private final VoteItemRepository voteItemRepository;

    //작품등록
    @PostMapping("/vote/{vote_id}")
    public ResponseEntity<VoteItem> createVoteItem(@RequestBody VoteItemDto dto, @PathVariable Long vote_id) {
        VoteItem voteItem = voteItemService.createVoteItem(vote_id, dto);
        return ResponseEntity.ok(voteItem);
    }

    // 투표
    @PutMapping("/vote/{vote_id}/{voteItem_id}")
    public ResponseEntity<String> votingItem(
            @PathVariable Long voteItem_id,
            @PathVariable Long vote_id) {

        // 투표 항목을 처리
        VoteItem voteItem = voteItemService.votingItem(voteItem_id);

        // 특정 투표 ID에 대한 투표 항목 조회
        List<VoteItem> voteItems = voteItemRepository.findByVoteId(vote_id);

        // 투표가 무사히 완료되었을 때 메시지를 반환
        return ResponseEntity.ok("투표가 완료되었습니다");
    }



//    //투표
//    @PutMapping("vote/{vote_id}/{voteItem_id}")
//    public void votingItem(@PathVariable Long voteItem_id){
//        VoteItem voteItem=voteItemService.votingItem(voteItem_id);
//    }







}
