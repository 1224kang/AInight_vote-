package ai_night.vote.voteItem.dto;

import ai_night.vote.voteItem.service.VoteItemService;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class VoteCategoryDto {
    private Set<WebSocketSession> sessions=new HashSet<>();

//    //id가 같으면 session 추가하는 방식
//    public void handleActions(WebSocketSession session, VoteItemService voteItemService){
//        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)){
//            sessions.add(session);
//            chatMessage.setNumOfVotes(chatMessage.getSender()+"님이 입장했습니다.");
//        }
//        plusNumOfVotes(1,voteItemService);
//    }
//
//    public double plusNumOfVoteItem(VoteItemService voteItemService){
//        //parallelStream -> 병렬 스트림으로 변환. 여러 스레드에서 동시 작업 수행 가능.
//        sessions.parallelStream().forEach(session-> {
//            voteItemService.plusNumOfVoteItem(session);
//        });
//    }
}
