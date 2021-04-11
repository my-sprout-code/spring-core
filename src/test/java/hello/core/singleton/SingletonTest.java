package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @DisplayName("스프링 없는 순수 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 -> 호출할 때마다 객체 생성하는지 조회
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 -> 호출할 때마다 객체 생성하는지 조회
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른지 확인
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @DisplayName("싱글톤 패턴을 적용한 사례")
    @Test
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }


}
