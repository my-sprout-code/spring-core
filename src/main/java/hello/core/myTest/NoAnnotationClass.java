package hello.core.myTest;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import hello.core.order.OrderService;

public class NoAnnotationClass {
    private final DiscountPolicy discountPolicy;
    private final MemberService memberService;
    private final OrderService orderService;

    public NoAnnotationClass(DiscountPolicy discountPolicy, MemberService memberService, OrderService orderService) {
        this.discountPolicy = discountPolicy;
        this.memberService = memberService;
        this.orderService = orderService;
    }

    public final void printAllAddress() {
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("memberService = " + memberService);
        System.out.println("orderService = " + orderService);
    }
}
