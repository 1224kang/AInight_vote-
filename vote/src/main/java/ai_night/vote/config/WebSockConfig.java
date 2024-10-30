package ai_night.vote.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

//별도의 코드없이 DI
@RequiredArgsConstructor
//스프링 빈 등록 + 싱글톤 보장 + 설정파일임
@Configuration
//웹소켓 활성화 어노테이션
@EnableWebSocketMessageBroker
//websocket 연결을 요청할 주소와 SUBSCRIBE,PUBLISH를 요청할 주소를 설정해줌
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    //websocket 연결을 위한 endpoint 정보 설정
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws-connection")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    //메시지 브로커로 라우팅할 접두어 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //subscribe로 시작하는 주소의 subscriber들에게 메시지 전달
        registry.enableSimpleBroker("/vote");
        //client가 server로 메시지를 보낼 때 붙여야 하는 prefix
        registry.setApplicationDestinationPrefixes("/publish");
    }

}
