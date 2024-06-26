package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 1000; //1000원할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) //enum은 ==으로 비교한다
            return discountAmount;
        else
            return 0;
    }
}
