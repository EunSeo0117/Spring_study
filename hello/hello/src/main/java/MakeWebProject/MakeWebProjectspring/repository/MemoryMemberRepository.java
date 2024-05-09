package MakeWebProject.MakeWebProjectspring.repository;

import MakeWebProject.MakeWebProjectspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {     //유저이름이 member로 넘어옴
        member.setId(++sequence);           //id는 시스템에서 유저네임저장시 임의로 제작되는 번호임
        store.put(member.getId(),member);   //sequence를 받을때마다 증가시켜 id에 임의로 배정후
        return member;                      //아이디,이름을 store에 저장하고 이름값리턴
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //Optional.ofNullable로 감싸면 null값이 들어올때
                                                    //클라이언트에서 다른동작이 가능하다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()                           //member.getName()이
                .filter(member -> member.getName().equals(name)) //파라미터로 넘어온 name과 같은경우만 필터링
                .findAny();                                      //하나라도 찾으면 바로 반환
    //하나라도 찾으며 반환, 그러나 끝까지봣는데 없으면 Optional에 감싸서 반환된다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //values는 멤버들이다(name)
    }

    public void clearStore() { //저장소를 비움
        store.clear();
    }
}
