package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //member부터 컴포넌트스캔을 함(멤버안에들은것만 스캔대상이됨)
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class, //autoAppConfing가 위치한 hello.core부터 탐색
        // 자동등록을 제한할것들을 골라냄(appconfig는 자동등록되면안되기때문에 걸러낸다.)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {
}
