package ai_night.vote.filter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckFilter implements Filter{
    // 경로중에 들어올 수 있는 경로들 //수정할 필요가있다............
    private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

}
