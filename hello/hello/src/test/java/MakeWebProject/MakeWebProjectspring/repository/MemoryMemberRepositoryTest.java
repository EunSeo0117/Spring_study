package MakeWebProject.MakeWebProjectspring.repository;

import MakeWebProject.MakeWebProjectspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { //함수하나 실행될때마다 끝나고 store지워줌
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member(); //멤버생성
        member.setName("Han");        //멤버에 이름을 Han으로 설정

        repository.save(member);      //member를 레퍼지토리에 저장
        Member result = repository.findById(member.getId()).get();
        //반환타입Optional꺼낼때 get()꺼냄. 좋은방법은 아니나 Test에선 써도 괜찮다.
        assertThat(member).isEqualTo(result); //assertions로 값은지비교함
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Eun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Seo");
        repository.save(member2);

        Member result = repository.findByName("Eun").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Eun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Seo");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}
