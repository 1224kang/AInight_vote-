package ai_night.vote.lottery.dto;


import ai_night.vote.lottery.entity.Lottery;
import ai_night.vote.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryRequestDto {
    private Long id;
    private Boolean isApplied;
    private Long user_id;


}


