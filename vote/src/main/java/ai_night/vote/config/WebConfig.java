package ai_night.vote.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //로그 필터 등록
    @Bean
    public FilterRegistration logFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
