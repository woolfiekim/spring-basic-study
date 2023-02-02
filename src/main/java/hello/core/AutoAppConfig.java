package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "hello.core", //이렇게 하면 저 member패키지에서만 componentscan이 된다.
    //지정하지 않으면 이 클래스의 패키지를 기준으로 다 스캔한다. > hello.core
    //전에 있던 예제 코드들을 제외하기 위해서 씀. 보통은 이 설정정보를 컴포넌트 스캔 대상에서 제외하지 않는다.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
