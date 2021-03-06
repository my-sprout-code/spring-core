package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) // 빈이 없을 경우, 해당 메서드를 호출하지 않는다. DI 안한다.
        public void setNoBean1(Member noBean1) {
            // 스프링이 관리하지 않는 빈을 파라미터로 받았다.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // 호출은 되지만 null
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3) { // Optional.empty
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
