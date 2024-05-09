package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //자동으로 게터세터를 만들어줌
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");
        System.out.println("helloLombok = " + helloLombok);

    }
}
