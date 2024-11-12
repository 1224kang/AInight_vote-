package ai_night.vote.voteItem.service;

import ai_night.vote.vote.Dto.VoteItemDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.vote.repository.VoteRepository;
import ai_night.vote.vote.service.VoteService;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.repository.VoteItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class VoteItemService {

    @Autowired
    private VoteItemRepository voteItemRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private VoteService voteService;

    // 후보 등록
    public VoteItem createVoteItem(Long id, VoteItemDto voteItemDto) {
        if (id == null) {
            throw new IllegalArgumentException("The given ID must not be null");
        }

        // Optional<Vote>에서 Vote 객체를 꺼내고 예외 처리
        Optional<Vote> vote = voteRepository.findById(id);

        // Vote 객체를 직접 전달
        VoteItem voteItem = VoteItemDto.toEntity(voteItemDto, vote);
        return voteItemRepository.save(voteItem);
    }


    //후보에 대한 투표 -> vote count +1
    @Transactional
    public VoteItem votingItem(Long voteItem_id){
        VoteItem voteItem = voteItemRepository.findById(voteItem_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vote item ID"));
        //투표 수 증가
        voteItem.setVoteCount(voteItem.getVoteCount()+1); // 투표 수 증가

        // 항목이 속한 투표 ID로 득표율 갱신 및 전송
        voteService.sendVotePercentage(voteItem.getVote().getId());
        return voteItem;
    }
}
