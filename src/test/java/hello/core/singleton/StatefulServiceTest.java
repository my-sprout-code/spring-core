package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int priceA = statefulService1.order("userA", 10000);
        int priceB =  statefulService1.order("userB", 20000);

        System.out.println("priceA = " + priceA);   // 값이 예상과 다르게 나온다.
        System.out.println("priceB = " + priceB);

        assertThat(priceA).isNotEqualTo(priceB); // 잘못된 테스트 케이스까지 통과된다.
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }
}