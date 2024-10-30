package ai_night.vote.vote.entity;

import ai_night.vote.vote.Dto.VoteDto;
import ai_night.vote.voteItem.entity.VoteItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //id가 db에서 자동 생성되도록 설정
    private Long id;

    @Column(name="category")
    private String category;


    @OneToMany(mappedBy="vote",cascade=CascadeType.ALL)
    private List<VoteItem> voteItems;




//    //투표 항목 추가 메서드
//    public void addVoteItem(VoteItem voteItem){
//        voteItems.add(voteItem);
//        voteItem.setVote(this);//양방향 매핑
//    }
}
