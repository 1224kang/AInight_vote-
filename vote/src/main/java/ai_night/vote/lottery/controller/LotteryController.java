package ai_night.vote.lottery.controller;

import ai_night.vote.lottery.dto.LotteryRequestDto;
import ai_night.vote.lottery.dto.LotteryResponseDto;
import ai_night.vote.lottery.entity.Lottery;
import ai_night.vote.lottery.service.LotteryService;
import ai_night.vote.user.entity.User;
import ai_night.vote.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @Autowired
    private UserRepository userRepository;

    //응모하기 및 결과 조회
    //복권 페이지 들어오는 순간 get 호출
    // 응모하기 및 결과 조회
    @PostMapping("/lotto/{user_id}")
    public ResponseEntity<Map<String, Object>> applyingLotto(@PathVariable Long user_id) {
        Lottery lottery = lotteryService.applyingLotto(user_id); // user_id 사용
        Boolean result = lottery.getIsApplied();

        // 응답할 데이터 생성
        Map<String, Object> response = new HashMap<>();
        response.put("message", "정상 처리.");
        response.put("result", result);

        return ResponseEntity.ok(response); // ResponseEntity에 response를 포함
    }
}
