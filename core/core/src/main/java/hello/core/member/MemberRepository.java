package hello.core.member;

public interface MemberRepository { //메모리디비, 외부데이터베이스
    void save(Member member);
    Member findById(Long memberId);
}
