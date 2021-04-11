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
        MemberService memberService = appConfig.memberService();

        // 2. 조회 -> 호출할 때마다 객체 생성하는지 조회
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른지 확인
        assertThat(memberService).isNotSameAs(memberService2);
    }


}
