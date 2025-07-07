package org.scoula.boardapi.global.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web.xml을 대체하는 java 코드
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // root application context를 설정하는 부분
    // 이 곳에서는 웹 계층과 직접적인 관련 없는 공용 Bean 등록
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // servlet application context 설정
    // 컨트롤러, 핸들러 매핑등을 함
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑
    @Override
    protected String[] getServletMappings() {
        // "/"는 모든 요청을 DispatcherServlet이 받아서 처리하겠다는 의미
        return new String[]{"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        // 요청 데이터의 인코딩을 UTF-8 설정
        characterEncodingFilter.setEncoding("UTF-8");
        // 응답 데이터의 인코딩도 강제로 UTF-8 설정, 한글 깨짐 방지
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[]{characterEncodingFilter};
    }
}
