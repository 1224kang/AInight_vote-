package ai_night.vote.vote.service;

import ai_night.vote.vote.Dto.ResponseVoteDto;
import ai_night.vote.vote.Dto.VoteDto;
import ai_night.vote.vote.Dto.VoteItemDto;
import ai_night.vote.vote.entity.Vote;
import ai_night.vote.vote.repository.VoteRepository;
import ai_night.vote.voteItem.entity.VoteItem;
import ai_night.vote.voteItem.repository.VoteItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    // 득표율 집계 및 반환
    public List<VoteItem> sendVotePercentage(Long voteId) {
        List<VoteItem> voteItems = voteItemRepository.findByVoteId(voteId);

        int totalVotes = voteItems.stream().mapToInt(VoteItem::getVoteCount).sum();

        // 각 항목의 득표율을 계산하고 turnout에 설정
        Map<Long, Double> votePercentages = voteItems.stream()
                .collect(Collectors.toMap(
                        VoteItem::getId,
                        item -> {
                            double percentage = totalVotes > 0 ? (double) item.getVoteCount() / totalVotes * 100 : 0.0;
                            double turnout=Math.round(percentage*10)/10.0;
                            item.setTurnout(turnout); // turnout 필드에 득표율 설정
                            return percentage;
                        }
                ));

        // 변경된 VoteItem 객체들을 데이터베이스에 저장
        voteItemRepository.saveAll(voteItems);
        return voteItems;

    }
    

    //투표 카테고리 생성
    @Transactional
    public Vote createVote(VoteDto dto){
        Vote vote=VoteDto.toEntity(dto);
        voteRepository.save(vote);
        return vote;
    }

    //부문별 투표 결과 조회
    @Transactional
    public List<VoteItem> showResult(Long id){
        List<VoteItem> voteItems =voteItemRepository.findByVoteId(id);
        // VoteItem 리스트를 VoteItemDto 리스트로 변환



        // VoteDto 객체 생성하여 반환
        return voteItems;
    }

}
