package MakeWebProject.MakeWebProjectspring.domain;

import jakarta.persistence.*;

@Entity //객체와 디비테이블을 매핑함
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //주요키(PK)
    private Long id;
    //@Column(name="username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
