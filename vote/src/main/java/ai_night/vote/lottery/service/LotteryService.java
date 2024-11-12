package ai_night.vote.lottery.service;

import ai_night.vote.lottery.entity.Lottery;
import ai_night.vote.lottery.repository.LotteryRepo;
import ai_night.vote.user.entity.User;
import ai_night.vote.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class LotteryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LotteryRepo lotteryRepo;

    @Transactional
    public Lottery applyingLotto(Long id){
        // 회원 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("회원 조회가 불가합니다."));
        //request dto 생성(isApplied 값 랜덤 생성)
        boolean randomIsApplied=new Random().nextBoolean();
        Lottery lottery=new Lottery();
        lottery.setUser(user);
        lottery.setIsApplied(randomIsApplied);

        //repo에 저장
        lotteryRepo.save(lottery);
        return lottery;


    }


}
