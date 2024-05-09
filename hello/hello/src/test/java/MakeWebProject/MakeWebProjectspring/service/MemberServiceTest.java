package MakeWebProject.MakeWebProjectspring.service;

import MakeWebProject.MakeWebProjectspring.domain.Member;
import MakeWebProject.MakeWebProjectspring.repository.MemberRepository;
import MakeWebProject.MakeWebProjectspring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // 실제 MemberService클래스에서 사용하는 memberRepository랑 테스트케이스에 작성된 레파지토리랑
    // 다른 공간임. 즉, 내용물이 달라질수있다는것. 즉 다른 레파지토리를 테스트하는것임
    // 그래서 memberservice코드에서 러퍼지토리를 contructor로 불러옴
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach() { //함수하나 실행될때마다 끝나고 store지워줌
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Han");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Tura");

        Member member2 = new Member();
        member2.setName("Tura");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다.");
    /*    try {
            memberService.join(member2); //예외터지는 부분
            fail(); // 이곳을 넘어오면 에러처리가 문제가있는것
        }catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다.");
        }*/
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}