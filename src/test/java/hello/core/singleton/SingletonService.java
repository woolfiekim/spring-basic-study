package hello.core.singleton;

public class SingletonService {

    // static 영역(이 class)에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //외부에서 조회만 가능 하도록 함.
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private로 선언해서 이 class 내부에서만 쓸 수 있게 함.
    //(외부에서 new를 사용해 객체 생성 못하게 막음)
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
