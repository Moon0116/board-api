package org.scoula.boardapi.global.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// 웹 요청 처리와 관련된 설정을 담당
@EnableWebMvc // 스프링 MVC의 자동 설정을 활성화 하는 어노테이션, Bean을 자동 등록해준다.
public class ServletConfig implements WebMvcConfigurer {

    // 이 메서드는 정적 자원(static resources)의 경로를 설정하는 역할
    // 결론적으로 /resources/ 경로 아래에 있는 정적 파일들을 웹 브라우저에서 정상적으로 불러와 사용 가능
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 브라우저에서 /resources/로 시작하는 모든 URL 요청을 처리하겠다는 의미
        registry.addResourceHandler("/resources/**") // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/"); // webapp/resources/ 경로로 매핑
    }

}
