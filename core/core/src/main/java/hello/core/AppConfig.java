package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration //설정정보, 구성성보를 담는코드에 붙임
public class AppConfig {
    //예상콜순서
    //call AppConfig.memberService
    //call call AppConfig.memberRepository
    //call call AppConfig.memberRepository
    //call AppConfig.orderService
    //call call AppConfig.memberRepository

    //실제콜
    //call AppConfig.memberService
    //call AppConfig.memberRepository(3번이아닌 1번만 호출됨)
    //call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        //System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        //System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
