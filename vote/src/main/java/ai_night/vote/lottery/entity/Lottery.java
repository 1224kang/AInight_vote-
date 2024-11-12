package ai_night.vote.lottery.entity;


import ai_night.vote.user.entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Lottery {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name="isApplied",nullable = true)
    private Boolean isApplied;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false) // JoinColumn을 통해 외래 키 지정
    private User user;




}


