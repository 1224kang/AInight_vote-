package ai_night.vote.lottery.repository;

import ai_night.vote.lottery.entity.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryRepo extends JpaRepository<Lottery,Long> {
}
