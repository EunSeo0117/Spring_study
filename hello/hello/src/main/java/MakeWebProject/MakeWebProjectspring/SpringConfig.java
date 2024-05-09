package MakeWebProject.MakeWebProjectspring;

import MakeWebProject.MakeWebProjectspring.aop.TimeTraceAop;
import MakeWebProject.MakeWebProjectspring.repository.*;
import MakeWebProject.MakeWebProjectspring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository); //생성자에 레퍼지토리필요
    }

 //   @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository()
//        //return new JdbcMemberRepository(dataSource); //데이터소스를 spring에서줌
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//
//    }
}
