package ai_night.vote.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        log.info("log filter init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");
        // ServletRequest에는 기능이 얼마 없어서 다운캐스팅 해줘야 함
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // 요청을 구분하기 위해 uuid 생성
        String uuid = UUID.randomUUID().toString();

        try {
            // 로그 남기기
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            // 필터가 있으면 다음 필터가 계속해서 호출되고, 없으면 서블릿이 호출됨
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 예외 발생
            throw e;
        } finally {
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
