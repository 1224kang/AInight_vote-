package ai_night.vote.lottery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotteryResponseDto {
    private Long id;
    private Boolean isApplied;
    private Long user_id;
}
