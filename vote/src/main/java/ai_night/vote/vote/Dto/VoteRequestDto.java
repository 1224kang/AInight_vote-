package ai_night.vote.vote.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequestDto {
    @NotNull
    private Long senderId;

    @NotNull
    private Long receiverId;

    @NotNull
    private Long vote_id;

    @NotNull
    private Long voteItemId;

    @NotNull
    private Float turnout;
}
