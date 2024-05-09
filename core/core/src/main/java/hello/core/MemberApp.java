package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) { //psvm
        //appconfig를 통해 객체 주입받기
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //제어클래스전달
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//등록된객체이름, 타입전달

        Member member = new Member(1L, "memberA", Grade.VIP); //1L : Long타입이라붙임
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member =" + findMember.getName()); //soutv

        

    }
}
