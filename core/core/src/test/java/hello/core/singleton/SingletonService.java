package hello.core.singleton;

public class SingletonService {
    //자기자신을 내부에 static으로 가지고있음(클레스레벨에 올라가므로 1개만 가지게됨)
    //자바가 뜰때 올라가는것으로 1개 바로올라감
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { //private 생성자를 통해 외부접근을 막는다.

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");

    }
}
