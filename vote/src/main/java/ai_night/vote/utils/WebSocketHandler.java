package ai_night.vote.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//다양한 클라이언트로부터 오는 메시지를 처리
//
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)throws Exception{
        String payload=message.getPayload();
//        log.info("payload {}",payload);
        TextMessage textMessage=new TextMessage("welcome");
        session.sendMessage(textMessage);
    }
}
