package ai_night.vote.vote.service;

import ai_night.vote.vote.Dto.VoteDto;
import ai_night.vote.vote.Dto.VoteItemDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.vote.repository.VoteRepository;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.repository.VoteItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class VoteService {

    @Autowired
    private final VoteRepository voteRepository;
    @Autowired
    private final VoteItemRepository voteItemRepository;
//    private final SimpMessagingTemplate simpMessagingTemplate;


    //득표율 집계 및 전송
    public void sendVotePercentage(Long voteId){
        List<VoteItem> voteItems=voteItemRepository.findByVoteId(voteId);
        int totalVotes=voteItems.stream().mapToInt(VoteItem::getVoteCount).sum();

        //각 항목의 득표율 계산
        Map<Long,Double> votePercentages=voteItems.stream()
                .collect(Collectors.toMap(
                        VoteItem::getId,
                        item->totalVotes>0?(double)item.getVoteCount()/totalVotes*100:0.0
                ));

//        // WebSocket을 통해 클라이언트에 득표율 전송
//        simpMessagingTemplate.convertAndSend("/subscribe/vote/" + voteId, votePercentages);
    }
    

    //투표 카테고리 생성
    @Transactional
    public Vote createVote(VoteDto dto){
        Vote vote=VoteDto.toEntity(dto);
        voteRepository.save(vote);
        return vote;
    }

}
