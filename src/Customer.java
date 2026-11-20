public class Customer {
    private String name;
    private int money;
    private boolean hasCoffee;

    public Customer() {
        name ="";
        money = 0;
        hasCoffee = false;
    }

    public Customer(int money) {
        this.money = money;
        hasCoffee = false;
    }

    public Customer(String name,int money, boolean hasCoffee) {
        this.name = name;
        this.money = money;
        this.hasCoffee = hasCoffee;
    }

    public void print() {
        System.out.println(money);
        System.out.println(hasCoffee);
    }

    //잔액이 부족할 경우 -9반환, 정상일 경우 0반환.
    public int pay(int coffeePrice) {
        if (money <= coffeePrice){
            System.out.println("[손님]" + name + "잔액이 부족합니다.");
        return -9;
    }
        money = money - coffeePrice;
        return 0;
    }

    public void refund(int coffeePrice) {
        money = money + coffeePrice;
        System.out.println("[손님" + name + " " + coffeePrice + "를 환불받았습니다.");
        System.out.print("[손님" + name + " 현재 소지금은" + money + "원 입니다.");
    }

    public void order(Barista barista, String menuName) {

        System.out.println("[손님]" + name + " " + menuName + "를 한 잔 주세요.");
        int price = barista.getCoffeePrice();
        System.out.println("[바리스타] 커피 가격은 " + price + "원 입니다.");

        int paymentCheck = pay(price);
        if(paymentCheck == -9)
            return;
        else if(paymentCheck == 0) {
            System.out.println("[손님]" + name + " " + price + "원을 지불했습니다.");
            String coffee = barista.takeOrder(menuName, price);
            takeCoffee(coffee);
        }

    }

    public void takeCoffee(String coffee) {
        hasCoffee = true;
        System.out.println("[손님]" + name + " " + coffee + "를 받았습니다.");//coffee가 아메리카노로 떠야함
    }

}
