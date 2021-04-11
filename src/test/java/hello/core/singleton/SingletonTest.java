package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    @DisplayName("스프링 컨테이너와 싱글톤")
    @Test
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회 -> 호출할 때마다 객체 생성하는지 조회
        MemberService memberService1 = ac.getBean("memberService", MemberServiceImpl.class);

        // 2. 조회 -> 호출할 때마다 객체 생성하는지 조회
        MemberService memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

        System.out.println("singletonService1 = " + memberService1);
        System.out.println("singletonService2 = " + memberService2);

        // 참조값이 다른지 확인
        assertThat(memberService1).isSameAs(memberService2);
    }


}
