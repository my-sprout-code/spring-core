package hello.core.singleton;

public class StatefulService {

    private int price;  // 상태가 유지되는 변수

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제가 되는 영역
    }

    public int getPrice() {
        return price;
    }

}
