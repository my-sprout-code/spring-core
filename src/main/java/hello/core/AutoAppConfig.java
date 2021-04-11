package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 스캔은 별다른 루트 디렉터리를 주지 않으면 현 클래스를 루트디렉토리로 잡는다.
// 즉, 현 클래스부터 하위 디렉터리의 @Component 어노테이션이 붙은 클래스를 빈으로 등록한다.(이 클래스도)
// 제외할 요소들을 선택하는데, AppConfig 와 같은 @Configuration 을 사용하는 클래스는 제외
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
