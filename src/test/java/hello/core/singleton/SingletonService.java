package hello.core.singleton;

public final class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService() {}

    public static final SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
